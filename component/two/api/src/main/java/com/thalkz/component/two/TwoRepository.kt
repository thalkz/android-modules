package com.thalkz.component.two

import com.thalkz.component.one.ItemOne

data class ItemTwo(val value: String)

interface TwoRepository {
    fun getTwo(): ItemTwo
    fun getOneAndTwo(): Pair<ItemOne, ItemTwo>
}
