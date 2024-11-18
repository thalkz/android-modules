package com.thalkz.component.one.bindings

import com.thalkz.component.one.OneRepository
import com.thalkz.component.one.core.OneService
import com.thalkz.component.one.lib.DefaultOneRepository
import com.thalkz.foundation.core.CoreModule

object OneModule {
    val service = OneService(
        core = CoreModule.provideCore()
    )

    val repository = DefaultOneRepository(
        service = provideOneService()
    )

    fun provideOneRepository(): OneRepository = repository

    fun provideOneService(): OneService = service
}
