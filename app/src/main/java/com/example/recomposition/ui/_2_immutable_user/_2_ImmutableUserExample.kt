package com.example.recomposition.ui._2_immutable_user

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
import timber.log.Timber

@Composable
fun _2_ImmutableUserExample(user: ImmutableUser) {
    var isSelected by remember { mutableStateOf(false) }

    Timber.d("RecompositionScope")

    Row(Modifier.fillMaxWidth()) {
        Timber.d("Row")
        UserName(user)
        UserButton(isSelected) {
            isSelected = !isSelected
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