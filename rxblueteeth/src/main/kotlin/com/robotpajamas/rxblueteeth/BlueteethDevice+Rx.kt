package com.robotpajamas.rxblueteeth

import com.robotpajamas.blueteeth.BlueteethDevice
import com.robotpajamas.blueteeth.models.Device
import io.reactivex.Observable
import java.util.*

// Should this be lazy?
val BlueteethDevice.rx: Reactive<Device>
    get() = Reactive(this)

fun <T> Reactive<T>.connect(): Observable<Boolean> where T : Device {
    return Observable.create { emitter ->
        this.base.connect { isConnected ->
            emitter.onNext(isConnected)
        }

        emitter.setCancellable { /* TODO? */ }
    }
}

fun <T> Reactive<T>.discoverServices(): Observable<Boolean> where T : Device {
    return Observable.create { emitter ->
        this.base.discoverServices { result ->
            result.onFailure {
                emitter.onError(it)
            }
            result.onSuccess {
                emitter.onNext(it)
                emitter.onComplete()
            }
        }

        emitter.setCancellable { /* TODO? */ }
    }
}

// Maybe this should be a Single/Completable vs Observable?
fun <T> Reactive<T>.read(characteristic: UUID, service: UUID): Observable<ByteArray> where T : Device {
    return Observable.create { emitter ->
        this.base.read(characteristic, service) { result ->
            result.onFailure {
                emitter.onError(it)
            }
            result.onSuccess {
                emitter.onNext(it)
                emitter.onComplete()
            }
        }

        emitter.setCancellable { /* TODO? */ }
    }
}
