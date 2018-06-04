package com.robotpajamas.android.rxblueteeth.ui.scan

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.robotpajamas.android.rxblueteeth.BR

class ScannedDeviceViewModel(name: String = "name",
                             mac: String = "mac") : BaseObservable() {

    @Bindable
    var name = name
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @Bindable
    var mac = mac
        set(value) {
            field = value
            notifyPropertyChanged(BR.mac)
        }
}