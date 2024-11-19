package com.thalkz.component.one.lib

import com.thalkz.component.one.ItemOne
import com.thalkz.component.one.OneRepository

class DefaultOneRepository(
    val service: OneService,
) : OneRepository {

    override fun getOne(): ItemOne {
        return service.getOne()
    }
}
