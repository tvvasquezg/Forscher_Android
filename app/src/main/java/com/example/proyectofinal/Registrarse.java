package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyectofinal.logica.*;
import com.example.proyectofinal.estructura_de_datos.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.SQLOutput;


public class Registrarse extends AppCompatActivity{
    EditText nombres,apellidos,usuario,contraseña,descripcion;
    Spinner rol,ceducativo,programa,genero;

    ArrayAdapter<String> arrrol,arrceducativo,arrprograma,arrmateria,arrfacultad,arrgenero;
    String[] oprol={"Estudiante","Docente"};
    String[] opceducativo={"Ceducativo1","Ceducativo2"};
    String[] opprograma={"programa1","programa2"};
    String[] opmateria={"materia1","materia2","materia3"};
    String[] opfacultad={"facultad1","facultad2","facultad3"};
    String[] opgenero={"Masculino","Femenino","Otro"};




    public Registrarse(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        nombres = (EditText) findViewById(R.id.txtnombres);
        apellidos = (EditText) findViewById(R.id.txtapellidos);
        usuario = (EditText) findViewById(R.id.txtidusuario);
        contraseña = (EditText) findViewById(R.id.txtcontraseña2);
        descripcion = (EditText) findViewById(R.id.txtdescripcion);

        rol = (Spinner) findViewById(R.id.spnrol);
        ceducativo = (Spinner) findViewById(R.id.spnceducativo);
        programa = (Spinner) findViewById(R.id.spnprograma);
        genero = (Spinner) findViewById(R.id.spngenero);

        arrrol=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,oprol);
        arrceducativo=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opceducativo);
        arrprograma=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opprograma);
        arrgenero=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opgenero);
        arrmateria=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opmateria);
        arrfacultad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opfacultad);

        rol.setAdapter(arrrol);
        genero.setAdapter(arrgenero);

        rol.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                          @Override
                                          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                              if(position==0){
                                                  ceducativo.setAdapter(arrceducativo);
                                                  programa.setAdapter(arrprograma);
                                              }else if(position==1){
                                                  ceducativo.setAdapter(arrmateria);
                                                  programa.setAdapter(arrfacultad);
                                              }
                                          }

                                          @Override
                                          public void onNothingSelected(AdapterView<?> parent) {

                                          }
                                      }

        );

    }

    //Botón Registrarse
    public void btnRegistrarse(View view){


        if(nombres.getText().toString().isEmpty() || apellidos.getText().toString().isEmpty() || usuario.getText().toString().isEmpty() || contraseña.getText().toString().isEmpty() || descripcion.getText().toString().isEmpty()){
            Toast.makeText(this,"Faltan campos obligatorios por digitar",Toast.LENGTH_LONG).show();
        }else{
            if(rol.getSelectedItem().toString().equals("Estudiante")){
                try{
                    BufferedWriter usu=new BufferedWriter(new OutputStreamWriter(openFileOutput("nuevosUsuarios.txt",Activity.MODE_PRIVATE)));
                    usu.write(usuario.getText().toString()+"\t"+genero.getSelectedItem().toString()+"\t"+nombres.getText().toString()+"\t"+apellidos.getText().toString()+"\t"+ceducativo.getSelectedItem().toString()+"\t"+programa.getSelectedItem().toString()+"\t"+contraseña.getText().toString()+"\t"+descripcion.getText().toString());
                    usu.newLine();
                    usu.flush();
                    Toast.makeText(this,"Estudiante creado",Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    System.out.println();
                }




                Intent inicio=new Intent(Registrarse.this,MainActivity.class);
                inicio.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(inicio);
                finish();


            }else if(rol.getSelectedItem().toString().equals("Docente")){
                try{
                    BufferedWriter usu=new BufferedWriter(new OutputStreamWriter(openFileOutput("nuevosUsuarios.txt",Activity.MODE_PRIVATE)));
                    usu.write(usuario.getText().toString()+"\t"+nombres.getText().toString()+"\t"+apellidos.getText().toString()+"\t"+genero.getSelectedItem().toString()+"\t"+contraseña.getText().toString()+"\t"+ceducativo.getSelectedItem().toString()+"\t"+programa.getSelectedItem().toString()+"\t"+ceducativo.getSelectedItem().toString()+"\t"+descripcion.getText().toString());
                    usu.newLine();
                    usu.flush();
                    Toast.makeText(this,"Docente creado",Toast.LENGTH_SHORT).show();
                }catch (Exception ignored){
                    System.out.println(5);

                }



                Intent inicio=new Intent(Registrarse.this,MainActivity.class);
                inicio.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(inicio);
                finish();
            }
        }
    }

}
