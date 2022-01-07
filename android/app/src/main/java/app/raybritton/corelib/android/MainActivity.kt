package app.raybritton.corelib.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import app.raybritton.corelib.adapter.Core
import app.raybritton.corelib.android.ui.theme.AppTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import app.raybritton.corelib.adapter.Core.add

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Column(Modifier.padding(16.dp)) {
                        NumberCalc()
                    }
                }
            }
        }
    }
}

@Composable
fun NumberCalc() {
    var lhs by rememberSaveable { mutableStateOf("0") }
    var rhs by rememberSaveable { mutableStateOf("0") }
    var value by rememberSaveable { mutableStateOf("0") }
    val update = {
        value = add((lhs.toIntOrNull() ?: 0), (rhs.toIntOrNull() ?: 0)).toString()
    }
    Column {
        Text("Add two numbers")
        Row(Modifier.padding(8.dp).fillMaxWidth().wrapContentHeight()) {
            BasicTextField(
                lhs, {
                    lhs = it
                    update()
                },
                modifier = Modifier.align(Alignment.CenterVertically),
                textStyle = TextStyle(textAlign = TextAlign.Center),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Text("+", modifier = Modifier.align(Alignment.CenterVertically))
            BasicTextField(
                rhs, {
                    rhs = it
                    update()
                },
                modifier = Modifier.align(Alignment.CenterVertically),
                textStyle = TextStyle(textAlign = TextAlign.Center),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Text("=", modifier = Modifier.align(Alignment.CenterVertically))
            Text(text = value, textAlign = TextAlign.Center, modifier = Modifier.width(60.dp))
        }
    }
}