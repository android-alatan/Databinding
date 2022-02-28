package io.androidalatan.databinding.observables.flow

import io.androidalatan.coroutine.test.turbine
import io.androidalatan.databinding.observables.ObservableString
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ObservableStringFlowAdapterTest {
    @Test
    fun toFlow() {
        val observableDouble = ObservableString("10L")
        observableDouble
            .toFlow()
            .turbine { flowTurbine ->
                Assertions.assertEquals(flowTurbine.awaitItem(), "10L")
                observableDouble.set("20L")
                Assertions.assertEquals(flowTurbine.awaitItem(), "20L")
                flowTurbine.cancelAndIgnoreRemainingEvents()
            }
    }
}