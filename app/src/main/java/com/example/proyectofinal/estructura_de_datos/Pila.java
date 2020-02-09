package com.example.proyectofinal.estructura_de_datos;

public class Pila<T> {
    private NodoPila<T> top;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T key) {
        NodoPila<T> nodo = new NodoPila<>(key, this.top);
        this.top = nodo;
        size++;
    }

    public NodoPila<T> pop() {
        NodoPila<T> temp = new NodoPila<>();

        if (isEmpty()) {
            System.out.println("Pila Vacía1...");
            return null;
        }

        temp = this.top;
        this.top = this.top.getNext();
        size--;
        return temp;
    }

    public NodoPila<T> top() {
        if (isEmpty()) {
            return null;
        }
        return this.top;
    }
}
