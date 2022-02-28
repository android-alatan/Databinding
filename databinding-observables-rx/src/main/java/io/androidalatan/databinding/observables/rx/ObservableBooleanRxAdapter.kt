package io.androidalatan.databinding.observables.rx

import androidx.databinding.ObservableBoolean
import io.androidalatan.databinding.observables.rx.internal.toFlowableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toMaybeOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toObservableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toSingleOfBaseObservable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

fun ObservableBoolean.toObservable(): Observable<Boolean> {
    return toObservableOfBaseObservable(get()) { sender -> (sender as ObservableBoolean).get() }
}

fun ObservableBoolean.toSingle(): Single<Boolean> {
    return toSingleOfBaseObservable(get()) { sender -> (sender as ObservableBoolean).get() }
}

fun ObservableBoolean.toMaybe(): Maybe<Boolean> {
    return toMaybeOfBaseObservable(get())
}

fun ObservableBoolean.toFlowable(): Flowable<Boolean> {
    return toFlowableOfBaseObservable(get()) { sender -> (sender as ObservableBoolean).get() }
}