package com.thalkz.component.one.core

import com.thalkz.component.one.ItemOne
import com.thalkz.foundation.core.Core
import com.thalkz.foundation.core.CoreItemOne

class OneService(val core: Core) {
    fun getOne(): ItemOne {
        return core.getCoreOneNew().toOne()
    }
}

fun CoreItemOne.toOne() = ItemOne(value)
