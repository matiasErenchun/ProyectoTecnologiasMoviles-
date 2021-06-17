package com.example.VeterHub

class Cliente
{
    var id: String;
    var correo: String;
    var nombres: String;
    var apellidos: String;
    var contacto: String;
    var nombreUsuario: String;
    var mascotas: ArrayList<String>;

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
        this.mascotas = arrayListOf();
    }
}