package com.thalkz.component.two.core

import com.thalkz.component.two.lib.TwoService
import com.thalkz.foundation.core.Core
import com.thalkz.platform.di.Bindings
import com.thalkz.platform.di.Module
import com.thalkz.platform.di.provide

object CoreTwoModule : Module {
    override fun inject() {
        Bindings.provide<TwoService, Core> { core ->
            CoreTwoService(core)
        }
    }
}
