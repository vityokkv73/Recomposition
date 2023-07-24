package com.example.recomposition.ui

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import kotlinx.collections.immutable.ImmutableList

data class ImmutableUser(val name: String, val age: Int)

data class MutableUser(var name: String, val age: Int)

@Stable
data class IncorrectStableMutableUser(var name: String, val age: Int)

data class StateWithUnstableParam(
    val users: List<ImmutableUser>
)

data class ImmutableState(
    val users: ImmutableList<ImmutableUser>
)

@Immutable
data class MarkedImmutableStateWithUnstableParam(
    val users: List<ImmutableUser>
)