package com.example.recomposition.ui._3_incorrect_stable_mutable_user

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
import com.example.recomposition.ui.IncorrectStableMutableUser
import timber.log.Timber

@Composable
fun _3_IncorrectStableMutableUser(user: IncorrectStableMutableUser) {
    var isSelected by remember { mutableStateOf(false) }

    Timber.d("RecompositionScope")

    Row(Modifier.fillMaxWidth()) {
        Timber.d("Row")
        UserName(user)
        UserButton(isSelected) {
            user.name = user.name + "!"
//            isSelected = !isSelected
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
private fun UserName(user: IncorrectStableMutableUser) {
    Timber.d("UserName")
    Text(
        text = "Hello ${user.name}!"
    )
}