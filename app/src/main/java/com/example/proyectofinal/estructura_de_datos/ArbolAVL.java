package com.example.proyectofinal.estructura_de_datos;
import java.io.Serializable;
import java.util.Comparator;
public class ArbolAVL<T> implements Serializable {
    public NodoAVL<T> raiz;
    public Comparator comparador;
    public ArbolAVL(){
        this.raiz=null;
    }

    public ArbolAVL(Comparator comparador){
        this.raiz=null;
        this.comparador =comparador;
    }
    //Buscar
    public NodoAVL<T> buscar(String dato,NodoAVL<T> raiz){
        if(raiz==null){
            return null;
        }
        int v=dato.compareTo(raiz.comparador);
        if(v<0){
            if(raiz.hijoizquierdo!=null){
                return buscar(dato,raiz.hijoizquierdo);
            }else{
                return null;
            }
        }else if(v>0){
            if(raiz.hijoderecho!=null){
                return buscar(dato,raiz.hijoderecho);
            }else{
                return null;
            }

        }else{
            return raiz;
        }

    }
    //Factor de Equilibrio
    public int obtenerFE(NodoAVL<T> f){
        if(f==null){
            return -1;
        }else{
            return f.getFe();
        }
    }
    //Rotacion simple izquierda
    public NodoAVL<T> rotacionIzquierda(NodoAVL<T> c){
        NodoAVL<T> temp = c.hijoizquierdo;
        c.hijoizquierdo=temp.hijoderecho;
        temp.hijoderecho=c;
        c.fe=Math.max(obtenerFE(c.hijoizquierdo), obtenerFE(c.hijoderecho))+1;
        temp.fe=Math.max(obtenerFE(temp.hijoizquierdo), obtenerFE(temp.hijoderecho))+1;
        return temp;
    }
    //rotacion simple derecha
    public NodoAVL<T> rotacionDerecha(NodoAVL<T> c){
        NodoAVL<T> temp = c.hijoderecho;
        c.hijoderecho=temp.hijoizquierdo;
        temp.hijoizquierdo=c;
        c.fe=Math.max(obtenerFE(c.hijoizquierdo), obtenerFE(c.hijoderecho))+1;
        temp.fe=Math.max(obtenerFE(temp.hijoizquierdo), obtenerFE(temp.hijoderecho))+1;
        return temp;
    }
    //rotacion doble izquierda
    public NodoAVL<T> rotacionDobleIzquierda(NodoAVL<T> c){
        NodoAVL<T> temp;
        c.hijoizquierdo=rotacionDerecha(c.hijoizquierdo);
        temp=rotacionIzquierda(c);
        return temp;
    }
    //rotacion doble derecha
    public NodoAVL<T> rotacionDobleDerecha(NodoAVL<T> c){
        NodoAVL<T> temp;
        c.hijoderecho=rotacionIzquierda(c.hijoderecho);
        temp=rotacionDerecha(c);
        return temp;
    }
    //metodo insertar
    public NodoAVL<T> insertar(NodoAVL<T> nuevo,NodoAVL<T> subarbol){
        NodoAVL<T> nuevoPadre =subarbol;
        int v=nuevo.comparador.compareTo(subarbol.comparador);
        if(v<0){
            if(subarbol.hijoizquierdo==null){
                subarbol.hijoizquierdo=nuevo;
            }else{
                subarbol.hijoizquierdo=insertar(nuevo,subarbol.hijoizquierdo);
                if((obtenerFE(subarbol.hijoizquierdo)-obtenerFE(subarbol.hijoderecho))==2){
                    int v2=nuevo.comparador.compareTo(subarbol.hijoizquierdo.comparador);
                    if(v2<0){
                        nuevoPadre = rotacionIzquierda(subarbol);
                    }else{
                        nuevoPadre = rotacionDobleIzquierda(subarbol);
                    }
                }
            }
        }else if(v>0){
            if(subarbol.hijoderecho==null){
                subarbol.hijoderecho=nuevo;
            }else{
                subarbol.hijoderecho=insertar(nuevo,subarbol.hijoderecho);
                if((obtenerFE(subarbol.hijoderecho)-obtenerFE(subarbol.hijoizquierdo))==2){
                    int v3=nuevo.comparador.compareTo(subarbol.hijoderecho.comparador);
                    if(v3>0){
                        nuevoPadre = rotacionDerecha(subarbol);
                    }else{
                        nuevoPadre = rotacionDobleDerecha(subarbol);
                    }
                }
            }
        }else{
            System.out.println("Usuario Duplicado");
        }
        //actualizar altura
        if((subarbol.hijoizquierdo==null)&&(subarbol.hijoderecho!=null)){
            subarbol.fe=subarbol.hijoderecho.fe+1;
        }else if((subarbol.hijoderecho==null)&&(subarbol.hijoizquierdo!=null)){
            subarbol.fe=subarbol.hijoizquierdo.fe+1;
        }else{
            subarbol.fe=Math.max(obtenerFE(subarbol.hijoizquierdo), obtenerFE(subarbol.hijoderecho))+1;
        }
        return nuevoPadre;
    }

    public void insertarNormal(T dato,String comparador){
        NodoAVL<T> nuevo=new NodoAVL(dato,comparador);
        if(raiz==null){
            raiz=nuevo;
        }else{
            raiz=insertar(nuevo,raiz);
        }
    }
    //recorridos
    public void inOrder(NodoAVL<T> r){
        if(r!=null){
            inOrder(r.hijoizquierdo);
            System.out.println(r.comparador+" ");
            inOrder(r.hijoderecho);
        }
    }
    public void preOrder(NodoAVL<T> r){
        if(r!=null){
            System.out.println(r.comparador+" ");
            preOrder(r.hijoizquierdo);
            preOrder(r.hijoderecho);
        }
    }
    public void posOrder(NodoAVL<T> r){
        if(r!=null){
            posOrder(r.hijoizquierdo);
            posOrder(r.hijoderecho);
            System.out.println(r.comparador+" ");
        }
    }

}
