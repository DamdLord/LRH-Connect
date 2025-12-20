package com.example.lrh.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lrh.R
import com.example.lrh.ui.theme.LRHTheme

@Composable
fun Login(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit,
    onRetrieveClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            LoginCard(
                onLoginClick = onLoginClick,
                onRetrieveClick = onRetrieveClick,
                onRegisterClick = onRegisterClick
            )
        }
    }
}

@Composable
fun LoginCard(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit,
    onRetrieveClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    var emailOrUsername by rememberSaveable { mutableStateOf("") }
    var passwordInput by rememberSaveable { mutableStateOf("") }
    var seePassword by rememberSaveable { mutableStateOf(false) }
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
            TextField(
                value = emailOrUsername,
                onValueChange = {emailOrUsername = it},
                placeholder = { Text("Email or Username") },
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
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
            TextField(
                value = passwordInput,
                onValueChange = { passwordInput = it},
                placeholder = { Text("Password") },
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                modifier = modifier
                    .fillMaxWidth()
                    .height(56.dp),
                visualTransformation = if (seePassword)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(
                        onClick = {seePassword = !seePassword}
                    ) {
                        if (!seePassword){
                            Icon(
                                imageVector = Icons.Filled.Visibility,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }else{
                            Icon(
                                imageVector = Icons.Filled.VisibilityOff,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                },
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
                onClick = onLoginClick,
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
                shape = RectangleShape,
                modifier = modifier.fillMaxWidth().height(50.dp)
            ) {
                Text(
                    stringResource(R.string.login),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 18.sp
                )
            }
            Row(
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = stringResource(R.string.forgotten_password),
                    color = MaterialTheme.colorScheme.primary
                )
                TextButton(
                    onClick = onRetrieveClick
                ) {
                    Text(
                        text = stringResource(R.string.retrieve_account),
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 18.sp
                    )
                }
            }
            Row(
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = stringResource(R.string.new_user),
                    color = MaterialTheme.colorScheme.primary
                )
                TextButton(
                    onClick = onRegisterClick
                ) {
                    Text(
                        text = stringResource(R.string.register),
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 18.sp
                    )
                }
            }
        }

        fun hashedPassword(passwordInput: String): String{
            var hashed = ""
            val passwordLength = passwordInput.length
            when(passwordLength){
                0 -> ""
                1 -> hashed = "*"
                2 -> hashed = "**"
                3 -> hashed = "***"
                4 -> hashed = "****"
                5 -> hashed = "*****"
                6 -> hashed = "******"
                7 -> hashed = "*******"
                8 -> hashed = "********"
                9 -> hashed = "*********"
                else -> hashed = "**********"

            }
            return  hashed

        }

    }
}


@Preview
@Composable
fun LoginPreview() {
    LRHTheme() {
        Login(
            onLoginClick = {},
            onRetrieveClick = {},
            onRegisterClick = {}
        )
    }
}