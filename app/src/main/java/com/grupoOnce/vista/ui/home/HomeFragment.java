package com.grupoOnce.vista.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.grupoOnce.vista.AdapterAlimentos;
import com.grupoOnce.vista.Detalle;
import com.grupoOnce.vista.R;
import com.grupoOnce.vista.databinding.ActivityDetalleBinding;
import com.grupoOnce.vista.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

import Controllers.ControladorInicio;
import Interfaces.InicioInterface;
import Models.ConexionSQLHelper;
import Models.PublicacionesDTO;
import Models.PublicacionesMostrar;

public class HomeFragment extends Fragment implements InicioInterface.View{


    private FragmentHomeBinding binding;
    public final ControladorInicio controlador = new ControladorInicio(this);
    private static ConexionSQLHelper dbHelper;


    RecyclerView recyclerAlimentos;
    List<PublicacionesDTO> listaAlimentos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_home,container,false);
        dbHelper = new ConexionSQLHelper(this.getContext());
        controlador.recuperarLista(dbHelper);
        recyclerAlimentos= vista.findViewById(R.id.Recyclerid2);
        recyclerAlimentos.setLayoutManager(new GridLayoutManager(getContext(),2));

        llenarLista();
        AdapterAlimentos adapter = new AdapterAlimentos(listaAlimentos);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent vistaDetalle = new Intent(getContext(), Detalle.class);

                vistaDetalle.putExtra("nombre",listaAlimentos.get(recyclerAlimentos.getChildAdapterPosition(v)).getNombre());
                vistaDetalle.putExtra("fechaVencimiento",listaAlimentos.get(recyclerAlimentos.getChildAdapterPosition(v)).getFecha());
                //vistaDetalle.putExtra("estado",listaAlimentos.get(recyclerAlimentos.getChildAdapterPosition(v)).getEstado());

                startActivity(vistaDetalle);

            }
        });

        recyclerAlimentos.setAdapter(adapter);
        return vista;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void mostrarLista(List<PublicacionesDTO> publicacionesDTOList) {
        this.listaAlimentos = publicacionesDTOList;

        AdapterAlimentos adapter = new AdapterAlimentos(this.listaAlimentos);

        adapter.setOnClickListener(v -> {

            Intent vistaDetalle = new Intent(getContext(), Detalle.class);

            vistaDetalle.putExtra("nombre",listaAlimentos.get(recyclerAlimentos.getChildAdapterPosition(v)).getNombre());
            vistaDetalle.putExtra("fechaVencimiento",listaAlimentos.get(recyclerAlimentos.getChildAdapterPosition(v)).getFecha());
            vistaDetalle.putExtra("foto",listaAlimentos.get(recyclerAlimentos.getChildAdapterPosition(v)).getImage());

            startActivity(vistaDetalle);

        });


        recyclerAlimentos.setAdapter(adapter);
    }

    @Override
    public void respuestaSalirApp() {

    }
}