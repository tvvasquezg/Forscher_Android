package com.example.proyectofinal.logica;

public class Publicacion {
    private String nombre;
    private String autor;

    public Publicacion(String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


}
