package io.androidalatan.databinding.observables.flow

import androidx.databinding.ObservableLong
import io.androidalatan.databinding.observables.flow.internal.toFlowOfBaseObservable
import kotlinx.coroutines.flow.Flow

fun ObservableLong.toFlow(): Flow<Long> {
    return toFlowOfBaseObservable(get()) { (it as ObservableLong).get() }
}