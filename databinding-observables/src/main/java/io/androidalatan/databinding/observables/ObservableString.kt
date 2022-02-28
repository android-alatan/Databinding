package io.androidalatan.databinding.observables

import androidx.databinding.ObservableField

class ObservableString(defaultValue: String = "") : ObservableField<String>(defaultValue) {

    override fun set(value: String?) {
        val safeValue = value ?: ""
        super.set(safeValue)
    }

    override fun get(): String = super.get() ?: ""
}