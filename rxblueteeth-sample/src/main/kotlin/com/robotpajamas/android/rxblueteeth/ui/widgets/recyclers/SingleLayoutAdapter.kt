package com.robotpajamas.android.rxblueteeth.ui.widgets.recyclers

abstract class SingleLayoutAdapter(private val layoutId: Int) : ViewAdapter() {
    override fun getLayoutId(position: Int): Int {
        return layoutId
    }
}
