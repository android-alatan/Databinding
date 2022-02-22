package io.androidalatan.databinding.observables.flow.internal

import androidx.databinding.BaseObservable
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

internal fun <T> BaseObservable.toFlowOfBaseObservable(
    defaultValue: T?,
    typeCasting: (androidx.databinding.Observable) -> T?
): Flow<T> {
    return callbackFlow {
        val callback = object : androidx.databinding.Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: androidx.databinding.Observable?, propertyId: Int) {
                if (sender != null) {
                    typeCasting(sender)?.let { trySend(it) }
                }
            }
        }
        addOnPropertyChangedCallback(callback)

        if (defaultValue != null) {
            trySend(defaultValue)
        }

        awaitClose { removeOnPropertyChangedCallback(callback) }
    }
}