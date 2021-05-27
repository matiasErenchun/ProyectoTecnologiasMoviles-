package com.example.VeterHub

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel()
{
    private var email: String =" ";

    fun setEmail(email: String)
    {
        this.email=email;
    }

    fun getEmail(): String
    {
        return this.email;
    }
}