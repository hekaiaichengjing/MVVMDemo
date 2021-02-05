package com.xinruan.mvvmdemo.ui.actitivty.download

import androidx.databinding.ObservableInt
import com.liulishuo.filedownloader.BaseDownloadTask
import com.liulishuo.filedownloader.FileDownloadListener
import com.liulishuo.filedownloader.FileDownloader
import com.xinruan.mvvmbase.vm.BaseModel
import com.xinruan.mvvmbase.vm.MVVMBaseViewModel
import com.xinruan.mvvmdemo.databinding.ActivityDownloadBinding
import java.io.File

class DownLoadViewModel : MVVMBaseViewModel<BaseModel, ActivityDownloadBinding>() {
    var progress = ObservableInt(0)
    fun toDownLoad() {
        FileDownloader.getImpl()
            .create("https://apd.shouji.com.cn/cdn/soft1/shouji/zq6/com.taobao.taobao_V9.20.0.apk")
            .setForceReDownload(true)
            .setCallbackProgressTimes(300)
            .setMinIntervalUpdateSpeed(400)
            .setPath(
                File(
                    dataBinding.root.context.externalCacheDir,
                    "com.xinruan.apk"
                ).absolutePath
            )
            .setListener(object : FileDownloadListener() {
                override fun pending(task: BaseDownloadTask, soFarBytes: Int, totalBytes: Int) {}
                override fun connected(
                    task: BaseDownloadTask,
                    etag: String,
                    isContinue: Boolean,
                    soFarBytes: Int,
                    totalBytes: Int
                ) {

                }

                override fun progress(task: BaseDownloadTask, soFarBytes: Int, totalBytes: Int) {
                    progress.set((soFarBytes * 1f / totalBytes * 100).toInt())
                    println("----------soFarBytes----> $soFarBytes --------totalBytes---$totalBytes")
                }

                override fun blockComplete(task: BaseDownloadTask) {

                }

                override fun retry(
                    task: BaseDownloadTask,
                    ex: Throwable,
                    retryingTimes: Int,
                    soFarBytes: Int
                ) {

                }

                override fun completed(task: BaseDownloadTask) {
                    progress.set(100)

                    println("------------下载文件地址-->${task.filename}")
                }

                override fun paused(task: BaseDownloadTask, soFarBytes: Int, totalBytes: Int) {

                }

                override fun error(task: BaseDownloadTask, e: Throwable) {
                    println("------------下载报错-->")
                    e.printStackTrace()
                }

                override fun warn(task: BaseDownloadTask) {

                }
            }).start()
    }
}