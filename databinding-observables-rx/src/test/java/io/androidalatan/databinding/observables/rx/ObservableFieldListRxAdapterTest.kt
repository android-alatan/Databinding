package io.androidalatan.databinding.observables.rx

import io.androidalatan.databinding.observables.ObservableFieldList
import org.junit.jupiter.api.Test

class ObservableFieldListRxAdapterTest {
    @Test
    fun toObservable() {
        val observableBoolean = ObservableFieldList<Boolean>(listOf(true))
        val testObserver = observableBoolean
            .toObservable()
            .test()
            .assertValueCount(1)
            .assertValue(listOf(true))
            .assertNoErrors()
            .assertNotComplete()

        observableBoolean.set(listOf(false))
        testObserver.assertValueCount(2)
            .assertValueAt(1, listOf(false))
            .assertNoErrors()
            .assertNotComplete()
            .dispose()
    }

    @Test
    fun toSingle() {
        ObservableFieldList<Boolean>(listOf(true))
            .toSingle()
            .test()
            .assertValueCount(1)
            .assertValue(listOf(true))
            .assertNoErrors()
            .assertComplete()
            .dispose()

        ObservableFieldList<Boolean>(listOf(false))
            .toSingle()
            .test()
            .assertValueCount(1)
            .assertValue(listOf(false))
            .assertNoErrors()
            .assertComplete()
            .dispose()
    }

    @Test
    fun toMaybe() {
        ObservableFieldList<Boolean>(listOf(true))
            .toMaybe()
            .test()
            .assertValueCount(1)
            .assertValue(listOf(true))
            .assertNoErrors()
            .assertComplete()
            .dispose()

        ObservableFieldList<Boolean>()
            .toMaybe()
            .test()
            .assertValueCount(1)
            .assertValue(emptyList())
            .assertNoErrors()
            .assertComplete()
            .dispose()

    }

    @Test
    fun toFlowable() {
        val observableBoolean = ObservableFieldList<Boolean>(listOf(true))
        val testObserver = observableBoolean
            .toFlowable()
            .test()
            .assertValueCount(1)
            .assertValue(listOf(true))
            .assertNoErrors()
            .assertNotComplete()

        observableBoolean.set(listOf(false))
        testObserver.assertValueCount(2)
            .assertValueAt(1, listOf(false))
            .assertNoErrors()
            .assertNotComplete()
            .cancel()
    }
}