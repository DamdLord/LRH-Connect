package com.example.lrh.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lrh.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Airtime(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
){
    var phoneNumber by rememberSaveable{ mutableStateOf("") }
    var amount by rememberSaveable{ mutableStateOf("") }
    var selectedOption by rememberSaveable{ mutableStateOf("") }
    var bypassValidatorChecked by rememberSaveable{ mutableStateOf(false) }
    var isSelectNetworkDropdownExpanded by rememberSaveable{ mutableStateOf(false) }

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
                            modifier = modifier.size(30.dp)
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
                .padding(innerPadding)
        ){
            Card(
                modifier
                    .fillMaxWidth()
                    .height(550.dp),
                //elevation = CardDefaults.elevatedCardElevation(10.dp),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
            ) {
                Box(
                    modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column(
                        modifier.fillMaxWidth()
                    ) {
                        ScrollingText("2% discount on every purchase")
                        Card(
                            modifier
                                .fillMaxWidth()
                                .height(500.dp),
                            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onPrimary)
                        ) {
                            Column(
                                modifier
                                    .fillMaxSize()
                                    .padding(8.dp),
                                horizontalAlignment = Alignment.Start,
                                ) {
                                ExposedDropdownMenuBox(
                                    expanded = isSelectNetworkDropdownExpanded,
                                    onExpandedChange = {
                                        isSelectNetworkDropdownExpanded =
                                            !isSelectNetworkDropdownExpanded
                                    }
                                ) {
                                    OutlinedTextField(
                                        value = phoneNumber,
                                        onValueChange = { phoneNumber = it },
                                        readOnly = false,
                                        singleLine = true,
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Done),
                                        maxLines = 1,
                                        leadingIcon = {
                                            Row(
                                                modifier.wrapContentSize(),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.Start
                                            ) {
                                                when (selectedOption) {
                                                    "MTN" -> {
                                                        Image(
                                                            painter = painterResource(R.drawable.mtn_logo),
                                                            contentDescription = "",
                                                            modifier = modifier
                                                                .size(40.dp)
                                                                .clip(CircleShape)
                                                        )
                                                    }
                                                    "GLO" -> {
                                                        Image(
                                                            painter = painterResource(R.drawable.glo_logo),
                                                            contentDescription = "",
                                                            modifier = modifier
                                                                .size(40.dp)
                                                                .clip(CircleShape)
                                                        )
                                                    }
                                                    "AIRTEL" -> {
                                                        Image(
                                                            painter = painterResource(R.drawable.airtel_logo),
                                                            contentDescription = "",
                                                            modifier = modifier
                                                                .size(40.dp)
                                                                .clip(CircleShape)
                                                        )
                                                    }
                                                    "9MOBILE" -> {
                                                        Image(
                                                            painter = painterResource(R.drawable._mobile_logo),
                                                            contentDescription = "",
                                                            modifier = modifier
                                                                .size(40.dp)
                                                                .clip(CircleShape)
                                                        )
                                                    }

                                                    else -> Image(
                                                        painter = painterResource(R.drawable.mtn_logo),
                                                        contentDescription = "",
                                                        modifier = modifier.size(40.dp).clip(CircleShape)
                                                    )
                                                }
                                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isSelectNetworkDropdownExpanded)
                                            }
                                        },
                                        trailingIcon = {
                                            // ExposedDropdownMenuDefaults.TrailingIcon(expanded = isSelectNetworkDropdownExpanded)
                                        },
                                        colors = TextFieldDefaults.colors(
                                            unfocusedContainerColor = Color(0xFFF3F3F3),
                                            focusedContainerColor = Color(0xFFF3F3F3),
                                            unfocusedIndicatorColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent,
                                            disabledIndicatorColor = Color.Transparent,
                                            cursorColor = MaterialTheme.colorScheme.primary
                                        ),
                                        modifier = modifier
                                            .wrapContentSize()
                                            .fillMaxWidth()
                                            .menuAnchor()
                                    )

                                    ExposedDropdownMenu(
                                        expanded = isSelectNetworkDropdownExpanded,
                                        containerColor = MaterialTheme.colorScheme.primary,
                                        onDismissRequest = {
                                            isSelectNetworkDropdownExpanded = false
                                        }
                                    ) {
                                        DropdownMenuItem(
                                            leadingIcon = {
                                                Image(
                                                    painter = painterResource(R.drawable.mtn_logo),
                                                    contentDescription = null,
                                                    modifier
                                                        .size(50.dp)
                                                        .clip(CircleShape),

                                                    )
                                            },
                                            text = {
                                                Text(
                                                    text = "MTN",
                                                    color = MaterialTheme.colorScheme.onPrimary,
                                                    fontSize = 18.sp
                                                )
                                            },
                                            onClick = {
                                                selectedOption = "MTN"
                                                isSelectNetworkDropdownExpanded = false
                                            }
                                        )
                                        DropdownMenuItem(
                                            leadingIcon = {
                                                Image(
                                                    painter = painterResource(R.drawable.glo_logo),
                                                    contentDescription = null,
                                                    modifier
                                                        .size(50.dp)
                                                        .clip(CircleShape)
                                                )
                                            },
                                            text = {
                                                Text(
                                                    text = "GLO",
                                                    color = MaterialTheme.colorScheme.onPrimary,
                                                    fontSize = 18.sp
                                                )
                                            },
                                            onClick = {
                                                selectedOption = "GLO"
                                                isSelectNetworkDropdownExpanded = false
                                            }
                                        )
                                        DropdownMenuItem(
                                            leadingIcon = {
                                                Image(
                                                    painter = painterResource(R.drawable.airtel_logo),
                                                    contentDescription = null,
                                                    modifier
                                                        .size(50.dp)
                                                        .clip(CircleShape)
                                                )
                                            },
                                            text = {
                                                Text(
                                                    text = "AIRTEL",
                                                    color = MaterialTheme.colorScheme.onPrimary,
                                                    fontSize = 18.sp
                                                )
                                            },
                                            onClick = {
                                                selectedOption = "AIRTEL"
                                                isSelectNetworkDropdownExpanded = false
                                            }
                                        )
                                        DropdownMenuItem(
                                            leadingIcon = {
                                                Image(
                                                    painter = painterResource(R.drawable._mobile_logo),
                                                    contentDescription = null,
                                                    modifier
                                                        .size(50.dp)
                                                        .clip(CircleShape)
                                                )
                                            },
                                            text = {
                                                Text(
                                                    text = "9MOBILE",
                                                    color = MaterialTheme.colorScheme.onPrimary,
                                                    fontSize = 20.sp
                                                )
                                            },
                                            onClick = {
                                                selectedOption = "9MOBILE"
                                                isSelectNetworkDropdownExpanded = false
                                            }
                                        )

                                    }
                                }
                                Spacer(modifier.height(10.dp))
                                Text(
                                    "Amount"
                                )
                                Spacer(modifier.height(10.dp))
                                OutlinedTextField(
                                    value = amount,
                                    onValueChange = { amount = it},
                                    readOnly = false,
                                    maxLines = 1 ,
                                    modifier = modifier.fillMaxWidth(),
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Done)
                                )
                                Spacer(modifier.height(10.dp))
                                Row(
                                    modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start
                                ) {
                                    Checkbox(
                                        checked = bypassValidatorChecked,
                                        onCheckedChange = { bypassValidatorChecked = !bypassValidatorChecked}
                                    )
                                    Text(
                                        text = "Bypass validation"
                                    )
                                }
                                Spacer(modifier.height(10.dp))
                                Button(
                                    onClick = {},
                                    shape = RectangleShape,
                                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
                                    modifier = modifier.fillMaxWidth().height(50.dp)
                                ) {
                                    Text(
                                        "Purchase",
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

}