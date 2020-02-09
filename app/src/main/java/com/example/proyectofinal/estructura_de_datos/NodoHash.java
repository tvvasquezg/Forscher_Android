package com.example.proyectofinal.estructura_de_datos;
import com.example.proyectofinal.logica.Persona;

import java.io.Serializable;
public class NodoHash<T> implements Serializable{
    public Persona dato;
    boolean estado;
    String comparador;
    public NodoHash(Persona dato, String comparador){
        this.dato= dato;
        this.estado= true;
        this.comparador = comparador;
    }


    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean c) {
        this.estado = c;
    }

    public Persona getDato() {
        return dato;
    }

    public String getComparador() {
        return comparador;
    }

    public void setComparador(String comparador) {
        this.comparador = comparador;
    }


}

