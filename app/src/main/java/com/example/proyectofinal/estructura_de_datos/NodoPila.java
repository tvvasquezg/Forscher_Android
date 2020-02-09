package com.example.proyectofinal.estructura_de_datos;

public class NodoPila<T> {

    private T key;
    private NodoPila<T> next;

    public NodoPila() {
    }

    public NodoPila(T key) {
        this.key = key;
        this.next = null;
    }

    public NodoPila(T key, NodoPila<T> next) {
        this.key = key;
        this.next = next;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public NodoPila<T> getNext() {
        return next;
    }

    public void setNext(NodoPila<T> next) {
        this.next = next;
    }

}
