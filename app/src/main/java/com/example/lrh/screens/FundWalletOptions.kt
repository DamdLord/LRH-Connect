package com.example.lrh.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FundWallet(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
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
                            text = "Fund Wallet",
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
            modifier.fillMaxSize().padding(innerPadding)
        ) {
            Spacer(modifier.height(10.dp))
            Text(
                text = "Fund Wallet Options",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(6.dp)
            )
            Spacer(modifier.height(10.dp))
            ElevatedCard(
                elevation = CardDefaults.elevatedCardElevation(10.dp),
                modifier = modifier.padding(6.dp).height(85.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = modifier.fillMaxSize().padding(4.dp)
                ) {
                    Text(
                        "Below are the Wallet Funding options that we have for you.",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
            Spacer(modifier.height(20.dp))
            Button(
                onClick = {},
                shape = RectangleShape,
                modifier = modifier.size(width = 220.dp, height = 50.dp).padding(6.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = "AUTOMATED FUNDING",
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            Spacer(modifier.height(10.dp))
            Button(
                onClick = {},
                shape = RectangleShape,
                modifier = modifier.size(width = 220.dp, height = 50.dp).padding(6.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = "ATM FUNDING",
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            Spacer(modifier.height(10.dp))
            Button(
                onClick = {},
                shape = RectangleShape,
                modifier = modifier.size(width = 220.dp, height = 50.dp).padding(6.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = "MANUAL FUNDING",
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}