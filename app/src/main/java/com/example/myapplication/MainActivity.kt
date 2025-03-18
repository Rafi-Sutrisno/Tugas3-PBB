package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.Canvas
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Button

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        BirthdayGreet(name = "Mr. Sam", from = "Ahda")

                    }
                }
            }
        }
    }
}

@Composable
fun BirthdayGreet(name: String, from: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Greeting(name)
        Spacer(modifier = Modifier.height(16.dp))
        From(name = from)
        BirthdayCake()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Happy Birthday $name!",
        modifier = modifier,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    )
}

@Composable
fun From(name: String, modifier: Modifier = Modifier){
    Text(
        text = "From $name",
        modifier = modifier,
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Black,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    )
}

@Composable
fun BirthdayCake() {
    Canvas(modifier = Modifier.size(150.dp)) {
        // Draw Cake Base
        drawRoundRect(
            color = Color(0xFFFFC107), // Yellow Cake Base
            topLeft = center.copy(x = center.x - 60.dp.toPx(), y = center.y - 20.dp.toPx()),
            size = size.copy(width = 120.dp.toPx(), height = 60.dp.toPx()),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(16.dp.toPx())
        )

        // Draw Candle
        drawRoundRect(
            color = Color.Red,
            topLeft = center.copy(x = center.x - 5.dp.toPx(), y = center.y - 40.dp.toPx()),
            size = size.copy(width = 10.dp.toPx(), height = 20.dp.toPx())
        )

        // Draw Flame
        drawCircle(
            color = Color.Yellow,
            center = center.copy(y = center.y - 50.dp.toPx()),
            radius = 8.dp.toPx()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        BirthdayGreet("Mr. Sam", "Ahda")
    }
}
