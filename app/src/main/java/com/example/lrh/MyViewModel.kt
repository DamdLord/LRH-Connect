package com.example.lrh

import androidx.lifecycle.ViewModel

enum class Screens(title:String){
    Onboarding("Onboarding"),
    Register("Register"),
    Login("Login"),
    RetrieveAccount("RetrieveAccount"),
    Home("Home"),
    Data("Data"),

    Airtime("Airtime")
}

class MainViewModel(
) : ViewModel() {

}
