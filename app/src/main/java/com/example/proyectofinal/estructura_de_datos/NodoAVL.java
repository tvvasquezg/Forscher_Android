package com.example.proyectofinal.estructura_de_datos;

import java.io.Serializable;

public class NodoAVL<T> implements Serializable {
    public T dato;
    int fe;
    String comparador;
    NodoAVL hijoizquierdo,hijoderecho;
    public NodoAVL(T dato,String comparador){
        this.dato = dato;
        this.fe = 0;
        this.comparador = comparador;
        this.hijoderecho = null;
        this.hijoderecho = null;
    }

    public String getComparador() {
        return comparador;
    }

    public void setComparador(String comparador) {
        this.comparador = comparador;
    }

    public T getDato() {
        return dato;
    }

    public int getFe() {
        return fe;
    }

    public NodoAVL getHijoizquierdo() {
        return hijoizquierdo;
    }

    public NodoAVL getHijoderecho() {
        return hijoderecho;
    }
}