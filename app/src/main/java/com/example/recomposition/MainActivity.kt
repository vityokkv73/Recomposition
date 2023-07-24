package com.example.recomposition

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.immutable_data.ImmutableData
import com.example.recomposition.ui._11_immutable_from_other_module._11_Immutable_From_Other_Module
import com.example.recomposition.ui.theme.RecompositionTheme
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.plant(Timber.DebugTree())
        setContent {
            RecompositionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    _11_Immutable_From_Other_Module(ImmutableData("Param1", "Param2"))
                }
            }
        }
    }
}

// https://medium.com/androiddevelopers/jetpack-compose-stability-explained-79c10db270c8
// https://developer.android.com/jetpack/compose/performance/stability
// https://developer.android.com/jetpack/compose/performance/bestpractices
// https://www.youtube.com/watch?v=Ai4XIkzg3kY
// https://www.youtube.com/watch?v=EOQB8PTLkpY
// https://www.youtube.com/watch?v=Kp-aiSU8qCU
// https://www.youtube.com/watch?v=h-b3-DWYhjo
// https://twitter.github.io/compose-rules/rules/
