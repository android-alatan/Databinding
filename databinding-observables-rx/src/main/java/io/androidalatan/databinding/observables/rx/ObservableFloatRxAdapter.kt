package io.androidalatan.databinding.observables.rx

import androidx.databinding.ObservableFloat
import io.androidalatan.databinding.observables.rx.internal.toFlowableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toMaybeOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toObservableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toSingleOfBaseObservable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

fun ObservableFloat.toObservable(): Observable<Float> {
    return toObservableOfBaseObservable(get()) { sender -> (sender as ObservableFloat).get() }
}

fun ObservableFloat.toSingle(): Single<Float> {
    return toSingleOfBaseObservable(get()) { sender -> (sender as ObservableFloat).get() }
}

fun ObservableFloat.toMaybe(): Maybe<Float> {
    return toMaybeOfBaseObservable(get())
}

fun ObservableFloat.toFlowable(): Flowable<Float> {
    return toFlowableOfBaseObservable(get()) { sender -> (sender as ObservableFloat).get() }
}