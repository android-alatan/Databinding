package io.androidalatan.databinding.observables.flow

import io.androidalatan.coroutine.test.turbine
import io.androidalatan.databinding.observables.ObservableFieldList
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ObservableFieldListFlowAdapterTest {
    @Test
    fun toFlow() {
        val observableDouble = ObservableFieldList(listOf(1.0))
        observableDouble
            .toFlow()
            .turbine { flowTurbine ->
                Assertions.assertEquals(flowTurbine.awaitItem(), listOf(1.0))
                observableDouble.set(listOf(2.0))
                Assertions.assertEquals(flowTurbine.awaitItem(), listOf(2.0))
                flowTurbine.cancelAndIgnoreRemainingEvents()
            }
    }
}