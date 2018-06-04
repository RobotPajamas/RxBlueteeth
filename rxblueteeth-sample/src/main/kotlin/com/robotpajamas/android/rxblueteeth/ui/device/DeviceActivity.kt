package com.robotpajamas.android.rxblueteeth.ui.device

import android.app.Activity
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.robotpajamas.android.rxblueteeth.R
import com.robotpajamas.android.rxblueteeth.databinding.ActivityDeviceBinding

class DeviceActivity : Activity(),
        DeviceViewModel.Navigator {

    private val vm by lazy {
        val macAddress = intent.getStringExtra(getString(R.string.extra_mac_address)) ?: ""
        DeviceViewModel(macAddress, this)
    }
    private lateinit var binding: ActivityDeviceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_device)
        binding.vm = vm
    }

    override fun onDestroy() {
        super.onDestroy()
//        mSamplePeripheral?.close()
    }


    override fun navigateBack() {

    }
}
