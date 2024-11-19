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
import com.thalkz.component.one.bindings.OneModule
import com.thalkz.component.one.core.CoreOneModule
import com.thalkz.component.two.TwoRepository
import com.thalkz.component.two.bindings.TwoModule
import com.thalkz.component.two.core.CoreTwoModule
import com.thalkz.foundation.core.CoreModule
import com.thalkz.platform.di.Bindings
import com.thalkz.platform.di.get
import com.thalkz.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectModules()
        setContent {
            TestTheme {
                App()
            }
        }
    }
}

fun injectModules() {
    OneModule.inject()
    TwoModule.inject()
    CoreModule.inject()
    CoreOneModule.inject()
    CoreTwoModule.inject()
}

@Composable
fun App() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val (one, two) = remember { Bindings.get<TwoRepository>().getOneAndTwo() }

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
