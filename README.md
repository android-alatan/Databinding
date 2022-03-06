[![Main Commit](https://github.com/android-alatan/Databinding/actions/workflows/lib-main-branch.yml/badge.svg?branch=main)](https://github.com/android-alatan/Databinding/actions/workflows/lib-main-branch.yml)
[![Release](https://jitpack.io/v/android-alatan/databinding.svg)](https://jitpack.io/#android-alatan/databinding)

# Databinding
Android Databinding is a magic tool as a messenger between XML and native code.

As pure application, it is enough to use. But nowadays, We are using lots of tools : RxJava, Coroutine And Jetpack Compose.

We are introducing 2 tools : RxJava/Coroutine Flow adapter and Compose adapter.

# RxJava/Coroutine Flow adpater

### Installation
```kotlin
// for ObservableString, List, VisibleGone
implementation("com.github.android-alatan.databinding:databinding-observables:$version")
// rxjava adapter
implementation("com.github.android-alatan.databinding:databinding-observables-rx:$version")
// coroutine flow adapter
implementation("com.github.android-alatan.databinding:databinding-observables-flow:$version")
```

### Example
```kotlin
class FooViewModel {
  val name = ObservableString("")
  fun observeName() {
    name.toObservable().subscribe { _name -> /* do something with name */ }
  }
}
```
`databinding-observables-rx` and `databinding-observables-flow` help Databinding Observable to stream easily.

# Compose Databinding compatible

By new tool, Jetpack Compose, Many devs are migrating to new tools from traditional ui tool (XML)

Some products may migrate with one shot. But it is a very dangerous strategy. We highly recommend to migrate step by step.

This package is to help your migration slightly.

### Installation
```kotlin
implementation("com.github.android-alatan.databinding:compose-observables-compat:$version")
```

### Example
```kotlin
class FooViewModel {
  val age = ObservableInt()
  fun legacyLogic() { /* update age */ }
}

@Composable
fun FooUi() {
  val age by fooViewModel().age.observeAsState()
  // populate age on ui component.
}
```
As above example, ObservableXXX.observeAsState() in Composable function. it will work as `LiveData.observeAsState()`