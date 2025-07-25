package ru.vafeen.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import ru.vafeen.presentation.ui.theme.ComposeCleanArchMultimoduleExampleTheme
import javax.inject.Inject

class TestDependency(val x: Int)

@Module
@InstallIn(SingletonComponent::class)
class Moduleee {
    @Provides
    fun provideTest() = TestDependency(1)
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var testDependency: TestDependency
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d("test", "${testDependency.x}")
        setContent {
            ComposeCleanArchMultimoduleExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeCleanArchMultimoduleExampleTheme {
        Greeting("Android")
    }
}