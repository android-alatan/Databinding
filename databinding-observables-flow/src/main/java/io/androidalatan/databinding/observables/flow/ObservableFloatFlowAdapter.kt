package io.androidalatan.databinding.observables.flow

import androidx.databinding.ObservableFloat
import io.androidalatan.databinding.observables.flow.internal.toFlowOfBaseObservable
import kotlinx.coroutines.flow.Flow

fun ObservableFloat.toFlow(): Flow<Float> {
    return toFlowOfBaseObservable(get()) { (it as ObservableFloat).get() }
}