package io.androidalatan.databinding.observables.rx

import io.androidalatan.databinding.observables.ObservableString
import org.junit.jupiter.api.Test

class ObservableStringRxAdapterTest {
    @Test
    fun toObservable() {
        val observableBoolean = ObservableString("10")
        val testObserver = observableBoolean
            .toObservable()
            .test()
            .assertValueCount(1)
            .assertValue("10")
            .assertNoErrors()
            .assertNotComplete()

        observableBoolean.set("20")
        testObserver.assertValueCount(2)
            .assertValueAt(1, "20")
            .assertNoErrors()
            .assertNotComplete()
            .dispose()
    }

    @Test
    fun toSingle() {
        ObservableString("10")
            .toSingle()
            .test()
            .assertValueCount(1)
            .assertValue("10")
            .assertNoErrors()
            .assertComplete()
            .dispose()

        ObservableString()
            .toSingle()
            .test()
            .assertValueCount(1)
            .assertValue("")
            .assertNoErrors()
            .assertComplete()
            .dispose()
    }

    @Test
    fun toMaybe() {
        ObservableString("10")
            .toMaybe()
            .test()
            .assertValueCount(1)
            .assertValue("10")
            .assertNoErrors()
            .assertComplete()
            .dispose()

        ObservableString()
            .toMaybe()
            .test()
            .assertValueCount(1)
            .assertValue("")
            .assertNoErrors()
            .assertComplete()
            .dispose()

    }

    @Test
    fun toFlowable() {
        val observableBoolean = ObservableString("10")
        val testObserver = observableBoolean
            .toFlowable()
            .test()
            .assertValueCount(1)
            .assertValue("10")
            .assertNoErrors()
            .assertNotComplete()

        observableBoolean.set("20")
        testObserver.assertValueCount(2)
            .assertValueAt(1, "20")
            .assertNoErrors()
            .assertNotComplete()
            .cancel()
    }
}