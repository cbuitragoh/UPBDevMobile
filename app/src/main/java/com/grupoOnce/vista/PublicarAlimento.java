package com.grupoOnce.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;


import com.grupoOnce.vista.databinding.ActivityPublicarAlimentoBinding;

public class PublicarAlimento extends AppCompatActivity {

    private ActivityPublicarAlimentoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPublicarAlimentoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();

        
    }
}