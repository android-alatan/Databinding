package io.androidalatan.databinding.observables.rx

import androidx.databinding.ObservableFloat
import org.junit.jupiter.api.Test

class ObservableFloatRxAdapterTest {
    @Test
    fun toObservable() {
        val observableBoolean = ObservableFloat(1f)
        val testObserver = observableBoolean
            .toObservable()
            .test()
            .assertValueCount(1)
            .assertValue(1f)
            .assertNoErrors()
            .assertNotComplete()

        observableBoolean.set(2f)
        testObserver.assertValueCount(2)
            .assertValueAt(1, 2f)
            .assertNoErrors()
            .assertNotComplete()
            .dispose()
    }

    @Test
    fun toSingle() {
        ObservableFloat(1f)
            .toSingle()
            .test()
            .assertValueCount(1)
            .assertValue(1f)
            .assertNoErrors()
            .assertComplete()
            .dispose()

        ObservableFloat()
            .toSingle()
            .test()
            .assertValueCount(1)
            .assertValue(0f)
            .assertNoErrors()
            .assertComplete()
            .dispose()
    }

    @Test
    fun toMaybe() {
        ObservableFloat(1f)
            .toMaybe()
            .test()
            .assertValueCount(1)
            .assertValue(1f)
            .assertNoErrors()
            .assertComplete()
            .dispose()

        ObservableFloat()
            .toMaybe()
            .test()
            .assertValueCount(1)
            .assertValue(0f)
            .assertNoErrors()
            .assertComplete()
            .dispose()

    }

    @Test
    fun toFlowable() {
        val observableBoolean = ObservableFloat(1f)
        val testObserver = observableBoolean
            .toFlowable()
            .test()
            .assertValueCount(1)
            .assertValue(1f)
            .assertNoErrors()
            .assertNotComplete()

        observableBoolean.set(2f)
        testObserver.assertValueCount(2)
            .assertValueAt(1, 2f)
            .assertNoErrors()
            .assertNotComplete()
            .cancel()
    }
}