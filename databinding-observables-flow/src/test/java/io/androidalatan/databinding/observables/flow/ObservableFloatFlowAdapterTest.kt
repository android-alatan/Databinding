package io.androidalatan.databinding.observables.flow

import androidx.databinding.ObservableFloat
import io.androidalatan.coroutine.test.turbine
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ObservableFloatFlowAdapterTest {
    @Test
    fun toFlow() {
        val observableDouble = ObservableFloat(1.0f)
        observableDouble
            .toFlow()
            .turbine { flowTurbine ->
                Assertions.assertEquals(flowTurbine.awaitItem(), 1.0f)
                observableDouble.set(2.0f)
                Assertions.assertEquals(flowTurbine.awaitItem(), 2.0f)
                flowTurbine.cancelAndIgnoreRemainingEvents()
            }
    }
}