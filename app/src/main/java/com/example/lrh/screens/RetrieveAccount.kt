package com.example.lrh.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.PersonOutline
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lrh.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RetrieveAccount(
    modifier: Modifier = Modifier,
    onVerifyClick: () -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                {
                    IconButton(
                        onClick = onBackClick
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = modifier.size(40.dp)
                        )
                    }
                },
                expandedHeight = 46.dp
            )
        }
    ) { padding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            RetrieveAccountCard(
                onVerifyClick = onVerifyClick,
            )
        }
    }
}

@Composable
fun RetrieveAccountCard(
    modifier: Modifier = Modifier,
    onVerifyClick: () -> Unit,
) {
    var email by rememberSaveable { mutableStateOf("") }
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth(0.9f)

            .wrapContentHeight(),
        elevation = CardDefaults.elevatedCardElevation(10.dp),
        colors = CardDefaults.elevatedCardColors(MaterialTheme.colorScheme.onPrimary),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                modifier = modifier.size(80.dp),
                shape = CircleShape
            ) {
                Column(
                    modifier = modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Outlined.PersonOutline,
                        contentDescription = "",
                        modifier = modifier.size(60.dp)
                    )
                }
            }
            Text(
                text = stringResource(R.string.retrieve_account),
                color = MaterialTheme.colorScheme.primary,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            TextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Email") },
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF3F3F3),
                    focusedContainerColor = Color(0xFFF3F3F3),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = MaterialTheme.colorScheme.primary
                )
            )

            Button(
                onClick = onVerifyClick,
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
                shape = RectangleShape,
                modifier = modifier.fillMaxWidth().height(50.dp)
            ) {
                Text(
                    stringResource(R.string.verify),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 18.sp
                )
            }

        }
    }
}
