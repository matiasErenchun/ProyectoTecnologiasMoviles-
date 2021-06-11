package com.example.VeterHub

class Cliente
{
    lateinit var id: String;
    lateinit var correo: String;
    lateinit var nombres: String;
    lateinit var apellidos: String;
    lateinit var contacto: String;
    lateinit var nombreUsuario: String;

    constructor(
        id: String,
        correo: String,
        nombres: String,
        apellidos: String,
        contacto: String,
        nombreUsuario: String
    ) {
        this.id = id
        this.correo = correo
        this.nombres = nombres
        this.apellidos = apellidos
        this.contacto = contacto
        this.nombreUsuario = nombreUsuario
    }
}