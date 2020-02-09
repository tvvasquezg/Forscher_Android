package com.example.proyectofinal.estructura_de_datos;
import java.io.Serializable;
public class NodoHash<T> implements Serializable{
    public T dato;
    boolean estado;
    String  Key;
    int tam;
    public NodoHash(T dato){
        this.dato= dato;
        this.estado= true;
    }

    public  NodoHash(int t){
        this.tam = t;
        this.estado = true;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean c) {
        this.estado = c;
    }

    public T getDato() {
        return dato;
    }

    public int getTam() { return tam; }

    public String getKey() { return Key; }

}

