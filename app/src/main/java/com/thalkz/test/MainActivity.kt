package com.thalkz.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.thalkz.component.two.bindings.TwoModule
import com.thalkz.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                App()
            }
        }
    }
}

val twoRepository = TwoModule.provideTwoRepository()

@Composable
fun App() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val (one, two) = remember { twoRepository.getOneAndTwo() }

        Column {
            Text(
                text = "Hello $one!",
                modifier = Modifier.padding(innerPadding)
            )
            Text(
                text = "Hello $two!",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
