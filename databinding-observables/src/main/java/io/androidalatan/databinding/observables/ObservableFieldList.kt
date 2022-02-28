package io.androidalatan.databinding.observables

import androidx.databinding.ObservableField

class ObservableFieldList<T>(value: List<T> = emptyList()) : ObservableField<List<T>>(value) {
    override fun set(value: List<T>?) {
        val safeValue = value ?: emptyList()
        super.set(safeValue)
    }

    override fun get(): List<T> = super.get() ?: emptyList()
}