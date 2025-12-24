package com.example.lrh.screens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Wallet
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lrh.R
import com.example.lrh.Screens
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = MaterialTheme.colorScheme.primary,
                drawerContentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Text("Menu", modifier = modifier.padding(16.dp))
                HorizontalDivider()
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = "Home",
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    },
                    selected = false,
                    onClick = { navController.navigate(Screens.Home.name)}
                )
                NavigationDrawerItem(
                    label = {
                        Text(
                            "Notification",
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    },
                    selected = false,
                    onClick = { navController.navigate(Screens.Notification.name) }
                )
                NavigationDrawerItem(
                    label = {
                        Text(
                            "Support",
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    },
                    selected = false,
                    onClick = { navController.navigate(Screens.Support.name) }
                )
                NavigationDrawerItem(
                    label = {
                        Text(
                            "Referral",
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    },
                    selected = false,
                    onClick = { navController.navigate(Screens.Referral.name)}
                )
            }
        }
    ) {
        Scaffold() { innerPadding ->
            Column(
                modifier
                    .fillMaxSize()
                    .padding(innerPadding)

            ) {
                IconButton(
                    onClick = { scope.launch { drawerState.open() } },
                ) {
                    Icon(
                        Icons.Default.Menu,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Column(
                    modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .padding(5.dp)
                ) {
                    Text(
                        text = "Hey, John Doe!",
                        fontSize = 23.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                    Spacer(modifier = modifier.padding(5.dp))
                    ElevatedCard(
                        elevation = CardDefaults.elevatedCardElevation(10.dp),
                        colors = CardDefaults.elevatedCardColors(MaterialTheme.colorScheme.primary),
                        shape = RoundedCornerShape(10.dp),
                        modifier = modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier
                                .fillMaxSize()
                                .padding(10.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.available_balance),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.secondary
                            )
                            Row(
                                modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "₦11",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold

                                )
                                Card(
                                    onClick = { navController.navigate(Screens.WalletFunding.name) },
                                    elevation = CardDefaults.elevatedCardElevation(10.dp),
                                    shape = RoundedCornerShape(10.dp),
                                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onPrimary),
                                    modifier = modifier.size(width = 130.dp, height = 45.dp)
                                ) {
                                    Box(
                                        modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center

                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.SpaceAround,
                                            modifier = modifier
                                                .fillMaxWidth()
                                                .padding(5.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Outlined.Wallet,
                                                contentDescription = "",
                                                tint = MaterialTheme.colorScheme.primary
                                            )
                                            Text(
                                                text = stringResource(R.string.fund_wallet),
                                                color = MaterialTheme.colorScheme.primary,
                                                fontWeight = FontWeight.SemiBold
                                            )
                                        }
                                    }
                                }
                            }
                            Spacer(modifier.height(10.dp))
                            Row(
                                modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center

                                ) {
                                    Text(
                                        text = stringResource(R.string.api_level),
                                        color = MaterialTheme.colorScheme.secondary,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 20.sp,
                                    )
                                    Text(
                                        text = "1",
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 20.sp,
                                        color = MaterialTheme.colorScheme.onPrimary
                                    )
                                }
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center

                                ) {
                                    Text(
                                        text = stringResource(R.string.total_transactions),
                                        color = MaterialTheme.colorScheme.secondary,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 20.sp,
                                    )
                                    Text(
                                        text = "13",
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 20.sp,
                                        color = MaterialTheme.colorScheme.onPrimary
                                    )
                                }
                            }
                            Spacer(modifier.height(10.dp))
                            Row(
                                modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Text(
                                    text = stringResource(R.string.account_status),
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier.width(5.dp))
                                Card(
                                    shape = RectangleShape,
                                    colors = CardDefaults.cardColors(Color.Red)
                                ) {
                                    Text(
                                        "Not Verified",
                                        color = Color.White,
                                        modifier = modifier.padding(5.dp)
                                    )
                                }
                            }
                            ScrollingText(
                                stringResource(R.string.how_are_you_doing)
                            )
                        }
                    }
                    Spacer(modifier = modifier.height(10.dp))
                    Column(
                        modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            ServiceOptionCard(
                                image = painterResource(R.drawable.buy_data),
                                text = "Buy Data",
                                onClick = { navController.navigate(Screens.Data.name) }
                            )
                            ServiceOptionCard(
                                image = painterResource(R.drawable.airtime),
                                text = "Airtime",
                                onClick = { navController.navigate(Screens.Airtime.name) }
                            )
                        }
                        Spacer(modifier.height(10.dp))
                        Row(
                            modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            ServiceOptionCard(
                                image = painterResource(R.drawable.bill_payment),
                                text = "Bill Payment",
                                onClick = { navController.navigate(Screens.Bill.name) }
                            )
                            ServiceOptionCard(
                                image = painterResource(R.drawable.bulk_sms),
                                text = "Bulk SMS",
                                onClick = { navController.navigate(Screens.BulkSMS.name) }
                            )
                        }
                        Spacer(modifier.height(10.dp))
                        Row(
                            modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            ServiceOptionCard(
                                image = painterResource(R.drawable.cable),
                                text = "Cable Subscription",
                                onClick = { navController.navigate(Screens.CableTV.name) }
                            )
                            ServiceOptionCard(
                                image = painterResource(R.drawable.result),
                                text = "Result Checker",
                                onClick = {}
                            )
                        }
                        Spacer(modifier.height(10.dp))
                        Row(
                            modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            ServiceOptionCard(
                                image = painterResource(R.drawable.air2cash),
                                text = "Airtime2Cash",
                                onClick = {}
                            )
                            ServiceOptionCard(
                                image = painterResource(R.drawable.api),
                                text = "Api Documentation",
                                onClick = {}
                            )
                        }
                    }

                }

            }
        }
    }
}


@Composable
fun ScrollingText(text: String) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val offsetX by infiniteTransition.animateFloat(
        initialValue = 200f,
        targetValue = -700f,
        animationSpec = infiniteRepeatable(
            animation = tween(8000, easing = LinearEasing)
        ),
        label = ""
    )
    Text(
        text = text,
        modifier = Modifier.offset(x = offsetX.dp),
        maxLines = 1,
        fontSize = 20.sp
    )
}

@Composable
fun ServiceOptionCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    image: Painter,
    text: String
) {
    OutlinedCard(
        onClick = onClick,
        elevation = CardDefaults.elevatedCardElevation(5.dp),
        modifier = modifier.size(width = 150.dp, height = 150.dp),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            Column(
                modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = image,
                    contentDescription = text,
                    modifier = modifier.size(50.dp)
                )
                Spacer(modifier.height(5.dp))
                Text(
                    text = text,
                    fontSize = 18.sp,
                    modifier = modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShowHome() {
    MaterialTheme {
        val navController = rememberNavController()
        Home(
            navController = navController
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowServiceOptionCard() {
    MaterialTheme {
        ServiceOptionCard(
            image = painterResource(R.drawable.cable),
            text = "Cable Subscription",
            onClick = {}
        )
    }
}

