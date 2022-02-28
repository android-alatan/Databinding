package io.androidalatan.databinding.observables

import android.view.View
import androidx.databinding.Observable
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ObservableVisibleGoneTest {

    private val visible = ObservableVisibleGone(false)

    @Test
    fun set() {
        visible.set(-10)
        Assertions.assertNotEquals(visible.get(), -10)

        visible.set(View.VISIBLE)
        Assertions.assertEquals(visible.get(), View.VISIBLE)
    }

    @Test
    fun `getVisible gone`() {
        visible.setVisible(false)
        Assertions.assertEquals(View.GONE, visible.get())
    }

    @Test
    fun `getVisible visible`() {
        visible.setVisible(true)
        Assertions.assertEquals(View.VISIBLE, visible.get())
    }

    @Test
    fun react() {
        visible.setVisible(true)
        var count = 0
        val callback = object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                count++
            }
        }
        visible.addOnPropertyChangedCallback(callback)

        visible.setVisible(false)
        Assertions.assertEquals(1, count)

        count = 0
        visible.removeOnPropertyChangedCallback(callback)
        visible.setVisible(true)
        Assertions.assertEquals(0, count)
    }
}