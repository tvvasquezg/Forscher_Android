package com.example.proyectofinal.estructura_de_datos;
import java.io.Serializable;
public class HashTable<T> implements Serializable {
    public int size, indice, ocupados;
    public float porcentaje, factor;
    public int[] sizes;
    public NodoHash[] vector;
    public HashTable (){
        this.sizes = new int[] {13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,101, 103, 107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,271,277,281,283,293,307,311,313,317,331,337,347,349,353,359,997};
        this.indice = 0;
        this.ocupados= 0;
        this.factor=73.0f;
        this.size = this.sizes[indice];
        this.vector = new NodoHash[size];
        this.porcentaje = (this.ocupados*100)/ this.size;
    }
    public int F1(int x){ return x%size; }
    public int F2 (int x) { return 1+ (x%(size-1));}
    public int DobleHashing (int f, String id){
        int x = key(id);
        return F1(x)+(f*F2(x)%size);
    }
    public int key (String id){
        String codigo ="";
        for(int i= 0;i<id.length();i++){
            codigo += id.codePointAt(i);
        }
        if ( id.length()<9){
            return reduccion(codigo);
        } else {
            return Integer.parseInt(codigo);
        }
    }
    public int reduccion(String id){
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
    }
    public void Insert( String dato){
        boolean insertado = false;
        if (porcentaje<=73.0f){
            for(int i = 0; i< size; i++){
                int posicion = DobleHashing(i,dato);
                if (posicion>size){
                    posicion -=size;
                } if ( vector[posicion]== null || vector[posicion].estado==true){
                    vector[posicion]=new NodoHash(dato);
                    ocupados+=1;
                    porcentaje=(this.ocupados*100)/ this.size;
                    insertado= true;
                    break;
                } else {
                    if(vector[posicion].dato.equals(dato)){
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
            Insert(dato);
        }
    }
    public void rehashing(){
        NodoHash[] tmp = vector;
        int tamano = size;
        if ( indice <sizes.length){
            indice += 1;
            if (indice==sizes.length-1){
                System.out.println("WARNING: Se llego al maximo tamano del arreglo");
            }
        }
        size=sizes[indice];
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
            int posicion = DobleHashing(i,dato);
            if (posicion>=size){
                posicion-= size;
                pos = posicion;
            }
            if(vector[posicion]!=null){
                if(vector[posicion].dato.equals(dato)){
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
