package com.xinruan.mvvmdemo.ui.actitivty.list

import android.util.Log
import com.google.gson.Gson
import com.xinruan.mvvmbase.vm.MVVMBaseViewModel
import com.xinruan.mvvmdemo.databinding.ActivityListBinding
import com.xinruan.netbase_api.ResultState

class ListActivtyViewModel : MVVMBaseViewModel<ListModel, ActivityListBinding>(),
    ResultState<ArrayList<String>> {
    var adapter = ListAdapter()

    init {
        model = ListModel()
    }


    fun getData() {
        lisnter.showLoading()
        request(1, { model.getData() }, { id, t -> loadedSuc(id, t) }, { id, throwable ->
            loadedFail(id, throwable)
        })
    }

    override fun loadedSuc(requestId: Int, t: ArrayList<String>) {
        lisnter.showContent()
        Log.e("hekai", "---------$requestId-> ${Gson().toJson(t)}")
        adapter.addList(t)
    }

    override fun loadedFail(requestId: Int, throwable: Throwable) {

    }
}