package com.thalkz.component.two.bindings

import com.thalkz.component.one.bindings.OneModule
import com.thalkz.component.two.TwoRepository
import com.thalkz.component.two.core.TwoService
import com.thalkz.component.two.lib.DefaultTwoRepository
import com.thalkz.foundation.core.CoreModule

object TwoModule {
    val service = TwoService(
        core = CoreModule.provideCore()
    )

    val repository = DefaultTwoRepository(
        service = provideTwoService(),
        oneRepository = OneModule.provideOneRepository(),
    )

    fun provideTwoRepository(): TwoRepository = repository

    fun provideTwoService(): TwoService = service
}
