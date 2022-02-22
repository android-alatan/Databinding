package io.androidalatan.databinding.observables.flow

import androidx.databinding.ObservableInt
import io.androidalatan.databinding.observables.flow.internal.toFlowOfBaseObservable
import kotlinx.coroutines.flow.Flow

fun ObservableInt.toFlow(): Flow<Int> {
    return toFlowOfBaseObservable(get()) { (it as ObservableInt).get() }
}