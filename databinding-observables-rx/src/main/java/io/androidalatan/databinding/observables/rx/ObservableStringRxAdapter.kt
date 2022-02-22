package io.androidalatan.databinding.observables.rx

import io.androidalatan.databinding.observables.ObservableString
import io.androidalatan.databinding.observables.rx.internal.toFlowableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toMaybeOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toObservableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toSingleOfBaseObservable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

fun ObservableString.toObservable(): Observable<String> {
    return toObservableOfBaseObservable(get()) { sender -> (sender as ObservableString).get() }
}

fun ObservableString.toSingle(): Single<String> {
    return toSingleOfBaseObservable(get()) { sender -> (sender as ObservableString).get() }
}

fun ObservableString.toMaybe(): Maybe<String> {
    return toMaybeOfBaseObservable(get())
}

fun ObservableString.toFlowable(): Flowable<String> {
    return toFlowableOfBaseObservable(get()) { sender -> (sender as ObservableString).get() }
}