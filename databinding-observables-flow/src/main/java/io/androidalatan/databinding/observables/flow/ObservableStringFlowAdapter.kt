package io.androidalatan.databinding.observables.flow

import io.androidalatan.databinding.observables.ObservableString
import io.androidalatan.databinding.observables.flow.internal.toFlowOfBaseObservable
import kotlinx.coroutines.flow.Flow

fun ObservableString.toFlow(): Flow<String> {
    return toFlowOfBaseObservable(get()) { (it as ObservableString).get() }
}