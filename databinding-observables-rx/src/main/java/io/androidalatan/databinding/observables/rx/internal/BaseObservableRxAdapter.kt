package io.androidalatan.databinding.observables.rx.internal

import androidx.databinding.BaseObservable
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

internal fun <T> BaseObservable.toObservableOfBaseObservable(
    defaultValue: T?,
    typeCasting: (androidx.databinding.Observable) -> T?
): Observable<T> {
    return Observable.create { emitter ->
        val callback = object : androidx.databinding.Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: androidx.databinding.Observable?, propertyId: Int) {
                if (sender != null) {
                    typeCasting(sender)?.let { emitter.onNext(it) }
                }
            }
        }
        addOnPropertyChangedCallback(callback)

        if (defaultValue != null) {
            emitter.onNext(defaultValue)
        }

        emitter.setCancellable { removeOnPropertyChangedCallback(callback) }
    }
}

internal fun <T> BaseObservable.toFlowableOfBaseObservable(
    defaultValue: T?,
    typeCasting: (androidx.databinding.Observable) -> T?
): Flowable<T> {
    return Flowable.create(
        { emitter ->
            val callback = object : androidx.databinding.Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: androidx.databinding.Observable?, propertyId: Int) {
                    if (sender != null) {
                        typeCasting(sender)?.let { emitter.onNext(it) }

                    }
                }
            }
            addOnPropertyChangedCallback(callback)

            if (defaultValue != null) {
                emitter.onNext(defaultValue)
            }

            emitter.setCancellable { removeOnPropertyChangedCallback(callback) }
        }, BackpressureStrategy.LATEST
    )
}

internal fun <T> BaseObservable.toSingleOfBaseObservable(
    defaultValue: T?,
    typeCasting: (androidx.databinding.Observable) -> T?
): Single<T> {
    return Single.create { emitter ->
        if (defaultValue != null) {
            emitter.onSuccess(defaultValue)
            return@create
        }

        val callback = object : androidx.databinding.Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: androidx.databinding.Observable?, propertyId: Int) {
                if (sender != null) {
                    typeCasting(sender)?.let { emitter.onSuccess(it) }
                }
            }
        }
        addOnPropertyChangedCallback(callback)
        emitter.setCancellable { removeOnPropertyChangedCallback(callback) }
    }
}

internal fun <T> BaseObservable.toMaybeOfBaseObservable(defaultValue: T?): Maybe<T> {
    return Maybe.create { emitter ->
        if (defaultValue != null) {
            emitter.onSuccess(defaultValue)
        } else {
            emitter.onComplete()
        }
    }
}