package com.example.recomposition.ui._4_correct_stable_mutable_user

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import timber.log.Timber

@Stable
class CorrectStableMutableUser(userName: String, age: Int) {
    var name by mutableStateOf(userName)
    val age = age
}


@Composable
fun _4_CorrectStableMutableUser(user: CorrectStableMutableUser) {
    var isSelected by remember { mutableStateOf(false) }

    Timber.d("RecompositionScope")

    Row(Modifier.fillMaxWidth()) {
        Timber.d("Row")
        UserName(user)
        UserButton3(isSelected) {
            user.name += "!"
//            user.age = user.age + 1
//            isSelected = !isSelected
        }
    }
}

@Composable
private fun UserButton3(isSelected: Boolean, onClick: () -> Unit) {
    Timber.d("UserButton")
    TextButton(onClick = onClick) {
        Text(
            text = "Is selected - $isSelected"
        )
    }
}

@Composable
private fun UserName(user: CorrectStableMutableUser) {
    Timber.d("UserName")
    Text(
        text = "Hello ${user.name}!"
    )
}