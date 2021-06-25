package com.example.VeterHub

class Mascota
{
    var id: String;
    var idDueño: String;
    var nombreDueño: String;
    var tipo: String;
    var nombre: String;
    var raza: String;
    var color: String;
    var peso: Number;

    constructor(id: String, idDueño: String, nombreDueño: String, tipo: String, nombre: String, raza: String, color: String, peso: Number)
    {
        this.id = id
        this.idDueño = idDueño
        this.nombreDueño = nombreDueño
        this.tipo = tipo
        this.nombre = nombre
        this.raza = raza
        this.color = color
        this.peso = peso
    }

}