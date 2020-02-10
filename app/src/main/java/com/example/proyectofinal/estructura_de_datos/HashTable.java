package com.example.proyectofinal.estructura_de_datos;
import com.example.proyectofinal.logica.Persona;

import java.io.Serializable;
import java.util.*;

public class HashTable<T> implements Serializable {
    public int size, indice, ocupados;
    public float porcentaje, factor;
    public NodoHash[] vector;

    public HashTable() {
        this.indice = 0;
        this.ocupados= 0;
        this.factor=73.0f;
        this.size = 28;
        this.porcentaje = (this.ocupados*100)/ this.size;
        this.vector = new NodoHash[size];

    }


    public int size(){
        return (int) Math.pow(this.size,2)+this.size+41;
    }
    public int DobleHashing (String id){
        int n = id.length();
        int m = 27;
        int z = (int) Math.pow(n, m);
        int c =((n + 1) % m);
        return n+(z*(c-1)%m);
    }
    public void Insert( Persona Dato){
        String dato = Dato.idUsuario;
        boolean insertado = false;
        if (porcentaje<=73.0f){
            for(int i = 0; i< size; i++){
                int posicion = DobleHashing(dato);
                if ( vector[posicion]== null ){
                    vector[posicion]=new NodoHash(Dato);
                    ocupados+=1;
                    porcentaje=(this.ocupados*100)/ this.size;
                    insertado= true;
                    break;
                } else {
                    if(vector[posicion].dato.idUsuario.equals(dato)){
                        System.out.println("El dato a insertar ya existe en la tabla: "+ dato);
                        break;
                    }else {
                        vector[posicion].agregarDelante(Dato,vector[posicion]);
                        insertado= true;
                        break;
                    }
                }
            }
            if (insertado == true){
                System.out.println("El dato se inserto correctamente: "+ dato);
            } else {
                System.out.println("El dato no se pudo insertar : "+ dato);
            }
        }else{
            Insert(Dato);
        }
    }

    /**
     *
     * @param Dato
     */
    public void Inserta( Persona Dato){
        String dato = Dato.idUsuario;
        boolean insertado = false;
        if (porcentaje<=73.0f){
            for(int i = 0; i< size; i++){
                int posicion = DobleHashing(dato);
                if ( vector[posicion].estado==true ){
                    vector[posicion]=new NodoHash(Dato);
                    ocupados+=1;
                    porcentaje=(this.ocupados*100)/ this.size;
                    insertado= true;
                    break;

                } else {
                    vector[posicion].agregarDelante(Dato,vector[posicion]);
                } }
        }
        if (insertado == true){
            System.out.println("El dato se inserto correctamente: "+ dato);
        } else {
            System.out.println("El dato no se pudo insertar : "+ dato);
        }
    }






    public NodoHash Sacar (String dato){
        boolean find = false;
        NodoHash tmp = null;
        for (int i = 0;i<size;i++){
            int posicion = DobleHashing(dato);
            if(vector[posicion]!=null){
                if(vector[posicion].dato.idUsuario.equals(dato)){

                    tmp = vector[posicion];
                    find = true;
                    break;
                }
            }
        }
        if(find){
            return tmp;
        }else{
            System.out.println("No se encontro el dato :"+dato+" en la tabla.");
            return null;
        }
    }





}

