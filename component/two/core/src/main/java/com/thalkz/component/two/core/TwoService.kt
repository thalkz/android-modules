package com.thalkz.component.two.core

import com.thalkz.component.two.ItemTwo
import com.thalkz.component.two.lib.TwoService
import com.thalkz.foundation.core.Core
import com.thalkz.foundation.core.CoreItemTwo

class CoreTwoService(val core: Core) : TwoService {
    override fun getTwo(): ItemTwo {
        return core.getCoreTwoUpdated().toTwo()
    }
}

fun CoreItemTwo.toTwo() = ItemTwo(value)
