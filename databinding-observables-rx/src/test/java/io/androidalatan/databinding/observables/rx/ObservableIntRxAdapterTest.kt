package io.androidalatan.databinding.observables.rx

import androidx.databinding.ObservableInt
import org.junit.jupiter.api.Test

class ObservableIntRxAdapterTest {
    @Test
    fun toObservable() {
        val observableBoolean = ObservableInt(10)
        val testObserver = observableBoolean
            .toObservable()
            .test()
            .assertValueCount(1)
            .assertValue(10)
            .assertNoErrors()
            .assertNotComplete()

        observableBoolean.set(20)
        testObserver.assertValueCount(2)
            .assertValueAt(1, 20)
            .assertNoErrors()
            .assertNotComplete()
            .dispose()
    }

    @Test
    fun toSingle() {
        ObservableInt(10)
            .toSingle()
            .test()
            .assertValueCount(1)
            .assertValue(10)
            .assertNoErrors()
            .assertComplete()
            .dispose()

        ObservableInt()
            .toSingle()
            .test()
            .assertValueCount(1)
            .assertValue(0)
            .assertNoErrors()
            .assertComplete()
            .dispose()
    }

    @Test
    fun toMaybe() {
        ObservableInt(10)
            .toMaybe()
            .test()
            .assertValueCount(1)
            .assertValue(10)
            .assertNoErrors()
            .assertComplete()
            .dispose()

        ObservableInt()
            .toMaybe()
            .test()
            .assertValueCount(1)
            .assertValue(0)
            .assertNoErrors()
            .assertComplete()
            .dispose()

    }

    @Test
    fun toFlowable() {
        val observableBoolean = ObservableInt(10)
        val testObserver = observableBoolean
            .toFlowable()
            .test()
            .assertValueCount(1)
            .assertValue(10)
            .assertNoErrors()
            .assertNotComplete()

        observableBoolean.set(20)
        testObserver.assertValueCount(2)
            .assertValueAt(1, 20)
            .assertNoErrors()
            .assertNotComplete()
            .cancel()
    }
}