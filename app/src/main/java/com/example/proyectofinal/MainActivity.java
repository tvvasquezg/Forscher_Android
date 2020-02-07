package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectofinal.logica.*;
import com.example.proyectofinal.estructura_de_datos.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    Persona usuario;
    ArbolAVL<Persona> usuarios;
    EditText idusuario,contraseña;

    public MainActivity(){
    }

    public MainActivity(ArbolAVL usuarios){
        this.usuario=null;
        this.usuarios=usuarios;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

 ///;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idusuario = (EditText) findViewById(R.id.txt_insesion);
        contraseña = (EditText) findViewById(R.id.txt_contraseña);

        try{
            Bundle objetoEnviado=getIntent().getExtras();
            usuarios=(ArbolAVL) objetoEnviado.getSerializable("usuarios");
        }catch (Exception e){

        }


        try{
            usuariosImport();

        }catch (IOException i){

        }

    }

    //Botón Registrarse
    public void btnregistrar(View view){
    Intent registrarse=new Intent(MainActivity.this,Registrarse.class);
        startActivity(registrarse);
    }

    //Importar Estructura de datos
    public void usuariosImport()throws IOException {
        try{
            BufferedReader usu=new BufferedReader(new InputStreamReader(this.getResources().openRawResource(R.raw.diez)));


            usuarios = new ArbolAVL<Persona>();
            String sCadena;
            //long inicio=System.nanoTime();
            while ((sCadena = usu.readLine())!=null /*|| (sCadena = usu2.readLine())!=null*/) {
                int cont2 = 0;
                String[] tempo = new String[9];
                StringTokenizer st = new StringTokenizer(sCadena,";");
                while (st.hasMoreTokens()){
                    tempo[cont2] = st.nextToken("\t");
                    //System.out.println(tempo[cont2]+"------------------------"+cont2);
                    cont2++;
                }
                //nombre_usuario	genero	nombre	apellido	universidad	carrera	contraseña
                //System.out.println(tempo[0]+tempo[1]+tempo[2]+ tempo[3]+tempo[4]+tempo[5]+ tempo[6]);

                if(cont2==7){
                    Persona estudiante = new Estudiante(tempo[0],tempo[1], tempo[2], tempo[3],tempo[4], tempo[5], tempo[6],"tempo[7]");
                    usuarios.insertarNormal(estudiante, estudiante.idUsuario);
                }else if(cont2==9){
                    Persona profesor = new Profesor(tempo[0],tempo[1],tempo[2],tempo[3],tempo[4],tempo[5],tempo[6],tempo[7],tempo[8]);
                    usuarios.insertarNormal(profesor,profesor.idUsuario);
                }else if(cont2==8){
                   Persona estudiante = new Estudiante(tempo[0],tempo[1], tempo[2], tempo[3],tempo[4], tempo[5], tempo[6],tempo[7]);
                    usuarios.insertarNormal(estudiante, estudiante.idUsuario);
                }

                //System.out.println(estudiante.toString())

            }
            usu.close();

            try{
                BufferedReader usu2=new BufferedReader(new InputStreamReader(openFileInput("nuevosUsuarios.txt")));
                while ((sCadena = usu2.readLine())!=null) {
                    int cont3 = 0;
                    String[] tempo = new String[9];
                    StringTokenizer st = new StringTokenizer(sCadena,";");
                    while (st.hasMoreTokens()){
                        tempo[cont3] = st.nextToken("\t");
                        //System.out.println(tempo[cont2]+"------------------------"+cont2);
                        cont3++;
                    }
                    //nombre_usuario	genero	nombre	apellido	universidad	carrera	contraseña
                    //System.out.println(tempo[0]+tempo[1]+tempo[2]+ tempo[3]+tempo[4]+tempo[5]+ tempo[6]);

                    if(cont3==7){
                        Persona estudiante = new Estudiante(tempo[0],tempo[1], tempo[2], tempo[3],tempo[4], tempo[5], tempo[6],"tempo[7]");
                        usuarios.insertarNormal(estudiante, estudiante.idUsuario);

                    }else if(cont3==9){
                        Persona profesor = new Profesor(tempo[0],tempo[1],tempo[2],tempo[3],tempo[4],tempo[5],tempo[6],tempo[7],tempo[8]);

                    }else if(cont3==8){
                        Persona estudiante = new Estudiante(tempo[0],tempo[1], tempo[2], tempo[3],tempo[4], tempo[5], tempo[6],tempo[7]);
                        usuarios.insertarNormal(estudiante, estudiante.idUsuario);

                    }

                    //System.out.println(estudiante.toString())

                }
                usu2.close();
            }catch(Exception e){

            }


        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Botón Iniciar Sesión
    public void inicBtn(View view){
        String nmbusu= idusuario.getText().toString();
        String pass= contraseña.getText().toString();

        if(usuarios==null){
            Toast.makeText(this,"No hay usuarios registrados, sé el primero",Toast.LENGTH_LONG).show();
        }else{
            NodoAVL<Persona> user=null;
            user=this.usuarios.buscar(nmbusu,this.usuarios.raiz);
            //Existencia del usuario
            if(user!=null){
                this.usuario=user.dato;
            }else{
                Toast.makeText(this,"El usuario "+nmbusu+" no existe, digita uno nuevo",Toast.LENGTH_LONG).show();
            }
            //Coincidencia con la contraseña
            if(user != null && this.usuario.getContrasena().equals(pass)){
                Toast.makeText(this,"Bienvenido usuario",Toast.LENGTH_LONG).show();
                Intent home=new Intent(MainActivity.this,Home_Activity.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("usuario",this.usuario);
                    home.putExtras(bundle);
                home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);
                finish();

            }else{
                Toast.makeText(this,"Contraseña Incorrecta",Toast.LENGTH_LONG).show();
            }
        }


    }



}
