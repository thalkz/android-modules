package com.thalkz.component.two.lib

import com.thalkz.component.one.ItemOne
import com.thalkz.component.one.lib.OneService
import com.thalkz.component.two.ItemTwo
import com.thalkz.component.two.TwoRepository

class DefaultTwoRepository(
    val oneService: OneService,
    val twoService: TwoService,
) : TwoRepository {

    override fun getTwo(): ItemTwo {
        return twoService.getTwo()
    }

    override fun getOneAndTwo(): Pair<ItemOne, ItemTwo> {
        val one = oneService.getOne()
        val two = getTwo()
        return one to two
    }
}
