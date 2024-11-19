package com.thalkz.foundation.core

import com.thalkz.platform.di.Bindings
import com.thalkz.platform.di.Module
import com.thalkz.platform.di.provide

object CoreModule : Module {
    override fun inject() {
        Bindings.provide<Core> { Core() }
    }
}

