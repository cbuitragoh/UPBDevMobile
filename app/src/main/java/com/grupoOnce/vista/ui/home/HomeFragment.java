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

import Interfaces.InicioInterface;
import Models.PublicacionesDTO;
import Models.PublicacionesMostrar;

public class HomeFragment extends Fragment implements InicioInterface.View{

    Menu menu;
    private FragmentHomeBinding binding;


    RecyclerView recyclerAlimentos;
    ArrayList<PublicacionesMostrar> listaAlimentos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_home,container,false);
        listaAlimentos = new ArrayList<>();
        recyclerAlimentos= (RecyclerView) vista.findViewById(R.id.Recyclerid2);
        recyclerAlimentos.setLayoutManager(new GridLayoutManager(getContext(),2));

        llenarLista();
        AdapterAlimentos adapter = new AdapterAlimentos(listaAlimentos);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent vistaDetalle = new Intent(getContext(), Detalle.class);

                vistaDetalle.putExtra("nombre",listaAlimentos.get(recyclerAlimentos.getChildAdapterPosition(v)).getNombre());
                vistaDetalle.putExtra("fechaVencimiento",listaAlimentos.get(recyclerAlimentos.getChildAdapterPosition(v)).getFecha());
                vistaDetalle.putExtra("foto",listaAlimentos.get(recyclerAlimentos.getChildAdapterPosition(v)).getFoto());

                startActivity(vistaDetalle);

            }
        });

        recyclerAlimentos.setAdapter(adapter);
        return vista;

    }

    private void llenarLista() {

        listaAlimentos.add(new PublicacionesMostrar("churrasco", "31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("pechuga", "31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("pollo", "31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("pasteles", "31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("milanesa", "31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("quesadillas", "31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("papa", "31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("salsa", "31/12/2021", R.drawable.logo));
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void mostrarLista(List<PublicacionesDTO> publicacionesDTOList) {

    }

    @Override
    public void respuestaSalirApp() {

    }
}