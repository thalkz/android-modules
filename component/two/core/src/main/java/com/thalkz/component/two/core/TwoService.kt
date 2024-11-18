package com.thalkz.component.two.core

import com.thalkz.component.two.ItemTwo
import com.thalkz.foundation.core.Core
import com.thalkz.foundation.core.CoreItemTwo

class TwoService(val core: Core) {
    fun getTwo(): ItemTwo {
        return core.getCoreTwoUpdated().toTwo()
    }
}

fun CoreItemTwo.toTwo() = ItemTwo(value)
