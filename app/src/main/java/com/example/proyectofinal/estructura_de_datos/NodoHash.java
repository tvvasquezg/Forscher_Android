package com.example.proyectofinal.estructura_de_datos;
import com.example.proyectofinal.logica.Persona;

import java.io.Serializable;
public class NodoHash<T> implements Serializable{
    public Persona dato;
    int estado; //0 = Vacío, 1 = Eliminado, 2 = Ocupado
    int position;
    String key;
    NodoHash next;

    public NodoHash(Persona dato){
        this.dato= dato;
        this.estado= 0;
        this.key = dato.idUsuario;
    }

    public String getKey() {
        return key;
    }


    public int getEstado() {
        return estado;
    }

    public void setEstado(int c) {
        this.estado = c;
    }

    public int getPosition() {
        return position;
    }

    public Persona getDato() {
        return dato;
    }

}

