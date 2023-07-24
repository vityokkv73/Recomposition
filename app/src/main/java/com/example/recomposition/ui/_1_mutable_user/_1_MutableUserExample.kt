package com.example.recomposition.ui._1_mutable_user

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
import com.example.recomposition.ui.MutableUser
import timber.log.Timber

// Про те, що таке stable/unstable, immutable, recomposition scope, skippable, restartable (inline function), показати тулзи (layout inspector + compose metrics)
// ./gradlew assembleRelease -PcomposeCompilerReports=true

@Composable
fun _1_MutableUserExample(user: MutableUser) {
    var isSelected by remember { mutableStateOf(false) }

    Timber.d("RecompositionScope")

    Row(Modifier.fillMaxWidth()) {
        Timber.d("Row")
        UserName(user)
        UserButton2(isSelected) {
//            user.name = user.name + "!"
            isSelected = !isSelected
        }
    }
}

@Composable
private fun UserButton2(isSelected: Boolean, onClick: () -> Unit) {
    Timber.d("UserButton")
    TextButton(onClick = onClick) {
        Text(
            text = "Is selected - $isSelected"
        )
    }
}

@Composable
private fun UserName(user: MutableUser) {
    Timber.d("UserName")
    Text(
        text = "Hello ${user.name}!"
    )
}



//@Stable
//class MyStateHolder {
//    var isLoading by mutableStateOf(false)
//}