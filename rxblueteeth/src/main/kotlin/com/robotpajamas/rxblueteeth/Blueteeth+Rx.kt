package com.robotpajamas.rxblueteeth

import com.robotpajamas.blueteeth.Blueteeth
import com.robotpajamas.blueteeth.BlueteethDevice
import com.robotpajamas.blueteeth.models.Device
import io.reactivex.Observable
import java.util.*

val Blueteeth.rx: Reactive<Blueteeth>
    get() = Reactive(this)

fun <T> Reactive<T>.scan(): Observable<Device> where T : Blueteeth {
    return Observable.create { emitter ->
        base.scanForPeripherals()
        emitter.setCancellable { base.stopScanForPeripherals() }
    }
}
