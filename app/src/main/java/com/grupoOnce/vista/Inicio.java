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
        recyclerAlimentos.setLayoutManager(new GridLayoutManager(this, 2));

        llenarAlimentos();

        AdapterAlimentos adapter = new AdapterAlimentos(listaAlimentos);
        recyclerAlimentos.setAdapter(adapter);

    }

    private void llenarAlimentos() {
        listaAlimentos.add(new PublicacionesMostrar("churrasco", "fecha vencimiento: 31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("pechuga", "fecha vencimiento: 31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("pollo", "fecha vencimiento: 31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("pasteles", "fecha vencimiento: 31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("milanesa", "fecha vencimiento: 31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("quesadillas", "fecha vencimiento: 31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("papa", "fecha vencimiento: 31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("salsa", "fecha vencimiento: 31/12/2021", R.drawable.logo));
    }
}