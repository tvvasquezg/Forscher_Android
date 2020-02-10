package com.example.proyectofinal.estructura_de_datos;
import com.example.proyectofinal.logica.Persona;

import java.io.Serializable;
public class NodoHash<T> implements Serializable{
    public Persona dato;
    boolean estado; //0 = Vacío, 1 = Eliminado, 2 = Ocupado
    int position;
    String key;
    NodoHash next;

    public NodoHash(Persona dato){
        this.dato= dato;
        this.estado= true;
        this.key = dato.idUsuario;
    }
    void agregarDelante(Persona o, NodoHash c){
        NodoHash nuevo = new NodoHash(o);
        c.next = nuevo;
    }

    public String getKey() {
        return key;
    }


    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean c) {
        this.estado = c;
    }

    public int getPosition() {
        return position;
    }

    public Persona getDato() {
        return dato;
    }

    public NodoHash getNext() {
        return next;
    }


}


