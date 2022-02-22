package io.androidalatan.databinding.observables.rx

import android.view.View
import io.androidalatan.databinding.observables.ObservableVisibleGone
import io.androidalatan.databinding.observables.rx.internal.toFlowableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toMaybeOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toObservableOfBaseObservable
import io.androidalatan.databinding.observables.rx.internal.toSingleOfBaseObservable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

fun ObservableVisibleGone.toObservable(): Observable<Boolean> {
    return toObservableOfBaseObservable(get()) { sender -> (sender as ObservableVisibleGone).get() }
        .map { it == View.VISIBLE }
}

fun ObservableVisibleGone.toSingle(): Single<Boolean> {
    return toSingleOfBaseObservable(get()) { sender -> (sender as ObservableVisibleGone).get() }
        .map { it == View.VISIBLE }
}

fun ObservableVisibleGone.toMaybe(): Maybe<Boolean> {
    return toMaybeOfBaseObservable(get())
        .map { it == View.VISIBLE }
}

fun ObservableVisibleGone.toFlowable(): Flowable<Boolean> {
    return toFlowableOfBaseObservable(get()) { sender -> (sender as ObservableVisibleGone).get() }
        .map { it == View.VISIBLE }
}