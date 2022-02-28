package io.androidalatan.databinding.observables.flow

import io.androidalatan.databinding.observables.ObservableFieldList
import io.androidalatan.databinding.observables.flow.internal.toFlowOfBaseObservable
import kotlinx.coroutines.flow.Flow

fun <T> ObservableFieldList<T>.toFlow(): Flow<List<T>> {
    return toFlowOfBaseObservable(get()) { (it as ObservableFieldList<T>).get() }
}