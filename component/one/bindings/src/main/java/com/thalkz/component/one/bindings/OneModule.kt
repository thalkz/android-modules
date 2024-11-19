package com.thalkz.component.one.bindings

import com.thalkz.component.one.OneRepository
import com.thalkz.component.one.lib.DefaultOneRepository
import com.thalkz.component.one.lib.OneService
import com.thalkz.platform.di.Bindings
import com.thalkz.platform.di.Module
import com.thalkz.platform.di.provide

object OneModule : Module {
    override fun inject() {
        Bindings.provide<OneRepository, OneService> { service -> DefaultOneRepository(service) }
    }
}
