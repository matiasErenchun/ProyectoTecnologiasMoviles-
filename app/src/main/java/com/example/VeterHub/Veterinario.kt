package com.example.VeterHub

class Veterinario
{
    var id: String;
    var correo: String;
    var nombres: String;
    var apellidos:String;
    var contacto: String;
    var nombreUsuario: String;
    var gradoMaximo: String;
    var universidad: String;
    var codigoTitulo: String;
    // en el arreglo se guardan los id de los documentos pertenecientes a las mascotas
    var pasientes: ArrayList<String>;

    constructor(
        id: String,
        correo: String,
        nombres: String,
        apellidos: String,
        contacto: String,
        nombreUsuario: String,
        gradoMaximo: String,
        universidad: String,
        codigoTitulo: String
    ) {
        this.id = id
        this.correo = correo
        this.nombres = nombres
        this.apellidos = apellidos
        this.contacto = contacto
        this.nombreUsuario = nombreUsuario
        this.gradoMaximo = gradoMaximo
        this.universidad = universidad
        this.codigoTitulo = codigoTitulo
        this.pasientes = arrayListOf<String>()
    }
}