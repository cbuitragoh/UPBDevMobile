package com.grupoOnce.vista;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.grupoOnce.vista.databinding.ActivityDetalleBinding;


public class Detalle extends AppCompatActivity {

    private ActivityDetalleBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalleBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();


    }
}