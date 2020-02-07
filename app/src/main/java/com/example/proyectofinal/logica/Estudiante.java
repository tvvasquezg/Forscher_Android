package com.example.proyectofinal.logica;

import com.example.proyectofinal.logica.Persona;

import java.io.Serializable;

public class Estudiante extends Persona implements Serializable {

    private String universidad;
    private String programaA;

    @Override
    public String toString() {
        return "Persona{" + "idUsuario=" + super.getIdUsuario() + ", nombre=" + super.getNombre() + ", apellido=" + super.getApellido() + ", genero=" + super.getGenero() + ", contrasena=" + super.getContrasena() +"Estudiante{" + "universidad=" + universidad + ", programaA=" + programaA + '}';
    }

    public Estudiante(String idUsuario, String genero, String nombre, String apellido,String universidad, String programaA,String contrasena,String descripcion) {
        super(idUsuario, nombre, apellido, genero, contrasena,descripcion);
        this.universidad = universidad;
        this.programaA = programaA;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getProgramaA() {
        return programaA;
    }

    public void setProgramaA(String programaA) {
        this.programaA = programaA;
    }












}