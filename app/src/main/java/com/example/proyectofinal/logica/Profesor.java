package com.example.proyectofinal.logica;

import com.example.proyectofinal.logica.Persona;

import java.io.Serializable;

public class Profesor extends Persona implements Serializable {
    private String materia;
    private String facultad;
    private String centroEducativo;




    public Profesor(String idUsuario, String nombre, String apellido,String genero, String contrasena,String materia, String facultad, String centroEducativo,String descripcion) {
        super(idUsuario, nombre, apellido,genero, contrasena,descripcion);
        this.materia = materia;
        this.facultad = facultad;
        this.centroEducativo = centroEducativo;
    }

    public String getCentroEducativo() {
        return centroEducativo;
    }

    public void setCentroEducativo(String centroEducativo) {
        this.centroEducativo = centroEducativo;
    }



    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

}
