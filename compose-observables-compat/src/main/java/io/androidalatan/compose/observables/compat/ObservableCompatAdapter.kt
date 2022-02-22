package io.androidalatan.compose.observables.compat

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableDouble
import androidx.databinding.ObservableField
import androidx.databinding.ObservableFloat
import androidx.databinding.ObservableInt
import androidx.databinding.ObservableLong
import io.androidalatan.databinding.observables.ObservableFieldList
import io.androidalatan.databinding.observables.ObservableString
import io.androidalatan.databinding.observables.ObservableVisibleGone

@Composable
fun ObservableBoolean.observeAsState(): State<Boolean> {
    val value = get()
    val state = remember { mutableStateOf(value) }

    DisposableEffect(state) {
        val callback: Observable.OnPropertyChangedCallback = object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if (sender == null && sender !is ObservableBoolean) return
                state.value = (sender as ObservableBoolean).get()
            }
        }
        addOnPropertyChangedCallback(callback)
        onDispose {
            removeOnPropertyChangedCallback(callback)
        }
    }
    return state
}

@Composable
fun ObservableInt.observeAsState(): State<Int> {
    val value = get()
    val state = remember { mutableStateOf(value) }

    DisposableEffect(state) {
        val callback: Observable.OnPropertyChangedCallback = object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if (sender == null && sender !is ObservableInt) return
                state.value = (sender as ObservableInt).get()
            }
        }
        addOnPropertyChangedCallback(callback)
        onDispose {
            removeOnPropertyChangedCallback(callback)
        }
    }
    return state
}

@Composable
fun ObservableDouble.observeAsState(): State<Double> {
    val value = get()
    val state = remember { mutableStateOf(value) }

    DisposableEffect(state) {
        val callback: Observable.OnPropertyChangedCallback = object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if (sender == null && sender !is ObservableDouble) return
                state.value = (sender as ObservableDouble).get()
            }
        }

        addOnPropertyChangedCallback(callback)
        onDispose {
            removeOnPropertyChangedCallback(callback)
        }
    }
    return state
}

@Composable
fun ObservableFloat.observeAsState(): State<Float> {
    val value = get()
    val state = remember { mutableStateOf(value) }

    DisposableEffect(state) {
        val callback: Observable.OnPropertyChangedCallback = object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if (sender == null && sender !is ObservableFloat) return
                state.value = (sender as ObservableFloat).get()
            }
        }

        addOnPropertyChangedCallback(callback)
        onDispose {
            removeOnPropertyChangedCallback(callback)
        }
    }
    return state
}

@Composable
fun ObservableLong.observeAsState(): State<Long> {
    val value = get()
    val state = remember { mutableStateOf(value) }

    DisposableEffect(state) {
        val callback: Observable.OnPropertyChangedCallback = object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if (sender == null && sender !is ObservableLong) return
                state.value = (sender as ObservableLong).get()
            }
        }

        addOnPropertyChangedCallback(callback)
        onDispose {
            removeOnPropertyChangedCallback(callback)
        }
    }
    return state
}

@Composable
fun <Field> ObservableField<Field>.observeAsState(): State<Field?> {
    val value = get()
    val state = remember { mutableStateOf(value) }

    DisposableEffect(state) {
        val callback: Observable.OnPropertyChangedCallback = object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if (sender == null && sender !is ObservableField<*>) return
                @Suppress("UNCHECKED_CAST")
                state.value = (sender as ObservableField<Field>).get()
            }
        }

        addOnPropertyChangedCallback(callback)
        onDispose {
            removeOnPropertyChangedCallback(callback)
        }
    }
    return state
}

@Composable
fun ObservableString.observeAsState(): State<String> {
    val value = get()
    val state = remember { mutableStateOf(value) }

    DisposableEffect(state) {
        val callback: Observable.OnPropertyChangedCallback = object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if (sender == null && sender !is ObservableString) return
                state.value = (sender as ObservableString).get()
            }
        }

        addOnPropertyChangedCallback(callback)
        onDispose {
            removeOnPropertyChangedCallback(callback)
        }
    }
    return state
}

@Composable
fun <Field> ObservableFieldList<Field>.observeAsState(): State<List<Field>> {
    val value = get()
    val state = remember { mutableStateOf(value) }

    DisposableEffect(state) {
        val callback: Observable.OnPropertyChangedCallback = object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if (sender == null && sender !is ObservableFieldList<*>) return
                @Suppress("UNCHECKED_CAST")
                state.value = (sender as ObservableFieldList<Field>).get()
            }
        }

        addOnPropertyChangedCallback(callback)
        onDispose {
            removeOnPropertyChangedCallback(callback)
        }
    }
    return state
}

@Composable
fun ObservableVisibleGone.observeAsState(): State<Boolean> {
    val value = isVisible()
    val state = remember { mutableStateOf(value) }

    DisposableEffect(state) {
        val callback: Observable.OnPropertyChangedCallback = object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if (sender == null && sender !is ObservableVisibleGone) return
                state.value = (sender as ObservableVisibleGone).isVisible()
            }
        }

        addOnPropertyChangedCallback(callback)
        onDispose {
            removeOnPropertyChangedCallback(callback)
        }
    }
    return state
}