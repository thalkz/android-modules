package com.thalkz.foundation.core

data class CoreItemOne(val value: String)

data class CoreItemTwo(val value: String)

class Core {
    fun getCoreOne(): CoreItemOne {
        return CoreItemOne("1")
    }

    fun getCoreTwoUpdated(): CoreItemTwo {
        return CoreItemTwo("2")
    }
}
