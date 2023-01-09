package com.example.material2compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.material2compose.ui.theme.Material2ComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material2ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android")
//                    AppBarExample()
                    ColumnExample()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun AppBarExample() {
    val scaffoldState = rememberScaffoldState()
    var textFieldState by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(50.dp)
        ) {
            TextField(
                value = textFieldState,
                onValueChange = {
                    textFieldState = it
                },
                label = {
                    Text(text = "Type your name.")
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                    }
                }
            ) {
                Text(text = "Click Me")
            }
        }
    }
}

@Composable
fun ColumnExample() {
    Column(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxHeight(0.5f)
//            .width(300.dp)
//            .requiredWidth(600.dp)
            .fillMaxWidth()
//            .padding(50.dp)
            .border(width = 5.dp, color = Color.Red)
            .padding(5.dp)
            .border(width = 5.dp, color = Color.Gray)
            .padding(5.dp)
            .border(width = 5.dp, color = Color.Cyan)
            .padding(10.dp)
    ) {
        Text(
            text = "Soumyadeep",
//            modifier = Modifier.offset(50.dp, 30.dp)
            modifier = Modifier.clickable {
                Log.d("TEXT_CLICK", "Text Clicked...")
            }
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Mondal")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Material2ComposeTheme {
//        Greeting("Android")
//        AppBarExample()
        ColumnExample()
    }
}