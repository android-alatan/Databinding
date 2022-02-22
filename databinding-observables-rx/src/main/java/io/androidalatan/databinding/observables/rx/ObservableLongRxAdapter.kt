package io.androidalatan.databinding.observables.rx

import androidx.databinding.ObservableLong
import io.androidalatan.databinding.observables.rx.internal.toFlowableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toMaybeOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toObservableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toSingleOfBaseObservable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

fun ObservableLong.toObservable(): Observable<Long> {
    return toObservableOfBaseObservable(get()) { sender -> (sender as ObservableLong).get() }
}

fun ObservableLong.toSingle(): Single<Long> {
    return toSingleOfBaseObservable(get()) { sender -> (sender as ObservableLong).get() }
}

fun ObservableLong.toMaybe(): Maybe<Long> {
    return toMaybeOfBaseObservable(get())
}

fun ObservableLong.toFlowable(): Flowable<Long> {
    return toFlowableOfBaseObservable(get()) { sender -> (sender as ObservableLong).get() }
}