package io.androidalatan.databinding.observables.rx

import androidx.databinding.ObservableField
import io.androidalatan.databinding.observables.rx.internal.toFlowableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toMaybeOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toObservableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toSingleOfBaseObservable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

fun <T> ObservableField<T>.toObservable(): Observable<T> {
    return toObservableOfBaseObservable(get()) { sender -> (sender as ObservableField<T>).get() }
}

fun <T> ObservableField<T>.toSingle(): Single<T> {
    return toSingleOfBaseObservable(get()) { sender -> (sender as ObservableField<T>).get() }
}

fun <T> ObservableField<T>.toMaybe(): Maybe<T> {
    return toMaybeOfBaseObservable(get())
}

fun <T> ObservableField<T>.toFlowable(): Flowable<T> {
    return toFlowableOfBaseObservable(get()) { sender -> (sender as ObservableField<T>).get() }
}