package com.grupoOnce.vista.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.grupoOnce.vista.AdapterAlimentos;
import com.grupoOnce.vista.Detalle;
import com.grupoOnce.vista.R;
import com.grupoOnce.vista.databinding.FragmentHomeBinding;

import java.util.List;

import Controllers.ControladorInicio;
import Interfaces.InicioInterface;
import Models.ConexionSQLHelper;
import Models.PublicacionesDTO;

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
        recyclerAlimentos= vista.findViewById(R.id.Recyclerid2);
        recyclerAlimentos.setLayoutManager(new GridLayoutManager(getContext(),2));
        controlador.recuperarLista(dbHelper);

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
            vistaDetalle.putExtra("comentario",listaAlimentos.get(recyclerAlimentos.getChildAdapterPosition(v)).getComentario());
            vistaDetalle.putExtra("tipo",listaAlimentos.get(recyclerAlimentos.getChildAdapterPosition(v)).getTipo());

            startActivity(vistaDetalle);

        });


        recyclerAlimentos.setAdapter(adapter);
    }

    @Override
    public void respuestaSalirApp() {

    }
}