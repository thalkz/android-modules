package com.thalkz.platform.di

import com.thalkz.platform.di.Provider.Provider0
import com.thalkz.platform.di.Provider.Provider1
import com.thalkz.platform.di.Provider.Provider2
import kotlin.reflect.KClass

sealed interface Provider {
    class Provider0(
        val provide: () -> Any,
    ) : Provider

    class Provider1<A : Any>(
        val arg1: KClass<A>,
        val provide: (A) -> Any,
    ) : Provider

    class Provider2<A : Any, B : Any>(
        val arg1: KClass<A>,
        val arg2: KClass<B>,
        val provide: (A, B) -> Any,
    ) : Provider
}

@Suppress("UNCHECKED_CAST")
object Bindings {
    private val providers = mutableMapOf<KClass<out Any>, Provider>()

    fun <T : Any> provide(type: KClass<T>, provide: () -> T) {
        providers.put(type, Provider0(provide))
    }

    fun <T : Any, A : Any> provide(
        type: KClass<T>,
        arg1: KClass<A>,
        provide: (A) -> T,
    ) {
        providers.put(type, Provider1(arg1, provide))
    }

    fun <T : Any, A : Any, B : Any> provide(
        type: KClass<T>,
        arg1: KClass<A>,
        arg2: KClass<B>,
        provide: (A, B) -> T,
    ) {
        providers.put(type, Provider2(arg1, arg2, provide))
    }

    fun <T : Any> get(type: KClass<T>): T {
        val provider = providers[type]
        return when (provider) {
            is Provider0 -> provider.provide() as T

            is Provider1<out Any> -> {
                val arg1 = get(provider.arg1)
                val castedProvide = provider.provide as ((Any) -> Any)
                castedProvide(arg1) as T
            }

            is Provider2<out Any, out Any> -> {
                val arg1 = get(provider.arg1)
                val arg2 = get(provider.arg2)
                val castedProvide = provider.provide as ((Any, Any) -> Any)
                castedProvide(arg1, arg2) as T
            }

            else -> throw Exception("provider not handled, got $provider for key=$type")
        }
    }
}

inline fun <reified T : Any> Bindings.get(): T {
    return get(T::class)
}

inline fun <reified T : Any> Bindings.provide(noinline provide: () -> T) {
    return provide(T::class, provide)
}

inline fun <reified T : Any, reified A : Any> Bindings.provide(noinline provide: (A) -> T) {
    return provide(T::class, A::class, provide)
}

inline fun <reified T : Any, reified A : Any, reified B : Any> Bindings.provide(noinline provide: (A, B) -> T) {
    return provide(T::class, A::class, B::class, provide)
}

