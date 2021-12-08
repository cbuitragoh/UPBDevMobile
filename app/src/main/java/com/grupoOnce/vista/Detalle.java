package com.grupoOnce.vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.grupoOnce.vista.databinding.ActivityDetalleBinding;
import com.grupoOnce.vista.databinding.FragmentHomeBinding;
import com.grupoOnce.vista.ui.home.HomeFragment;


public class Detalle extends AppCompatActivity {

    private ActivityDetalleBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalleBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();

        binding.editNombreAlimento.setText(getIntent().getExtras().getString("nombre"));
        binding.textBoxFv.setText(getIntent().getExtras().getString("fechaVencimiento"));

    }


    /*----------------Botón lo Quiero--------------------------*/



}