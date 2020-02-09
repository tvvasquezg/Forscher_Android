package com.example.proyectofinal.estructura_de_datos;

public class Pila<T> {
    private NodoPila<T> top;
    private int tam;

    public int size() {
        return tam;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T key) {
        NodoPila<T> nodo = new NodoPila<>(key, this.top);
        this.top = nodo;
        tam++;
    }

    public NodoPila<T> pop() {
        NodoPila<T> temp = new NodoPila<>();

        if (isEmpty()) {
            System.out.println("Pila Vacía1...");
            return null;
        }

        temp = this.top;
        this.top = this.top.getNext();
        tam--;
        return temp;
    }

    public NodoPila<T> top() {
        if (isEmpty()) {
            return null;
        }
        return this.top;
    }
}
