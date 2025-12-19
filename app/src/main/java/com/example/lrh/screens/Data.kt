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
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.lrh.data.DataPlanList
import com.example.lrh.data.DataType
import com.example.lrh.data.NetworkList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Data(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
){
    var isSelectNetworkDropdownExpanded by remember { mutableStateOf(false) }
    var isSelectPlanDropdownExpanded by remember { mutableStateOf(false) }
    var isSelectTypeDropdownExpanded by remember { mutableStateOf(false) }
    var bypassValidatorChecked by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("") }
    var selectedDataPlan by remember { mutableStateOf("") }
    var selectedDataType by remember { mutableStateOf("") }
    var numberInput by remember { mutableStateOf("") }

    val dataTypeList = when(selectedOption){
        NetworkList.networkList[1] -> DataType.MTNDataTypeList
        NetworkList.networkList[2] -> DataType.AirtelDataType
        NetworkList.networkList[3] -> DataType.NineMobileDtaType
        NetworkList.networkList[4] -> DataType.GLODtaType
        else -> listOf()
    }
    val dataPlanList = when(selectedOption to selectedDataType){
        NetworkList.networkList[1] to DataType.MTNDataTypeList[1] -> DataPlanList.mtnSME
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] -> DataPlanList.mtnGifting
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] -> DataPlanList.ntnCorporate
        NetworkList.networkList[1] to DataType.MTNDataTypeList[4] -> DataPlanList.mtnSmePlus
        NetworkList.networkList[2] to DataType.AirtelDataType[1] -> DataPlanList.airtelGifting
        NetworkList.networkList[2] to DataType.AirtelDataType[2] -> DataPlanList.airtelCorporate
        NetworkList.networkList[4] to DataType.GLODtaType[1] -> DataPlanList.gloCorporate
        NetworkList.networkList[4] to DataType.GLODtaType[2] -> DataPlanList.gloGifting
        NetworkList.networkList[4] to DataType.GLODtaType[3] -> DataPlanList.gloAwoof
        NetworkList.networkList[3] to DataType.NineMobileDtaType[1] -> DataPlanList.nineMobileCorporate
        else -> listOf("")
    }
    val  amountToPay = when(selectedOption to selectedDataType to selectedDataPlan){
        //MTN SME
        NetworkList.networkList[1] to DataType.MTNDataTypeList[1] to DataPlanList.mtnSME[1] -> "680"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[1] to DataPlanList.mtnSME[2] -> "1350"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[1] to DataPlanList.mtnSME[3] -> "1989"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[1] to DataPlanList.mtnSME[4] -> "3300"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[1] to DataPlanList.mtnSME[5] -> "5050"
        // MTN /Gifting
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[1] -> "480"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[2] -> "850"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[3] -> "1580"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[4] -> "550"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[5] -> "650"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[6] -> "850"
        // MTN / Corporate
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[1]-> "450"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[2]-> "750"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[3]-> "1350"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[4]-> "1850"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[5]-> "3050"
        // AIRTEL/ Gifting
        NetworkList.networkList[2] to DataType.AirtelDataType[1] to DataPlanList.airtelGifting[1]-> "480"
        NetworkList.networkList[2] to DataType.AirtelDataType[1] to DataPlanList.airtelGifting[2]-> "680"
        NetworkList.networkList[2] to DataType.AirtelDataType[1] to DataPlanList.airtelGifting[3]-> "1200"
        NetworkList.networkList[2] to DataType.AirtelDataType[1] to DataPlanList.airtelGifting[4]-> "2200"
        NetworkList.networkList[2] to DataType.AirtelDataType[1] to DataPlanList.airtelGifting[5]-> "3250"
        // AIRTEL/Corporate
        NetworkList.networkList[2] to DataType.AirtelDataType[2] to DataPlanList.airtelCorporate[1]-> "550"
        NetworkList.networkList[2] to DataType.AirtelDataType[2] to DataPlanList.airtelCorporate[2]-> "850"
        NetworkList.networkList[2] to DataType.AirtelDataType[2] to DataPlanList.airtelCorporate[3]-> "1550"
        NetworkList.networkList[2] to DataType.AirtelDataType[2] to DataPlanList.airtelCorporate[4]-> "2000"
        // NINE MOBILE/Corporate
        NetworkList.networkList[3] to DataType.NineMobileDtaType[1] to DataPlanList.nineMobileCorporate[0]-> ""
        // GLO/Corporate
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[1]-> "350"
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[2]-> "250"
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[3]-> "4350"
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[4]-> "450"
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[5]-> "880"
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[6]-> "1320"
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[7]-> "2180"
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[8]-> "315"
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[9]-> "920"
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[10]-> "1520"
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[11]-> "278"
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[12]-> "790"

        // GLO/GIFTING
        NetworkList.networkList[4] to DataType.GLODtaType[2] to DataPlanList.gloGifting[1] -> "250"
        NetworkList.networkList[4] to DataType.GLODtaType[2] to DataPlanList.gloGifting[2] -> "350"
        NetworkList.networkList[4] to DataType.GLODtaType[2] to DataPlanList.gloGifting[3] -> "550"
        NetworkList.networkList[4] to DataType.GLODtaType[2] to DataPlanList.gloGifting[4] -> "2050"

        else -> ""
    }
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
                            modifier = modifier.size(35.dp)
                        )
                    }
                }
            )
        }
    ) {innerPadding->
        Column(
            modifier
                .fillMaxSize()
                .padding(innerPadding),
            //horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.Center
        ) {
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
                        ScrollingText("Purchase data bundles at discounted price!")
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
                                        value = numberInput,
                                        onValueChange = { numberInput = it },
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
                                    "Data Packages"
                                )
                                Spacer(modifier.height(10.dp))
                                ExposedDropdownMenuBox(
                                    expanded = isSelectTypeDropdownExpanded,
                                    onExpandedChange = { isSelectTypeDropdownExpanded = !isSelectTypeDropdownExpanded}
                                ) {
                                    OutlinedTextField(
                                        value = selectedDataType,
                                        onValueChange = {},
                                        readOnly = true,
                                        label = { Text("Select type") },
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
                                        dataTypeList.forEach { option ->
                                            DropdownMenuItem(
                                                text = { Text(option) },
                                                onClick = {
                                                    selectedDataType = option
                                                    isSelectTypeDropdownExpanded = false
                                                }
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier.height(10.dp))
                                Text(
                                    "Data Plans"
                                )
                                Spacer(modifier.height(10.dp))
                                ExposedDropdownMenuBox(
                                    expanded = isSelectPlanDropdownExpanded,
                                    onExpandedChange = { isSelectPlanDropdownExpanded = !isSelectPlanDropdownExpanded}
                                ) {
                                    OutlinedTextField(
                                        value = selectedDataPlan,
                                        onValueChange = {},
                                        readOnly = true,
                                        label = { Text(text = "Select Plan") },
                                        trailingIcon = {
                                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = isSelectPlanDropdownExpanded)
                                        },
                                        modifier = modifier
                                            .fillMaxWidth()
                                            .menuAnchor()
                                    )

                                    ExposedDropdownMenu(
                                        expanded = isSelectPlanDropdownExpanded,
                                        onDismissRequest = { isSelectPlanDropdownExpanded = false }
                                    ) {
                                        dataPlanList.forEach { option ->
                                            DropdownMenuItem(
                                                text = { Text(option) },
                                                onClick = {
                                                    selectedDataPlan = option
                                                    isSelectPlanDropdownExpanded = false
                                                }
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier.height(10.dp))
                                OutlinedTextField(
                                    value = amountToPay,
                                    onValueChange = {},
                                    readOnly = true,
                                    label = { Text(text = "Amount to pay") },
                                    modifier = modifier.fillMaxWidth()
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