package com.grupoOnce.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.grupoOnce.vista.databinding.ActivityPublicacionesBinding;


public class Publicaciones extends AppCompatActivity {

    private ActivityPublicacionesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPublicacionesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();


    }
}