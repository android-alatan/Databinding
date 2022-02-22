package io.androidalatan.databinding.observables.flow

import io.androidalatan.coroutine.test.turbine
import io.androidalatan.databinding.observables.ObservableVisibleGone
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ObservableVisibleGoneFlowAdapterTest {
    @Test
    fun toFlow() {
        val observableDouble = ObservableVisibleGone(true)
        observableDouble
            .toFlow()
            .turbine { flowTurbine ->
                Assertions.assertEquals(flowTurbine.awaitItem(), true)
                observableDouble.setVisible(false)
                Assertions.assertEquals(flowTurbine.awaitItem(), false)
                flowTurbine.cancelAndIgnoreRemainingEvents()
            }
    }
}