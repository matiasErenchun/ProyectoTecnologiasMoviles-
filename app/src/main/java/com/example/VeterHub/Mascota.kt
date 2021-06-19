package com.example.VeterHub

class Mascota
{
    private var nombre: String;

    constructor(nombre: String) {
        this.nombre = nombre
    }

    fun getNombre(): String {
        return  this.nombre;
    }
}