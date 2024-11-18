package com.thalkz.component.one

data class ItemOne(val value: String)

interface OneRepository {
    fun getOne(): ItemOne
}
