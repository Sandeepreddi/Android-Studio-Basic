package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    val phone = painterResource(R.drawable.call_24dp)
    val mail = painterResource(R.drawable.mail_24dp)
    val share = painterResource(R.drawable.share_24dp)

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background))
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth() // Add padding to separate image and text
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(100.dp)
            )
            {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .aspectRatio(image.intrinsicSize.width / image.intrinsicSize.height)
                        .background(color = Color.Black),
                    alpha = 0.8F
                )
            }

            Text(
                text = "Sandeep Reddy",
               fontSize = 30.sp, // set the font size
                textAlign = TextAlign.Center // align text to center horizontally
            )
            Text(
                text = "Android Developer",
                fontSize = 20.sp, // set the font size
                textAlign = TextAlign.Center // align text to center horizontally
            )
        }
    }



        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .padding(bottom = 50.dp)
                .padding(start = 50.dp)
                .fillMaxWidth()
                .fillMaxHeight() // Add padding to separate image and text
        )
        {
            Row(modifier= Modifier.padding(bottom = 5.dp)
            )
            {
                Image(
                    painter = phone,
                    contentDescription = null,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "9553693927",
                    fontSize = 20.sp, // set the font size
                    textAlign = TextAlign.Center // align text to center horizontally
                )
            }
            Row(modifier = Modifier.padding(bottom = 5.dp).horizontalScroll(rememberScrollState())) {
                Image(
                    painter = mail,
                    contentDescription = null,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "sandeepreddi23@gmail.com",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }

            Row(modifier= Modifier.padding(bottom = 5.dp)) {


                Image(
                    painter = share,
                    contentDescription = null,
                    modifier = Modifier

                )
                Spacer(modifier = Modifier.width(5.dp))


                Text(
                    text = "sandeepreddy",
                    fontSize = 20.sp, // set the font size
                    textAlign = TextAlign.Center // align text to center horizontally
                )
            }
        }


}



@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}