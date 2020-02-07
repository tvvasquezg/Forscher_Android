package com.example.proyectofinal.logica;

import android.media.Image;

import com.example.proyectofinal.R;

import java.io.Serializable;

import static com.example.proyectofinal.R.mipmap.fotoperfil;

public class Persona implements Serializable {
    public String idUsuario;
    private String nombre;
    private String apellido;
    private String genero;
    private String contrasena;
    private String descripcion;
    private int fotoperfil;
    @Override
    public String toString() {
        return "Persona{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero + ", contrasena=" + contrasena + '}';
    }

    public Persona(String idUsuario, String nombre, String apellido, String genero, String contrasena,String descripcion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.contrasena = contrasena;
        this.descripcion = descripcion;
        this.fotoperfil = R.mipmap.fotoperfil;
    }

    public int getFotoperfil() {
        return fotoperfil;
    }

    public void setFotoperfil(int fotoperfil) {
        this.fotoperfil = fotoperfil;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    public String getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }



}