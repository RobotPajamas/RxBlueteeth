package com.robotpajamas.blueteeth

import io.reactivex.Observable
import java.util.*

class Reactive<Base>(val base: Base)

val BlueteethDevice.rx: Reactive<BlueteethDevice>
    get() = Reactive(this)

fun <T> Reactive<T>.connect(): Observable<Boolean> where T : BlueteethDevice {
    return Observable.create { emitter ->
        this.base.connect { isConnected ->
            emitter.onNext(isConnected)
        }

        emitter.setCancellable { /* TODO? */ }
    }
}

fun <T> Reactive<T>.discoverServices(): Observable<Boolean> where T : BlueteethDevice {
    return Observable.create { emitter ->
        this.base.discoverServices { result ->
            result.failure {
                emitter.onError(it)
            }
            result.success {
                emitter.onNext(it)
                emitter.onComplete()
            }
        }

        emitter.setCancellable { /* TODO? */ }
    }
}

// Maybe this should be a Single/Completable vs Observable?
fun <T> Reactive<T>.read(characteristic: UUID, service: UUID): Observable<ByteArray> where T : BlueteethDevice {
    return Observable.create { emitter ->
        this.base.read(characteristic, service) { result ->
            result.failure {
                emitter.onError(it)
            }
            result.success {
                emitter.onNext(it)
                emitter.onComplete()
            }
        }

        emitter.setCancellable { /* TODO? */ }
    }
}
