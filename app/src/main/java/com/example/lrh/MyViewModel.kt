package com.example.lrh

import androidx.lifecycle.ViewModel

enum class Screens(title:String){
    Onboarding("Onboarding"),
    Register("Register"),
    Login("Login"),
    RetrieveAccount("RetrieveAccount"),
    Home("Home"),
    Data("Data"),
    Airtime("Airtime"),
    Bill("Bill"),
    BulkSMS("Bulk SMS"),
    CableTV("CableTV")

}

class MainViewModel(
) : ViewModel() {

}
