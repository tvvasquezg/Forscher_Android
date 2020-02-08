package com.example.proyectofinal.estructura_de_datos;
import java.io.Serializable;
public class HashSearch<T> implements Serializable {
    public NodoHash<T> inicio;
    public int size;

    public HashSearch(int size){
        this.inicio=null;
        this.size = size;
    }
    public  int[] Table (int size){
        int[] t = new int[size];
        for (int i = 0; i<size;i++){
            t[i]=i;
        }
        return t;
    }

    public int FunctionHash(String key, HashSearch h){
        int hashVal =0;
        for (int i= 0; i < key.length();i++){
            hashVal = 45* hashVal+ key.charAt(i);
        }
        hashVal %= h.size;
        if(hashVal<0){
            hashVal += h.size;
        }
        return hashVal;
    }

}