package com.example.lrh

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lrh.data.DataStoreHelper
import com.example.lrh.data.Dialog
import com.example.lrh.screens.Airtime
import com.example.lrh.screens.Data
import com.example.lrh.screens.Home
import com.example.lrh.screens.Login
import com.example.lrh.screens.Onboarding
import com.example.lrh.screens.Register
import com.example.lrh.screens.RetrieveAccount

@Composable
fun MainApp(
    modifier: Modifier = Modifier
){
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Screens.valueOf(
        backStackEntry?.destination?.route ?: Screens.Onboarding.name
    )
    var isFirstLaunch by remember { mutableStateOf(true) }
    var startDestination by remember {
        mutableStateOf<String?>(null)
    }
    val  context = LocalContext.current
    var showWelcomeDialog by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        isFirstLaunch = DataStoreHelper.isFirstLaunch(context)

        if (isFirstLaunch) {
            startDestination = Screens.Onboarding.name
            DataStoreHelper.setFirstLaunch(context, false)
        } else {
            startDestination = Screens.Login.name
        }
    }

    startDestination?.let { destination ->
        NavHost(
            navController = navController,
            startDestination = destination
        ) {
            composable(Screens.Onboarding.name) {
                Onboarding(
                    onLoginClick = {
                        navController.navigate(Screens.Login.name)
                    },
                    omRegisterClick = {
                        navController.navigate(Screens.Register.name)
                    }
                )
            }
            composable(Screens.Login.name) {
                Login(
                    onLoginClick = {
                        showWelcomeDialog = true
                        navController.navigate(Screens.Home.name)
                    },
                    onRetrieveClick = {navController.navigate(Screens.RetrieveAccount.name)},
                    onRegisterClick = {
                        navController.navigate(Screens.Register.name)
                    }
                )
            }
            composable(Screens.Register.name) {
                Register(
                    onRegisterClick = {},
                    onLoginClick = {
                        navController.navigate(Screens.Login.name)
                    }
                )
            }
            composable(route = Screens.RetrieveAccount.name) {
                RetrieveAccount(
                    onVerifyClick = {},
                    onBackClick = {
                        navController.navigate(Screens.Login.name)
                    }
                )
            }
            composable(route = Screens.Home.name) {
                Home(
                    navController = navController
                )
            }
            composable(route = Screens.Data.name) {
                Data(
                    onBackClick = {
                        navController.navigate(Screens.Home.name)
                    }
                )
            }
            composable(route = Screens.Airtime.name) {
                Airtime(
                    onBackClick = { navController.navigate(Screens.Home.name)}
                )
            }

        }
    }
    if (showWelcomeDialog){
        Dialog(
            onDismissRequest = { showWelcomeDialog = false }
        )
    }

}