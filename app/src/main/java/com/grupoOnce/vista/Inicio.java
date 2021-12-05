package com.grupoOnce.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.grupoOnce.vista.databinding.ActivityInicioBinding;

import java.util.ArrayList;

import Models.PublicacionesMostrar;


public class Inicio extends AppCompatActivity {

    ArrayList<PublicacionesMostrar> listaAlimentos;
    RecyclerView recyclerAlimentos;

    private ActivityInicioBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInicioBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();

        listaAlimentos= new ArrayList<>();
        recyclerAlimentos = (RecyclerView) findViewById(R.id.Recyclerid);
        recyclerAlimentos.setLayoutManager(new LinearLayoutManager(this));

        llenarAlimentos();

        AdapterAlimentos adapter = new AdapterAlimentos(listaAlimentos);
        recyclerAlimentos.setAdapter(adapter);

    }

    private void llenarAlimentos() {
        listaAlimentos.add(new PublicacionesMostrar("churrasco", "argentino", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("pechuga", "a la plancha", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("pollo", "apanado", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("pasteles", "de carne", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("milanesa", "de cerdo", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("quesadillas", "mozzarella", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("papa", "francesa", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("salsa", "Aliolí", R.drawable.logo));
    }
}