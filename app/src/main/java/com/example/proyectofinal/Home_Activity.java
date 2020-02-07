package com.example.proyectofinal;

import android.os.Bundle;

import com.example.proyectofinal.logica.Estudiante;
import com.example.proyectofinal.logica.Persona;
import com.example.proyectofinal.logica.Profesor;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class Home_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Persona usuario;
    TextView name_user,user_rol;
    ImageView perfil_user;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        usuario=null;
        Bundle objetoenviado=getIntent().getExtras();
        if(objetoenviado!=null){
            if(objetoenviado.getSerializable("usuario").getClass()== Estudiante.class){
                usuario = (Estudiante) objetoenviado.getSerializable("usuario");
            }else if(objetoenviado.getSerializable("usuario").getClass()== Profesor.class){
                usuario = (Profesor) objetoenviado.getSerializable("usuario");
            }
        }
        NavigationView navigation = (NavigationView) findViewById(R.id.nav_view);
        View nview = navigation.getHeaderView(0);
        name_user=(TextView) nview.findViewById(R.id.nombre_usuario);
        user_rol = (TextView) nview.findViewById(R.id.textView_rol);
        perfil_user = (ImageView) nview.findViewById(R.id.imageView_perfil);

        name_user.setText(usuario.getNombre()+" "+usuario.getApellido());
        user_rol.setText(usuario.getClass().getSimpleName());
        perfil_user.setImageResource(usuario.getFotoperfil());
        navigation.setNavigationItemSelectedListener(this);






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        return false;
    }

    @Override
    public void onBackPressed() {
    }

}
