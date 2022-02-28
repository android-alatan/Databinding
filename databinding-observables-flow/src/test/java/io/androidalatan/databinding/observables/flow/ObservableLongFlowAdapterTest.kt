package io.androidalatan.databinding.observables.flow

import androidx.databinding.ObservableLong
import io.androidalatan.coroutine.test.turbine
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ObservableLongFlowAdapterTest {
    @Test
    fun toFlow() {
        val observableDouble = ObservableLong(10L)
        observableDouble
            .toFlow()
            .turbine { flowTurbine ->
                Assertions.assertEquals(flowTurbine.awaitItem(), 10L)
                observableDouble.set(20L)
                Assertions.assertEquals(flowTurbine.awaitItem(), 20L)
                flowTurbine.cancelAndIgnoreRemainingEvents()
            }
    }
}