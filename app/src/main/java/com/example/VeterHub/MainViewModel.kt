package com.example.VeterHub

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.FirebaseFirestore

class MainViewModel : ViewModel()
{
    private var firebaseStore = FirebaseFirestore.getInstance();
    private var email: String =" ";
    private lateinit var userCliente: Cliente;
    private lateinit var userVeterinario: Veterinario;
    var out: String =  "no paso nada";

    fun setUser(id: String)
    {
        this.firebaseStore.collection("/Usuario/Rol/Cliente/").document(id).get().
        addOnSuccessListener {
            if(it.exists())
            {
                var id = it.get("id" as String);
                var correo = it.get("correo" as String)
                var nombres = it.get("nombres" as String)
                var apellidos = it.get("apellidos" as String)
                var contacto = it.get("contacto" as String)
                var nombreUsuario = it.get("nombreUsuario" as String);
            }
        }
    }
    fun setEmail(email: String)
    {
        this.email=email;
    }

    fun getEmail(): String
    {
        return this.email;
    }
}