package com.example.recomposition.ui._9_derived_state

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.recomposition.ui.ImmutableUser
import timber.log.Timber

@Composable
fun _9_Derived_State() {
    Timber.d("RecompositionScope")

    val users = listOf(
        ImmutableUser("Vasya1", 12),
        ImmutableUser("Vasya2", 12),
        ImmutableUser("Vasya3", 12),
        ImmutableUser("Vasya4", 12),
        ImmutableUser("Vasya5", 12),
        ImmutableUser("Vasya6", 12),
        ImmutableUser("Vasya7", 12),
        ImmutableUser("Vasya8", 12),
        ImmutableUser("Vasya9", 12),
        ImmutableUser("Vasya10", 12),
        ImmutableUser("Vasya11", 12),
        ImmutableUser("Vasya12", 12),
        ImmutableUser("Vasya13", 12),
        ImmutableUser("Vasya14", 12),
        ImmutableUser("Vasya15", 12),
        ImmutableUser("Vasya16", 12),
        ImmutableUser("Vasya17", 12)
    )

    Box(modifier = Modifier.fillMaxSize()) {

        val listState = rememberLazyListState()

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(users) {
                UserName(it)
            }
        }

        Timber.d("Box")

        val showButton = listState.firstVisibleItemIndex > 0

        AnimatedVisibility(visible = showButton) {
            Timber.d("AnimatedVisibility")
            SomeView(modifier = Modifier.align(Alignment.BottomCenter))
        }


    }
}

@Composable
private fun SomeView(modifier: Modifier = Modifier) {
    Timber.d("SomeView")

    val context = LocalContext.current

    TextButton(
        onClick = { Toast.makeText(context, "Some text", Toast.LENGTH_SHORT).show() },
        modifier = modifier,
    ) {
        Text("Scroll to top")
    }
}

@Composable
private fun UserName(user: ImmutableUser) {
    Timber.d("UserName")
    Text(
        text = "Hello ${user.name}!",
        modifier = Modifier.padding(20.dp)
    )
}