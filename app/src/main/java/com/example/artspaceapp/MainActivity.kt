package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ViewModel>()
    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ArtSpaceAppTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                    ,
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(modifier = Modifier
                            .width(500.dp)
                            .height(550.dp)
                            .padding(2.dp)
                            .shadow(
                                elevation = 5.dp,
                                spotColor = Color.Black
                            )
                            .padding(
                                top = 40.dp,
                                end = 40.dp,
                                start = 40.dp,
                                bottom = 40.dp,
                            )
                            .shadow(
                                elevation = 10.dp,
                            ),
                            contentAlignment = Alignment.Center

                        ){
                            Image(painter = painterResource(id = viewModel.image),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                alignment = Alignment.Center,
                                modifier = Modifier.size(450.dp)
                            )
                        }
                        
                        Box(modifier = Modifier.fillMaxWidth().height(20.dp))

                        Box(
                            modifier = Modifier
                                .width(500.dp)
                                .height(120.dp)
                                .background(Color(0xFFecebf4))
                        ){
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally

                            ) {
                                Text(text = viewModel.titleText,
                                    fontSize = 26.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                                Text(text = viewModel.artistText,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Light
                                )
                            }
                        }

                        Box(modifier = Modifier.fillMaxWidth().height(20.dp))

                        Box(
                            modifier = Modifier
                                .width(500.dp)
                                .height(150.dp)
                        ){
                            Row(modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                                )
                            {
                                Button(onClick = {
                                    if (count == 1) count = 1
                                    else count -= 1
                                    viewModel.changeImage(count)
                                    viewModel.changeArtist(count)
                                    viewModel.changeTitle(count)
                                },
                                    Modifier
                                        .width(120.dp)
                                        .height(50.dp)
                                        .shadow(
                                            elevation = 10.dp,
                                            shape = RoundedCornerShape(20.dp)
                                        ),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBBD0FF),
                                        contentColor = Color.White),
                                    shape = RoundedCornerShape(20.dp),
                                )
                                {
                                    Text(text = "Previous")
                                }

                                Button(onClick = {
                                    count += 1
                                    viewModel.changeImage(count)
                                    viewModel.changeArtist(count)
                                    viewModel.changeTitle(count)
                                                 },
                                    Modifier
                                        .width(120.dp)
                                        .height(50.dp)
                                        .shadow(
                                            elevation = 10.dp,
                                            shape = RoundedCornerShape(20.dp)
                                        ),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBBD0FF),
                                        contentColor = Color.White),
                                    shape = RoundedCornerShape(20.dp),
                                )
                                {
                                    Text(text = "Next")
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}
