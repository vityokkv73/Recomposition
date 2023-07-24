package com.example.recomposition.ui._5_state_with_unstable_param

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.recomposition.ui.ImmutableUser
import com.example.recomposition.ui.StateWithUnstableParam
import timber.log.Timber

@Composable
fun _5_StateWithUnstableParam(stateWithUnstableParam: StateWithUnstableParam) {
    var isSelected by remember { mutableStateOf(false) }

    Timber.d("RecompositionScope")

    Column {
        UserButton(isSelected) {
            isSelected = !isSelected
        }

        RecomposeAnyway(stateWithUnstableParam)
    }
}

@Composable
fun RecomposeAnyway(stateWithUnstableParam: StateWithUnstableParam) {

    Timber.d("RecomposeAnyway")

    Row(Modifier.fillMaxWidth()) {
        for (user in stateWithUnstableParam.users) {
            Timber.d("Row")
            UserName(user)
        }
    }
}

@Composable
private fun UserButton(isSelected: Boolean, onClick: () -> Unit) {
    Timber.d("UserButton")
    TextButton(onClick = onClick) {
        Text(
            text = "Is selected - $isSelected"
        )
    }
}

@Composable
private fun UserName(user: ImmutableUser) {
    Timber.d("UserName")
    Text(
        text = "Hello ${user.name}!"
    )
}