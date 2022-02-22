package io.androidalatan.databinding.observables.flow

import android.view.View
import io.androidalatan.databinding.observables.ObservableVisibleGone
import io.androidalatan.databinding.observables.flow.internal.toFlowOfBaseObservable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun ObservableVisibleGone.toFlow(): Flow<Boolean> {
    return toFlowOfBaseObservable(get()) { (it as ObservableVisibleGone).get() }
        .map { it == View.VISIBLE }
}