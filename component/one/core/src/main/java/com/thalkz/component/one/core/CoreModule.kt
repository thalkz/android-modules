package com.thalkz.component.one.core

import com.thalkz.component.one.lib.OneService
import com.thalkz.foundation.core.Core
import com.thalkz.platform.di.Bindings
import com.thalkz.platform.di.Module
import com.thalkz.platform.di.provide

object CoreOneModule : Module {
    override fun inject() {
        Bindings.provide<OneService, Core> { core ->
            CoreOneService(core)
        }
    }
}
