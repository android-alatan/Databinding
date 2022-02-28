package io.androidalatan.databinding.observables.flow

import androidx.databinding.ObservableInt
import io.androidalatan.coroutine.test.turbine
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ObservableIntFlowAdapterTest {
    @Test
    fun toFlow() {
        val observableDouble = ObservableInt(10)
        observableDouble
            .toFlow()
            .turbine { flowTurbine ->
                Assertions.assertEquals(flowTurbine.awaitItem(), 10)
                observableDouble.set(20)
                Assertions.assertEquals(flowTurbine.awaitItem(), 20)
                flowTurbine.cancelAndIgnoreRemainingEvents()
            }
    }
}