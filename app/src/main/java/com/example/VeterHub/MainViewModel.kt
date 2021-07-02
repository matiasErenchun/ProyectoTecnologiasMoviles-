package com.example.VeterHub

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.math.log

class MainViewModel : ViewModel()
{

    private var email: String =" ";
    lateinit var userCliente: Cliente;
    private lateinit var userVeterinario: Veterinario;
    var out: String =  "no paso nada";

    fun setCliente(user: Cliente)
    {
        this.userCliente = user;
    }
    fun setVeterinario(user : Veterinario)
    {
        this.userVeterinario = user;
    }
    fun setEmail(email: String)
    {
        this.email=email;
    }

    fun getEmail(): String
    {
        return this.email;
    }

    fun getVeterinario(): Veterinario
    {
        return this.userVeterinario;
    }
    fun getCliente(): Cliente
    {
        return this.userCliente;
    }
}