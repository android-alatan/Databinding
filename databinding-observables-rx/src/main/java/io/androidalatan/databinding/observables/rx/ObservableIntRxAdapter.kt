package io.androidalatan.databinding.observables.rx

import androidx.databinding.ObservableInt
import io.androidalatan.databinding.observables.rx.internal.toFlowableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toMaybeOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toObservableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toSingleOfBaseObservable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

fun ObservableInt.toObservable(): Observable<Int> {
    return toObservableOfBaseObservable(get()) { sender -> (sender as ObservableInt).get() }
}

fun ObservableInt.toSingle(): Single<Int> {
    return toSingleOfBaseObservable(get()) { sender -> (sender as ObservableInt).get() }
}

fun ObservableInt.toMaybe(): Maybe<Int> {
    return toMaybeOfBaseObservable(get())
}

fun ObservableInt.toFlowable(): Flowable<Int> {
    return toFlowableOfBaseObservable(get()) { sender -> (sender as ObservableInt).get() }
}