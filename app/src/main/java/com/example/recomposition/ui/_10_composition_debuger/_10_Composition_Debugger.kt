package com.example.recomposition.ui._10_composition_debuger

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.recomposition.ui.ImmutableState
import com.example.recomposition.ui.ImmutableUser
import com.example.recomposition.ui.MutableUser
import kotlinx.collections.immutable.persistentListOf
import timber.log.Timber

@Composable
fun _10_Composition_Debugger() {
    Timber.d("RecompositionScope")

    var isSelected by remember { mutableStateOf(false) }
    val immutableUser = ImmutableUser("Vasya", 10)
    val mutableUser = MutableUser("Kolya", 20)
    val immutableState = ImmutableState(
        persistentListOf(
            ImmutableUser("Kostyantyn!", 30),
            ImmutableUser("Svyatogor", 40)
        )
    )

    SomeView(
        immutableUser = immutableUser,
        mutableUser = mutableUser,
        immutableState = immutableState,
        isSelected = isSelected,
        onClick = { isSelected = !isSelected }
    )
}

@Composable
private fun SomeView(
    immutableUser: ImmutableUser,
    mutableUser: MutableUser,
    immutableState: ImmutableState,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Timber.d("SomeView")

    Column {

        Timber.d("Column")

        Text("isSelected = $isSelected")

        Text("immutableUser = $immutableUser")

        Text("mutableUser = $mutableUser")

        Text("immutableState = $immutableState")

        TextButton(
            onClick = onClick,
        ) {
            Text("Button")
        }
    }
}
