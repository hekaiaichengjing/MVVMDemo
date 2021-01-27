package com.xinruan.mvvmbase.vm

open class BaseModel {
    private lateinit var modelLister: IBaseModelLisnter
    fun register(modelLister: IBaseModelLisnter) {
        this.modelLister = modelLister
    }

    fun loadSuc(requestId: Int, any: Any) {
        modelLister?.loadSuc(requestId, any)
    }

}