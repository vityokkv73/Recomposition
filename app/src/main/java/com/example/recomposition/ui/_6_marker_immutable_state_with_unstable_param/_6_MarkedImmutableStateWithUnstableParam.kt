package com.example.recomposition.ui._6_marker_immutable_state_with_unstable_param

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
import com.example.recomposition.ui.MarkedImmutableStateWithUnstableParam
import timber.log.Timber

@Composable
fun _6_MarkedImmutableStateWithUnstableParam(usersState: MarkedImmutableStateWithUnstableParam) {
    var isSelected by remember { mutableStateOf(false) }

    Timber.d("RecompositionScope")

    Column {
        UserButton(isSelected) {
            isSelected = !isSelected
        }

        RecomposeAnyway(usersState)
    }
}

@Composable
// pass List<ImmutableUser> to show recomposition
fun RecomposeAnyway(usersState: MarkedImmutableStateWithUnstableParam) {

    Timber.d("RecomposeAnyway")

    Row(Modifier.fillMaxWidth()) {
        for (user in usersState.users) {
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