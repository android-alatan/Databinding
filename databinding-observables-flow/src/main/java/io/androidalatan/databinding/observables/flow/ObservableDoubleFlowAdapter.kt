package io.androidalatan.databinding.observables.flow

import androidx.databinding.ObservableDouble
import io.androidalatan.databinding.observables.flow.internal.toFlowOfBaseObservable
import kotlinx.coroutines.flow.Flow

fun ObservableDouble.toFlow(): Flow<Double> {
    return toFlowOfBaseObservable(get()) { (it as ObservableDouble).get() }
}