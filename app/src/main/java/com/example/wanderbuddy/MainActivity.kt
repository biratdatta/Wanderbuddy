package com.example.wanderbuddy

import android.graphics.Color.blue
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wanderbuddy.ui.theme.SealColor
import com.example.wanderbuddy.ui.theme.WanderbuddyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WanderbuddyApp()
        }
    }
}

@Composable
fun WanderbuddyApp() {
    WanderbuddyTheme {
        Scaffold {
            WanderbuddyScreen()
        }
    }
}

@Composable
fun WanderbuddyScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            fontSize = 40.sp,
            modifier = Modifier.padding(bottom = 25.dp),
            text = buildAnnotatedString {
                append("Welcome to \n")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                ) {
                    append("WanderBuddy")
                }
            }
        )

        val genres = listOf("New Places", "Recent", "Top Places", "Others")
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(bottom = 25.dp)
        ) {
            items(genres) { genre ->
                Genre(genre)
            }
        }

        Box(
            modifier = Modifier
                .padding(end = 20.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(
                    colorResource(
                        id = R.color.blue
                    )
                )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 30.dp)
                        .padding(start = 20.dp)
                ) {
                    Text(
                        text = "Trip Finder",
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.size(10.dp))

                    Text(text = "Find your desired Trip " ,
                        color = Color.White,
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.size(40.dp))

                    Button(
                        modifier = Modifier
                            .size(
                                height = 60.dp,
                                width = 120.dp
                            )
                            .clip(RoundedCornerShape(20.dp)),
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White
                        )
                    ) {
                        Text(text = "Start", color = Color.Black, fontSize =18.sp)
                        Spacer(modifier = Modifier.size(10.dp))
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.Black),
                            contentAlignment = Alignment.Center
                        ){
                            Icon (
                                modifier = Modifier.padding(5.dp),
                                imageVector = Icons.Filled.PlayArrow,
                                contentDescription = "Arrow Icon",
                                tint = Color.White
                            )
                        }
                    }
                }

                Image(
                    painter = painterResource(id = R.drawable.brai),
                    contentDescription = "avatar image",
                    modifier = Modifier.padding(10.dp) // Add desired modifier if needed
                )

            }
        }





    }
}

@Composable
fun Genre(text: String) {
    val isSelected = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .background(if (isSelected.value) Color.Black else Color.LightGray)
            .clickable { isSelected.value = !isSelected.value },
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = text,
            color = if (isSelected.value) Color.Blue

            else Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    WanderbuddyApp()
}
