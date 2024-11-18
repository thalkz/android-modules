package com.thalkz.component.two.lib

import com.thalkz.component.one.ItemOne
import com.thalkz.component.one.OneRepository
import com.thalkz.component.two.ItemTwo
import com.thalkz.component.two.TwoRepository
import com.thalkz.component.two.core.TwoService

class DefaultTwoRepository(
    val service: TwoService,
    val oneRepository: OneRepository,
) : TwoRepository {

    override fun getTwo(): ItemTwo {
        return service.getTwo()
    }

    override fun getOneAndTwo(): Pair<ItemOne, ItemTwo> {
        val one = oneRepository.getOne()
        val two = getTwo()
        return one to two
    }
}
