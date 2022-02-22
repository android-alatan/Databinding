package io.androidalatan.databinding.observables.rx

import androidx.databinding.ObservableDouble
import io.androidalatan.databinding.observables.rx.internal.toFlowableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toMaybeOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toObservableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toSingleOfBaseObservable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

fun ObservableDouble.toObservable(): Observable<Double> {
    return toObservableOfBaseObservable(get()) { sender -> (sender as ObservableDouble).get() }
}

fun ObservableDouble.toSingle(): Single<Double> {
    return toSingleOfBaseObservable(get()) { sender -> (sender as ObservableDouble).get() }
}

fun ObservableDouble.toMaybe(): Maybe<Double> {
    return toMaybeOfBaseObservable(get())
}

fun ObservableDouble.toFlowable(): Flowable<Double> {
    return toFlowableOfBaseObservable(get()) { sender -> (sender as ObservableDouble).get() }
}