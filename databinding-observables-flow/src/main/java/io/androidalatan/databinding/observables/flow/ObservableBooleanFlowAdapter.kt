package io.androidalatan.databinding.observables.flow

import androidx.databinding.ObservableBoolean
import io.androidalatan.databinding.observables.flow.internal.toFlowOfBaseObservable
import kotlinx.coroutines.flow.Flow

fun ObservableBoolean.toFlow(): Flow<Boolean> {
    return toFlowOfBaseObservable(get()) { (it as ObservableBoolean).get() }
}