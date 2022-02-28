package io.androidalatan.databinding.observables

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ObservableStringTest {

    private val observable = ObservableString()

    @Test
    fun `set and set`() {
        observable.set(null)
        Assertions.assertEquals("", observable.get())

        val value = "hello"
        observable.set(value)
        Assertions.assertEquals(value, observable.get())
    }

}