package com.example.lrh.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lrh.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Support(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        IconButton(
                            onClick = onBackClick
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = modifier.size(35.dp)
                            )
                        }
                        Text(
                            text = "Support",
                            fontSize = 27.sp,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )

                    }
                },
                expandedHeight = 40.dp
            )
        }
    ) {innerPadding->
        Column(
            modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Card(
                modifier = modifier.height(250.dp).padding(5.dp),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
            ) {
                Box(
                    modifier.padding(5.dp).fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier
                            .padding(5.dp)
                            .fillMaxSize()
                    ) {
                        Spacer(modifier = modifier.height(5.dp))
                        Text(
                            text = "Support Team:",
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = modifier.height(10.dp))
                        Text(
                            text = "Do you have anything to say to us? Contact our support team on WhatsApp.",
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 15.sp
                        )
                        Spacer(modifier = modifier.height(10.dp))
                        Row(
                            modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            OutlinedButton(
                                onClick = {}
                            ) {
                                Text(
                                    text = "Chat Us",
                                    color = MaterialTheme.colorScheme.onPrimary

                                )
                            }
                            OutlinedButton(
                                onClick = {}
                            ) {
                                Text(
                                    text = "Join Our WhatsApp Group",
                                    color = MaterialTheme.colorScheme.onPrimary

                                )
                            }
                        }
                    }
                }
            }
        }



    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Notification(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        IconButton(
                            onClick = onBackClick
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = modifier.size(35.dp)
                            )
                        }
                        Text(
                            text = "Notification",
                            fontSize = 27.sp,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )

                    }
                },
                expandedHeight = 40.dp
            )
        }
    ) {innerPadding->
        Column(
            modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Card(
                modifier = modifier.height(250.dp).padding(5.dp),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
            ) {
                Box(
                    modifier.padding(5.dp).fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier
                            .padding(5.dp)
                            .fillMaxSize()
                    ) {
                        Spacer(modifier = modifier.height(5.dp))
                        Text(
                            text = "Notification:",
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = modifier.height(10.dp))
                        Text(
                            text = stringResource(R.string.notification_text),
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 15.sp
                        )
                        Spacer(modifier = modifier.height(10.dp))
                    }
                }
            }
        }



    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Referral(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        IconButton(
                            onClick = onBackClick
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = modifier.size(35.dp)
                            )
                        }
                        Text(
                            text = "Referral",
                            fontSize = 27.sp,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )

                    }
                },
                expandedHeight = 40.dp
            )
        }
    ) {innerPadding->
        Column(
            modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Card(
                modifier = modifier.height(350.dp).padding(5.dp),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
            ) {
                Box(
                    modifier.padding(5.dp).fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier
                            .padding(5.dp)
                            .fillMaxSize()
                    ) {
                        Spacer(modifier = modifier.height(5.dp))
                        Text(
                                text = "Referral System:",
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = modifier.height(10.dp))
                        Text(
                            text = stringResource(R.string.referral_text),
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 15.sp
                        )
                        Spacer(modifier = modifier.height(10.dp))
                        Text(
                            text = "Referral Link:",
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = modifier.height(10.dp))
                        Text(
                            text = "https://loyarahi.com/register?referrer=Damdlord",
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 18.sp,
                        )
                        Spacer(modifier = modifier.height(10.dp))
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(Color.Black)
                        ) {
                            Text(
                                text = "Copy",
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                        Spacer(modifier = modifier.height(10.dp))
                        OutlinedButton(
                            onClick = {},
                            shape = RectangleShape
                        ) {
                            Text(
                                text = "Referral Record",
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                }
            }
        }



    }
}



@Preview
@Composable
fun ShowSupport(){
    MaterialTheme {
        Referral(
            onBackClick = {}
        )
    }
}