package io.androidalatan.databinding.observables

import android.view.View
import androidx.databinding.ObservableInt

class ObservableVisibleGone(defaultValue: Boolean = false) : ObservableInt(if (defaultValue) View.VISIBLE else View.GONE) {

    override fun set(value: Int) {
        when (value) {
            View.VISIBLE, View.GONE -> super.set(value)
        }
    }

    fun setVisible(visibility: Boolean) {
        set(if (visibility) View.VISIBLE else View.GONE)
    }

    fun isVisible() = get() == View.VISIBLE
}