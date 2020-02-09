package com.example.proyectofinal.estructura_de_datos;
import com.example.proyectofinal.logica.Persona;

import java.io.Serializable;
import java.util.*;

public class HashTable<T> implements Serializable {
    public int size, indice, ocupados;
    public float porcentaje, factor;
    public NodoHash[] vector;
    public Comparator comparador;



    public HashTable() {
        this.comparador = null;
        this.indice = 0;
        this.ocupados= 0;
        this.factor=73.0f;
        this.size = 997;
        this.vector = new NodoHash[size];
        this.porcentaje = (this.ocupados*100)/ this.size;

    }

    /*public int F1(int x){ return x%size; }
    public int F2 (int x) { return 1+ (x%(size-1));}
    public int DobleHashing (int f, String id){
        int x = key(id);
        return F1(x)+(f*F2(x)%size);
    }*/
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

    /*public int reduccion(String id){
        int tmp = 0;
        while(id.length()>9){
            String ax ="";
            for (int i = 0;i<id.length()/2;i++){
                ax += id.charAt(i);
            }
            if ( id.length()<9){
                tmp = reduccion(ax);
                ax ="";
            } else {
                tmp =Integer.parseInt(ax);
                ax ="";
            }
            for(int i=id.length()/2;i< id.length();i++){
                ax+=id.charAt(i);
            }
            if ( id.length()<9){
                tmp = reduccion(ax);
                ax ="";
            } else {
                tmp =Integer.parseInt(ax);
                ax ="";
            }
            id ="";
        }
        return tmp;
    }*/


    public void Insert( Persona Dato){
        String dato = Dato.idUsuario;
        boolean insertado = false;
        if (porcentaje<=73.0f){
            for(int i = 0; i< size; i++){
                int posicion = DobleHashing(dato);
                if ( vector[posicion]== null || vector[posicion].estado==0 || vector[posicion].estado==1){
                    System.out.println();
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
                        System.out.println("Colision en la posicion: "+ posicion);
                    }
                }
            }
            if (insertado == true){
                System.out.println("El dato se inserto correctamente: "+ dato);
            } else {
                System.out.println("El dato no se pudo insertar : "+ dato);
            }
        }else{
            rehashing();
            Insert(Dato);
        }
    }
    public void rehashing(){
        NodoHash[] tmp = vector;
        int tamano = size;
        indice += 1;
        size= size();
        vector = new NodoHash[size];
        ocupados=0;
        porcentaje = (ocupados*100)/size;
        for (int i = 0 ; i <tamano ;i++){
            Insert(tmp[i].dato);
        }
        System.out.println("Rehashing realizado");
    }



    public NodoHash Sacar (String dato){
        boolean find = false;
        NodoHash tmp = null;
        int pos = 0;
        for (int i = 0;i<size;i++){
            int posicion = DobleHashing(dato);

            if (posicion>=size){
                posicion-= size;
                pos = posicion;
                System.out.println("1");
            }
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
