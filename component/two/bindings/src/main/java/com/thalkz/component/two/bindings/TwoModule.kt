package com.thalkz.component.two.bindings

import com.thalkz.component.one.lib.OneService
import com.thalkz.component.two.TwoRepository
import com.thalkz.component.two.lib.DefaultTwoRepository
import com.thalkz.component.two.lib.TwoService
import com.thalkz.platform.di.Bindings
import com.thalkz.platform.di.Module
import com.thalkz.platform.di.provide

object TwoModule : Module {
    override fun inject() {
        Bindings.provide<TwoRepository, OneService, TwoService> { oneService, twoService ->
            DefaultTwoRepository(oneService, twoService)
        }
    }
}
