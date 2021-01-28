package com.xinruan.mvvmbase

//点击事件的基类 继承该类 可以做一些点击前后的事情
interface BaseClickEvent {
     fun beforeClick(block: () -> Unit)

}