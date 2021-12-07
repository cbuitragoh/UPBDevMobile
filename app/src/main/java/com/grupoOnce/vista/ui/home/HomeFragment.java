package com.grupoOnce.vista.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.grupoOnce.vista.AdapterAlimentos;
import com.grupoOnce.vista.R;
import com.grupoOnce.vista.databinding.FragmentHomeBinding;

import java.util.ArrayList;

import Models.PublicacionesMostrar;

public class HomeFragment extends Fragment {

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
        recyclerAlimentos.setAdapter(adapter);
        return vista;

    }

    private void llenarLista() {

        listaAlimentos.add(new PublicacionesMostrar("churrasco", "fecha vencimiento: 31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("pechuga", "fecha vencimiento: 31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("pollo", "fecha vencimiento: 31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("pasteles", "fecha vencimiento: 31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("milanesa", "fecha vencimiento: 31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("quesadillas", "fecha vencimiento: 31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("papa", "fecha vencimiento: 31/12/2021", R.drawable.logo));
        listaAlimentos.add(new PublicacionesMostrar("salsa", "fecha vencimiento: 31/12/2021", R.drawable.logo));
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}