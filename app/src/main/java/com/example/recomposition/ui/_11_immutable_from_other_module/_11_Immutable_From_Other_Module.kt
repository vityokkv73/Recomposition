package com.example.recomposition.ui._11_immutable_from_other_module

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.immutable_data.ImmutableData
import com.example.recomposition.ui.ImmutableUser
import timber.log.Timber

@Composable
fun _11_Immutable_From_Other_Module(ImmutableData: ImmutableData) {
    Timber.d("RecompositionScope")

    var isSelected by remember { mutableStateOf(false) }


    Column {
        UserButton(isSelected) {
            isSelected = !isSelected
        }

        RecomposeAnyway(ImmutableData)
    }
}

@Composable
fun RecomposeAnyway(immutableData: ImmutableData) {
    Timber.d("RecomposeAnyway")

    Text("immutableData = $immutableData")
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