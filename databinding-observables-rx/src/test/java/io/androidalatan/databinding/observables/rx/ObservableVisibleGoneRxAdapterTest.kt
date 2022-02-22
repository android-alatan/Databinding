package io.androidalatan.databinding.observables.rx

import io.androidalatan.databinding.observables.ObservableVisibleGone
import org.junit.jupiter.api.Test

class ObservableVisibleGoneRxAdapterTest {
    @Test
    fun toObservable() {
        val observableBoolean = ObservableVisibleGone(true)
        val testObserver = observableBoolean
            .toObservable()
            .test()
            .assertValueCount(1)
            .assertValue(true)
            .assertNoErrors()
            .assertNotComplete()

        observableBoolean.setVisible(false)
        testObserver.assertValueCount(2)
            .assertValueAt(1, false)
            .assertNoErrors()
            .assertNotComplete()
            .dispose()
    }

    @Test
    fun toSingle() {
        ObservableVisibleGone(true)
            .toSingle()
            .test()
            .assertValueCount(1)
            .assertValue(true)
            .assertNoErrors()
            .assertComplete()
            .dispose()

        ObservableVisibleGone()
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
        ObservableVisibleGone(true)
            .toMaybe()
            .test()
            .assertValueCount(1)
            .assertValue(true)
            .assertNoErrors()
            .assertComplete()
            .dispose()

        ObservableVisibleGone()
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
        val observableBoolean = ObservableVisibleGone(true)
        val testObserver = observableBoolean
            .toFlowable()
            .test()
            .assertValueCount(1)
            .assertValue(true)
            .assertNoErrors()
            .assertNotComplete()

        observableBoolean.setVisible(false)
        testObserver.assertValueCount(2)
            .assertValueAt(1, false)
            .assertNoErrors()
            .assertNotComplete()
            .cancel()
    }
}