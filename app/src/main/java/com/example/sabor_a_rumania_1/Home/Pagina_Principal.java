package com.example.sabor_a_rumania_1.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.example.sabor_a_rumania_1.Login;
import com.example.sabor_a_rumania_1.R;
import com.example.sabor_a_rumania_1.catalogo.Catalogo_Recetas;
import com.example.sabor_a_rumania_1.mapa.MapaLocales;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Pagina_Principal extends AppCompatActivity {

    //atributos
    Toolbar toolbarHome;
    FirebaseAuth auth;
    FirebaseUser user;

    Button btnMapa, btnCatalogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);

        //firebase atributos inicializados
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();

        //atributos conectados con los id
        toolbarHome=findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbarHome);

        btnMapa=findViewById(R.id.btnLocales);
        btnCatalogo=findViewById(R.id.btCatalogo);

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), MapaLocales.class);
                startActivity(intent);
                finish();
            }
        });

        btnCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Catalogo_Recetas.class);
                startActivity(intent);
                finish();
            }
        });




        if(user==null){
            Intent intent= new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }
    }

    //metodos para conectar el icono del menu con el layout
    // de la página principal


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.logout){
            FirebaseAuth.getInstance().signOut();
            Intent intent= new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }

        return true;
    }
}