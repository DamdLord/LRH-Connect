package com.example.lrh.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.PhoneIphone
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lrh.R
import com.example.lrh.data.Services.airtelService
import com.example.lrh.data.Services.gloService
import com.example.lrh.data.Services.mtnService
import com.example.lrh.data.Services.nineMobileService
import com.example.lrh.ui.theme.airtelColor
import com.example.lrh.ui.theme.gloColor
import com.example.lrh.ui.theme.goldLight
import com.example.lrh.ui.theme.mtnColor
import com.example.lrh.ui.theme.nineMobileColor

@Composable
fun Onboarding(
    modifier: Modifier = Modifier,
    omRegisterClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    Scaffold{innerPadding ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.loyarahi),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    HorizontalDivider(
                        modifier = modifier
                            .fillMaxWidth()
                            .height(4.dp)
                    )
                    Spacer(modifier = modifier.height(60.dp))
                    Text(
                        text = stringResource(R.string.welcome),
                        fontSize = 45.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Text(
                        text = stringResource(R.string.loyarahi),
                        fontSize = 45.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Text(
                        text = stringResource(R.string.under_welcome),
                        modifier = modifier.padding(top = 1.dp),
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(modifier = modifier.height(20.dp))
                    Row(modifier = modifier.fillMaxWidth()) {
                        Button(
                            onClick = omRegisterClick,
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(goldLight),
                            modifier = modifier.size(width = 130.dp, height = 50.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.register),
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = 18.sp
                            )
                        }

                        Spacer(modifier = modifier.width(30.dp))

                        OutlinedButton(
                            onClick = onLoginClick,
                            modifier = modifier.size(width = 110.dp, height = 50.dp),
                            shape = RoundedCornerShape(20.dp),
                            border = BorderStroke(2.dp, MaterialTheme.colorScheme.onPrimary)
                        ) {
                            Text(
                                text = stringResource(R.string.login),
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontSize = 18.sp
                            )
                        }
                    }
                    Spacer(modifier = modifier.height(50.dp))
                }
            }
            Spacer(modifier = modifier.height(20.dp))
            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.our_services),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 35.sp
                )
                Spacer(modifier = modifier.height(10.dp))
                Card(
                    colors = CardDefaults.cardColors(goldLight),
                    modifier = modifier.size(width = 68.dp, height = 5.dp)
                ) {}
                Spacer(modifier = modifier.height(10.dp))
                Text(
                    text = stringResource(R.string.under_bar),
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = modifier.height(20.dp))
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                // Row for buy data bundle and buy airtime
                Row(
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                ) {
                    Card(
                        shape = RoundedCornerShape(5.dp),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                        modifier = modifier.size(width = 195.dp, height = 250.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = modifier
                                .fillMaxSize()
                                .padding(2.dp)
                        ) {

                            Icon(
                                imageVector = Icons.Filled.Phone,
                                contentDescription = "",
                                tint = goldLight,
                                modifier = modifier.size(50.dp)
                            )
                            Text(
                                text = stringResource(R.string.buy_data_bundle),
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontSize = 23.sp
                            )
                            Text(
                                text = stringResource(R.string.buy_data_bundle_text),
                                color = MaterialTheme.colorScheme.onPrimary,
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp
                            )
                        }
                    }
                    Spacer(modifier = modifier.width(5.dp))
                    Card(
                        shape = RoundedCornerShape(5.dp),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                        modifier = modifier.size(width = 195.dp, height = 250.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = modifier
                                .fillMaxSize()
                                .padding(2.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.PhoneIphone,
                                contentDescription = "",
                                tint = goldLight,
                                modifier = modifier.size(50.dp)
                            )
                            Text(
                                text = stringResource(R.string.buy_airtime),
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontSize = 23.sp
                            )
                            Text(
                                text = stringResource(R.string.buy_airtime_text),
                                color = MaterialTheme.colorScheme.onPrimary,
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                // Row for cable tv and electricity bill
                Spacer(modifier = modifier.height(5.dp))
                Row(
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                ) {
                    Card(
                        shape = RoundedCornerShape(5.dp),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                        modifier = modifier.size(width = 195.dp, height = 250.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = modifier
                                .fillMaxSize()
                                .padding(2.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Tv,
                                contentDescription = "",
                                tint = goldLight,
                                modifier = modifier.size(50.dp)
                            )
                            Text(
                                text = stringResource(R.string.cableTV),
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontSize = 23.sp,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = stringResource(R.string.cableTv_text),
                                color = MaterialTheme.colorScheme.onPrimary,
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp
                            )
                        }
                    }
                    Spacer(modifier = modifier.width(5.dp))
                    Card(
                        shape = RoundedCornerShape(5.dp),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                        modifier = modifier.size(width = 195.dp, height = 250.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = modifier
                                .fillMaxSize()
                                .padding(2.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Lightbulb,
                                contentDescription = "",
                                tint = goldLight,
                                modifier = modifier.size(50.dp)
                            )
                            Text(
                                text = stringResource(R.string.pay_electricity_bill),
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontSize = 23.sp,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = stringResource(R.string.elctricity_text),
                                color = MaterialTheme.colorScheme.onPrimary,
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp
                            )
                        }
                    }
                }
            }
            Spacer(modifier = modifier.height(30.dp))
            Box(
                modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .fillMaxWidth()
            ) {

                Column(
                    modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = modifier.height(30.dp))
                    Text(
                        text = stringResource(R.string.why_choose_us),
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    Card(
                        colors = CardDefaults.cardColors(goldLight),
                        shape = RoundedCornerShape(5.dp),
                        modifier = modifier.size(height = 5.dp, width = 68.dp)
                    ) {}
                    Spacer(modifier = modifier.height(30.dp))
                    //We are fast column
                    Column(
                        modifier = modifier.padding(5.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(R.drawable.we_are_fast),
                            contentDescription = null,
                            modifier = modifier.size(75.dp)
                        )
                        Text(
                            text = stringResource(R.string.we_are_fast),
                            color = goldLight,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = stringResource(R.string.we_are_fast_text),
                            color = MaterialTheme.colorScheme.onPrimary,
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(modifier = modifier.height(30.dp))
                    // You are safe column
                    Column(
                        modifier = modifier.padding(5.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(R.drawable.you_are_safe),
                            contentDescription = null,
                            modifier = modifier.size(75.dp)
                        )
                        Text(
                            text = stringResource(R.string.you_are_safe),
                            color = goldLight,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = stringResource(R.string.you_are_safe_text),
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = modifier.height(30.dp))
                    // We are reliable column
                    Column(
                        modifier = modifier.padding(5.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(R.drawable.we_are_reliable),
                            contentDescription = null,
                            modifier = modifier.size(75.dp),
                        )
                        Text(
                            text = stringResource(R.string.we_are_reliable),
                            color = goldLight,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = stringResource(R.string.we_are_reliable_text),
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = modifier.height(30.dp))
                }
            }
            Spacer(modifier = modifier.height(30.dp))
            Column(
                modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(R.string.our_exclusive_data_plan),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = modifier.height(10.dp))
                Card(
                    colors = CardDefaults.cardColors(goldLight),
                    shape = RoundedCornerShape(5.dp),
                    modifier = modifier.size(height = 5.dp, width = 68.dp)
                ) {}
            }
            Spacer(modifier = modifier.height(20.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .horizontalScroll(rememberScrollState()),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,

                ) {
                ServiceCard(
                    image = painterResource(R.drawable.mtn_logo),
                    texts = mtnService,
                    color = mtnColor
                )
                Spacer(modifier.width(5.dp))
                ServiceCard(
                    image = painterResource(R.drawable.glo_logo),
                    texts = gloService,
                    color = gloColor
                )
                Spacer(modifier.width(5.dp))
                ServiceCard(
                    image = painterResource(R.drawable.airtel_logo),
                    texts = airtelService,
                    color = airtelColor
                )
                Spacer(modifier.width(5.dp))
                ServiceCard(
                    image = painterResource(R.drawable._mobile_logo),
                    texts = nineMobileService,
                    color = nineMobileColor
                )
            }
            Spacer(modifier = modifier.height(50.dp))
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.become_a_reseller),
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    OutlinedButton(
                        onClick = {},
                        border = BorderStroke(2.dp, MaterialTheme.colorScheme.onPrimary)
                    ) {
                        Text(
                            text = stringResource(R.string.get_started),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }
            Spacer(modifier = modifier.height(50.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .fillMaxWidth()
                    //.height(300.dp)
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.about_us),
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    Text(
                        text = stringResource(R.string.our_vtu),
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = modifier.height(30.dp))
                    Text(
                        text = stringResource(R.string.contact_us),
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    Text(
                        text = stringResource(R.string.phone),
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        textDecoration = TextDecoration.Underline
                    )
                    Text(
                        text = stringResource(R.string.email),
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        textDecoration = TextDecoration.Underline
                    )
                    Text(
                        text = stringResource(R.string.address),
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = stringResource(R.string.open_hours),
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = modifier.height(20.dp))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(R.string.copyright),
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 20.sp
                        )
                    }
                }
            }
            Spacer(modifier = modifier.height(30.dp))
        }
    }
}
@Composable
fun ServiceCard(
    image: Painter,
    texts: List<String>,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(color),
        modifier = modifier
            .height(400.dp)
            .width(250.dp)
    ) {
        Column(
            modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = "",
                modifier
                    .clip(CircleShape)
                    .border(width = 2.dp, Color.White, CircleShape)
                    .size(75.dp),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = modifier.height(20.dp))
            Text(
                text = texts[0],
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Spacer(modifier = modifier.height(5.dp))
            HorizontalDivider(
                modifier.fillMaxWidth(),
                color = Color.White,
                thickness = 2.dp
            )
            Spacer(modifier = modifier.height(5.dp))
            Text(
                text = texts[1],
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Spacer(modifier = modifier.height(5.dp))
            HorizontalDivider(
                modifier.fillMaxWidth(),
                color = Color.White,
                thickness = 2.dp
            )
            Spacer(modifier = modifier.height(5.dp))
            Text(
                text = texts[2],
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Spacer(modifier = modifier.height(5.dp))
            HorizontalDivider(
                modifier.fillMaxWidth(),
                color = Color.White,
                thickness = 2.dp
            )
            Spacer(modifier = modifier.height(5.dp))
            Text(
                text = texts[3],
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Spacer(modifier = modifier.height(5.dp))
            HorizontalDivider(
                modifier.fillMaxWidth(),
                color = Color.White,
                thickness = 2.dp
            )
            Spacer(modifier = modifier.height(5.dp))
            Text(
                text = texts[4],
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Spacer(modifier = modifier.height(5.dp))
            HorizontalDivider(
                modifier.fillMaxWidth(),
                color = Color.White,
                thickness = 2.dp
            )
            Spacer(modifier = modifier.height(5.dp))
            Text(
                text = texts[5],
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Spacer(modifier = modifier.height(5.dp))
            HorizontalDivider(
                modifier.fillMaxWidth(),
                color = Color.White,
                thickness = 2.dp
            )
            Spacer(modifier = modifier.height(5.dp))
            Text(
                text = texts[6],
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Spacer(modifier = modifier.height(5.dp))
            HorizontalDivider(
                modifier.fillMaxWidth(),
                color = Color.White,
                thickness = 2.dp
            )
            Spacer(modifier = modifier.height(5.dp))
            Text(
                text =texts[7],
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Spacer(modifier = modifier.height(5.dp))
            HorizontalDivider(
                modifier.fillMaxWidth(),
                color = Color.White,
                thickness = 2.dp
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    MaterialTheme {
        Onboarding(
            omRegisterClick = { },
            onLoginClick = {}
        )
    }
}
@Preview
@Composable
fun cardPreview() {
    MaterialTheme {
        ServiceCard(
            image = painterResource(R.drawable.mtn_logo),
            texts = mtnService,
            color = mtnColor
        )
    }
}

