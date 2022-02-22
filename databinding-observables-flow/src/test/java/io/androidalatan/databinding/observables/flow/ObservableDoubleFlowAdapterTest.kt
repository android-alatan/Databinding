package io.androidalatan.databinding.observables.flow

import androidx.databinding.ObservableDouble
import io.androidalatan.coroutine.test.turbine
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ObservableDoubleFlowAdapterTest {
    @Test
    fun toFlow() {
        val observableDouble = ObservableDouble(1.0)
        observableDouble
            .toFlow()
            .turbine { flowTurbine ->
                Assertions.assertEquals(flowTurbine.awaitItem(), 1.0)
                observableDouble.set(2.0)
                Assertions.assertEquals(flowTurbine.awaitItem(), 2.0)
                flowTurbine.cancelAndIgnoreRemainingEvents()
            }
    }
}