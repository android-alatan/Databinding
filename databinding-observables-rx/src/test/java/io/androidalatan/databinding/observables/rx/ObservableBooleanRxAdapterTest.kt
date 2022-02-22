package io.androidalatan.databinding.observables.rx

import androidx.databinding.ObservableBoolean
import org.junit.jupiter.api.Test

class ObservableBooleanRxAdapterTest {

    @Test
    fun toObservable() {
        val observableBoolean = ObservableBoolean(true)
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
        ObservableBoolean(true)
            .toSingle()
            .test()
            .assertValueCount(1)
            .assertValue(true)
            .assertNoErrors()
            .assertComplete()
            .dispose()

        ObservableBoolean()
            .toSingle()
            .test()
            .assertValueCount(1)
            .assertValue(false)
            .assertNoErrors()
            .assertComplete()
            .dispose()
    }

    @Test
    fun toMaybe() {
        ObservableBoolean(true)
            .toMaybe()
            .test()
            .assertValueCount(1)
            .assertValue(true)
            .assertNoErrors()
            .assertComplete()
            .dispose()

        ObservableBoolean()
            .toMaybe()
            .test()
            .assertValueCount(1)
            .assertValue(false)
            .assertNoErrors()
            .assertComplete()
            .dispose()

    }

    @Test
    fun toFlowable() {
        val observableBoolean = ObservableBoolean(true)
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