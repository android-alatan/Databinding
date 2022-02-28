package io.androidalatan.databinding.observables.flow

import androidx.databinding.ObservableField
import io.androidalatan.databinding.observables.flow.internal.toFlowOfBaseObservable
import kotlinx.coroutines.flow.Flow

fun <T> ObservableField<T>.toFlow(): Flow<T> {
    return toFlowOfBaseObservable(get()) { (it as ObservableField<T>).get() }
}