package com.example.recomposition.ui._8_lazylist

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun _8_LazyList(users: List<ImmutableUser>) {
    var isSelected by remember { mutableStateOf(false) }

    Timber.d("RecompositionScope")

    LazyColumn(Modifier.fillMaxWidth()) {
        items(users) {
            Timber.d("Row")
            UserName(it.name)
            UserButton(isSelected) {

//                (users as MutableList).add(ImmutableUser("holla", 12))

                isSelected = !isSelected
            }
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
private fun UserName(userName: String) {
    Timber.d("UserName")
    Text(
        text = "Hello ${userName}!"
    )
}