package io.androidalatan.databinding.observables.rx

import androidx.databinding.ObservableDouble
import org.junit.jupiter.api.Test

class ObservableDoubleRxAdapterTest {

    @Test
    fun toObservable() {
        val observableBoolean = ObservableDouble(1.0)
        val testObserver = observableBoolean
            .toObservable()
            .test()
            .assertValueCount(1)
            .assertValue(1.0)
            .assertNoErrors()
            .assertNotComplete()

        observableBoolean.set(2.0)
        testObserver.assertValueCount(2)
            .assertValueAt(1, 2.0)
            .assertNoErrors()
            .assertNotComplete()
            .dispose()
    }

    @Test
    fun toSingle() {
        ObservableDouble(1.0)
            .toSingle()
            .test()
            .assertValueCount(1)
            .assertValue(1.0)
            .assertNoErrors()
            .assertComplete()
            .dispose()

        ObservableDouble()
            .toSingle()
            .test()
            .assertValueCount(1)
            .assertValue(0.0)
            .assertNoErrors()
            .assertComplete()
            .dispose()
    }

    @Test
    fun toMaybe() {
        ObservableDouble(1.0)
            .toMaybe()
            .test()
            .assertValueCount(1)
            .assertValue(1.0)
            .assertNoErrors()
            .assertComplete()
            .dispose()

        ObservableDouble()
            .toMaybe()
            .test()
            .assertValueCount(1)
            .assertValue(0.0)
            .assertNoErrors()
            .assertComplete()
            .dispose()

    }

    @Test
    fun toFlowable() {
        val observableBoolean = ObservableDouble(1.0)
        val testObserver = observableBoolean
            .toFlowable()
            .test()
            .assertValueCount(1)
            .assertValue(1.0)
            .assertNoErrors()
            .assertNotComplete()

        observableBoolean.set(2.0)
        testObserver.assertValueCount(2)
            .assertValueAt(1, 2.0)
            .assertNoErrors()
            .assertNotComplete()
            .cancel()
    }
}