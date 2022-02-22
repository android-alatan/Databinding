package io.androidalatan.databinding.observables.flow

import androidx.databinding.ObservableField
import io.androidalatan.coroutine.test.turbine
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ObservableFieldFlowAdapterTest {
    @Test
    fun toFlow() {
        val observableDouble = ObservableField(1.0)
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