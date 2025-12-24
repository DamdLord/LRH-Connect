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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lrh.data.AsyncImage
import com.example.lrh.data.CableTvProvider.providerList
import com.example.lrh.data.CableTvProviderServiceList.DSTVServiceList
import com.example.lrh.data.CableTvProviderServiceList.GOTVServiceList
import com.example.lrh.data.CableTvProviderServiceList.STARTIMESServiceList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CableTV(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
){
    var selectedOption by rememberSaveable { mutableStateOf("") }
    var isProviderDropdownExpanded by rememberSaveable { mutableStateOf(false) }
    var isSelectTypeDropdownExpanded by rememberSaveable { mutableStateOf(false) }
    var amount by rememberSaveable { mutableStateOf("")}
    var selectedPackageType by rememberSaveable { mutableStateOf("")}
    val subscriptionList = when(selectedOption){
        providerList[1] -> DSTVServiceList
        providerList[2] -> GOTVServiceList
        providerList[3] -> STARTIMESServiceList
        else -> listOf()
    }
    val amountToPay = when(selectedOption){
        //GOTV
        GOTVServiceList[0] -> "1900"
        GOTVServiceList[1] -> "5800"
        GOTVServiceList[2] -> "3900"
        GOTVServiceList[3] -> "8500"
        GOTVServiceList[4] -> "11400"
        GOTVServiceList[5] -> "16800"
        //DSTV
        DSTVServiceList[0] -> "4400"
        DSTVServiceList[1] -> "19000"
        DSTVServiceList[2] -> "30000"
        DSTVServiceList[3] -> "44500"
        DSTVServiceList[4] -> "6000"
        DSTVServiceList[5] -> "11000"
        DSTVServiceList[6] -> "214745"

        //STARTIMES
        STARTIMESServiceList[0] -> "700"
        STARTIMESServiceList[1] -> "2100"
        STARTIMESServiceList[2] -> "1700"
        STARTIMESServiceList[3] -> "5100"
        STARTIMESServiceList[4] -> "2500"
        STARTIMESServiceList[5] -> "7400"
        STARTIMESServiceList[7] -> "3200"
        STARTIMESServiceList[8] -> "9500"
        STARTIMESServiceList[9] -> "700"
        STARTIMESServiceList[10] -> "2100"
        STARTIMESServiceList[11] -> "1400"
        STARTIMESServiceList[12] -> "4000"
        STARTIMESServiceList[13] -> "2000"
        STARTIMESServiceList[14] -> "6000"
        STARTIMESServiceList[15] -> "3200"
        STARTIMESServiceList[16] -> "9500"
        STARTIMESServiceList[17] -> "1600000000"

        else -> ""
    }
    Scaffold(
        topBar = {
            TopAppBar(
                {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
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
                            text = "Cable Subscription",
                            fontSize = 27.sp,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )

                    }
                },
                expandedHeight = 46.dp
            )
        }
    ) {innerPadding->
        Column(
            modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            Card(
                modifier
                    .fillMaxWidth()
                    .height(550.dp),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
            ) {
                Box(
                    modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column(
                        modifier.fillMaxWidth()
                    ) {
                        ScrollingText("₦50 charge on every purchase")
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
                                    expanded = isProviderDropdownExpanded,
                                    onExpandedChange = {
                                        isProviderDropdownExpanded =
                                            !isProviderDropdownExpanded
                                    }
                                ) {
                                    OutlinedTextField(
                                        value = selectedOption,
                                        onValueChange = { },
                                        readOnly = true,
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
                                                    providerList[1] -> {
                                                        AsyncImage(
                                                            "data:image/jpeg;base64,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"
                                                        )
                                                    }
                                                    providerList[2] -> {
                                                        AsyncImage(
                                                            "data:image/png;base64,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"
                                                        )
                                                    }
                                                    providerList[3] -> {
                                                        AsyncImage(
                                                            url = "data:image/jpeg;base64,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"
                                                        )
                                                    }

                                                    else ->AsyncImage(
                                                        "data:image/jpeg;base64,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"
                                                    )
                                                }
                                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isProviderDropdownExpanded)
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
                                        expanded = isProviderDropdownExpanded,
                                        matchAnchorWidth = false,
                                        containerColor = MaterialTheme.colorScheme.primary,
                                        onDismissRequest = {
                                            isProviderDropdownExpanded = false
                                        }
                                    ) {
                                        DropdownMenuItem(
                                            leadingIcon = {
                                                AsyncImage(
                                                    url = "data:image/jpeg;base64,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"
                                                )
                                            },
                                            text = {
                                                Text(
                                                    text = providerList[1],
                                                    color = MaterialTheme.colorScheme.onPrimary,
                                                    fontSize = 18.sp
                                                )
                                            },
                                            onClick = {
                                                selectedOption = providerList[1]
                                                isProviderDropdownExpanded = false
                                            }
                                        )
                                        Spacer(modifier.height(5.dp))
                                        HorizontalDivider()
                                        Spacer(modifier.height(5.dp))
                                        DropdownMenuItem(
                                            leadingIcon = {
                                                AsyncImage(
                                                    "data:image/png;base64,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"
                                                )
                                            },
                                            text = {
                                                Text(
                                                    text = providerList[2],
                                                    color = MaterialTheme.colorScheme.onPrimary,
                                                    fontSize = 18.sp
                                                )
                                            },
                                            onClick = {
                                                selectedOption = providerList[2]
                                                isProviderDropdownExpanded = false
                                            }
                                        )
                                        Spacer(modifier.height(5.dp))
                                        HorizontalDivider()
                                        Spacer(modifier.height(5.dp))
                                        DropdownMenuItem(
                                            leadingIcon = {
                                                AsyncImage(
                                                    "data:image/jpeg;base64,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"
                                                )
                                            },
                                            text = {
                                                Text(
                                                    text = providerList[3],
                                                    color = MaterialTheme.colorScheme.onPrimary,
                                                    fontSize = 18.sp
                                                )
                                            },
                                            onClick = {
                                                selectedOption = providerList[3]
                                                isProviderDropdownExpanded = false
                                            }
                                        )
                                    }
                                }
                                Spacer(modifier.height(10.dp))
                                Text(
                                    "Select Package"
                                )
                                Spacer(modifier.height(10.dp))
                                ExposedDropdownMenuBox(
                                    expanded = isSelectTypeDropdownExpanded,
                                    onExpandedChange = { isSelectTypeDropdownExpanded = !isSelectTypeDropdownExpanded}
                                ) {
                                    OutlinedTextField(
                                        value = selectedPackageType,
                                        onValueChange = {},
                                        readOnly = true,
                                        label = { Text("Select package") },
                                        trailingIcon = {
                                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = isSelectTypeDropdownExpanded)
                                        },
                                        modifier = modifier
                                            .fillMaxWidth()
                                            .menuAnchor()
                                    )

                                    ExposedDropdownMenu(
                                        expanded = isSelectTypeDropdownExpanded,
                                        onDismissRequest = { isSelectTypeDropdownExpanded = false }
                                    ) {
                                        subscriptionList.forEach { option ->
                                            DropdownMenuItem(
                                                text = { Text(option) },
                                                onClick = {
                                                    selectedPackageType = option
                                                    isSelectTypeDropdownExpanded = false
                                                }
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier.height(10.dp))
                                Text(
                                    "Amount"
                                )
                                Spacer(modifier.height(10.dp))
                                OutlinedTextField(
                                    value = amount,
                                    onValueChange = {amount = it},
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Phone,
                                        imeAction = ImeAction.Done
                                    ),
                                    readOnly = true,
                                    modifier = modifier.fillMaxWidth()
                                )
                                Spacer(modifier.height(10.dp))
                                Button(
                                    onClick = {},
                                    shape = RectangleShape,
                                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
                                    modifier = modifier.fillMaxWidth().height(50.dp)
                                ) {
                                    Text(
                                        "Verify Meter",
                                        color = MaterialTheme.colorScheme.onPrimary,
                                        fontSize = 18.sp
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
