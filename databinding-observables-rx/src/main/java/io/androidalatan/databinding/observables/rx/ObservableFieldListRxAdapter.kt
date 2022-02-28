package io.androidalatan.databinding.observables.rx

import io.androidalatan.databinding.observables.ObservableFieldList
import io.androidalatan.databinding.observables.rx.internal.toFlowableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toMaybeOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toObservableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toSingleOfBaseObservable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

fun <T> ObservableFieldList<T>.toObservable(): Observable<List<T>> {
    return toObservableOfBaseObservable(get()) { sender -> (sender as ObservableFieldList<T>).get() }
}

fun <T> ObservableFieldList<T>.toSingle(): Single<List<T>> {
    return toSingleOfBaseObservable(get()) { sender -> (sender as ObservableFieldList<T>).get() }
}

fun <T> ObservableFieldList<T>.toMaybe(): Maybe<List<T>> {
    return toMaybeOfBaseObservable(get())
}

fun <T> ObservableFieldList<T>.toFlowable(): Flowable<List<T>> {
    return toFlowableOfBaseObservable(get()) { sender -> (sender as ObservableFieldList<T>).get() }
}