package com.robotpajamas.android.rxblueteeth.ui.scan

import com.robotpajamas.android.rxblueteeth.R
import com.robotpajamas.android.rxblueteeth.ui.widgets.recyclers.SingleLayoutAdapter

class DeviceScanAdapter(items: List<ScannedDeviceViewModel> = emptyList()) : SingleLayoutAdapter(R.layout.item_scanned_device) {
    override var items: List<Any> = items

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getObj(position: Int): Any {
        return items[position]
    }
}
