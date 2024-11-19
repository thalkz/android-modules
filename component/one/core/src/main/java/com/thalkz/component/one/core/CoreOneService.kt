package com.thalkz.component.one.core

import com.thalkz.component.one.ItemOne
import com.thalkz.component.one.lib.OneService
import com.thalkz.foundation.core.Core
import com.thalkz.foundation.core.CoreItemOne

class CoreOneService(val core: Core) : OneService {
    override fun getOne(): ItemOne {
        return core.getCoreOne().toOne()
    }
}

fun CoreItemOne.toOne() = ItemOne(value)
