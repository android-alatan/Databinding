package io.androidalatan.databinding.observables.rx

import androidx.databinding.ObservableLong
import org.junit.jupiter.api.Test

class ObservableLongRxAdapterTest {
    @Test
    fun toObservable() {
        val observableBoolean = ObservableLong(10L)
        val testObserver = observableBoolean
            .toObservable()
            .test()
            .assertValueCount(1)
            .assertValue(10L)
            .assertNoErrors()
            .assertNotComplete()

        observableBoolean.set(20L)
        testObserver.assertValueCount(2)
            .assertValueAt(1, 20L)
            .assertNoErrors()
            .assertNotComplete()
            .dispose()
    }

    @Test
    fun toSingle() {
        ObservableLong(10L)
            .toSingle()
            .test()
            .assertValueCount(1)
            .assertValue(10L)
            .assertNoErrors()
            .assertComplete()
            .dispose()

        ObservableLong()
            .toSingle()
            .test()
            .assertValueCount(1)
            .assertValue(0L)
            .assertNoErrors()
            .assertComplete()
            .dispose()
    }

    @Test
    fun toMaybe() {
        ObservableLong(10L)
            .toMaybe()
            .test()
            .assertValueCount(1)
            .assertValue(10L)
            .assertNoErrors()
            .assertComplete()
            .dispose()

        ObservableLong()
            .toMaybe()
            .test()
            .assertValueCount(1)
            .assertValue(0L)
            .assertNoErrors()
            .assertComplete()
            .dispose()

    }

    @Test
    fun toFlowable() {
        val observableBoolean = ObservableLong(10L)
        val testObserver = observableBoolean
            .toFlowable()
            .test()
            .assertValueCount(1)
            .assertValue(10L)
            .assertNoErrors()
            .assertNotComplete()

        observableBoolean.set(20L)
        testObserver.assertValueCount(2)
            .assertValueAt(1, 20L)
            .assertNoErrors()
            .assertNotComplete()
            .cancel()
    }
}