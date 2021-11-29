package com.grupoOnce.vista;

import android.app.Activity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.grupoOnce.vista.databinding.ActivityHomeInfoBinding;

public class HomeInfo extends AppCompatActivity {

    private ActivityHomeInfoBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeInfoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();
        redirectionToLogin(this);
        redirectionRegistro(this);


    }


    public void redirectionToLogin(Activity activity) {

        binding.txtRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newView = new Intent(activity, Registro.class);
                startActivity(newView);
            }
        });

    }

    public void redirectionRegistro(Activity activity) {

        binding.txtIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newView = new Intent(activity, login.class);
                startActivity(newView);
            }
        });
    }

}



