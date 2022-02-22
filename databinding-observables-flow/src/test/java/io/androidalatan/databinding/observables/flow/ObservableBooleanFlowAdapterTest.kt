package io.androidalatan.databinding.observables.flow

import androidx.databinding.ObservableBoolean
import io.androidalatan.coroutine.test.turbine
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ObservableBooleanFlowAdapterTest {
    @Test
    fun toFlow() {
        val observableBoolean = ObservableBoolean(true)
        observableBoolean
            .toFlow()
            .turbine { flowTurbine ->
                Assertions.assertEquals(flowTurbine.awaitItem(), true)
                observableBoolean.set(false)
                Assertions.assertEquals(flowTurbine.awaitItem(), false)
                flowTurbine.cancelAndIgnoreRemainingEvents()
            }
    }
}