package io.androidalatan.databinding.observables.rx

import androidx.databinding.ObservableField
import org.junit.jupiter.api.Test

class ObservableFieldRxAdapterTest {
    @Test
    fun toObservable() {
        val observableBoolean = ObservableField(true)
        val testObserver = observableBoolean
            .toObservable()
            .test()
            .assertValueCount(1)
            .assertValue(true)
            .assertNoErrors()
            .assertNotComplete()

        observableBoolean.set(false)
        testObserver.assertValueCount(2)
            .assertValueAt(1, false)
            .assertNoErrors()
            .assertNotComplete()
            .dispose()
    }

    @Test
    fun toSingle() {
        ObservableField(true)
            .toSingle()
            .test()
            .assertValueCount(1)
            .assertValue(true)
            .assertNoErrors()
            .assertComplete()
            .dispose()

        val observableField = ObservableField<Boolean>()
        val testObserver = observableField
            .toSingle()
            .test()
            .assertNoValues()
            .assertNoErrors()
            .assertNotComplete()

        observableField.set(false)
        testObserver.assertValueCount(1)
            .assertValue(false)
            .assertNoErrors()
            .assertComplete()
            .dispose()
    }

    @Test
    fun toMaybe() {
        ObservableField(true)
            .toMaybe()
            .test()
            .assertValueCount(1)
            .assertValue(true)
            .assertNoErrors()
            .assertComplete()
            .dispose()

        ObservableField<Boolean>()
            .toMaybe()
            .test()
            .assertNoValues()
            .assertNoErrors()
            .assertComplete()
            .dispose()

    }

    @Test
    fun toFlowable() {
        val observableBoolean = ObservableField(true)
        val testObserver = observableBoolean
            .toFlowable()
            .test()
            .assertValueCount(1)
            .assertValue(true)
            .assertNoErrors()
            .assertNotComplete()

        observableBoolean.set(false)
        testObserver.assertValueCount(2)
            .assertValueAt(1, false)
            .assertNoErrors()
            .assertNotComplete()
            .cancel()
    }
}