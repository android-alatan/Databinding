package io.androidalatan.databinding.observables

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ObservableFieldListTest {

    private val observable = ObservableFieldList<Int>()

    @Test
    fun `set and set`() {
        val value = listOf(1, 2, 3)
        observable.set(value)
        Assertions.assertEquals(value, observable.get())

        observable.set(null)
        Assertions.assertEquals(emptyList<Int>(), observable.get())
    }
}