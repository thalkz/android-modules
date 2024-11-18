package com.thalkz.foundation.core

object CoreModule {
    private val core = Core()

    fun provideCore(): Core = core
}

