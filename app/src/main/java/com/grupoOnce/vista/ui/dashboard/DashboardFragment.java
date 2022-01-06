package com.grupoOnce.vista.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
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
import com.grupoOnce.vista.databinding.FragmentDashboardBinding;

import java.util.List;

import Controllers.ControladorInicio;
import Controllers.ControladorPerfil;
import Interfaces.InicioInterface;
import Interfaces.PerfilInterfaz;
import Models.ConexionSQLHelper;
import Models.PublicacionesDTO;

public class DashboardFragment extends Fragment implements PerfilInterfaz.View {

    private FragmentDashboardBinding binding;
    public ControladorPerfil controlador = new ControladorPerfil(this);
    private static ConexionSQLHelper dbHelper;


    RecyclerView recyclerAlimPerfil;
    List<PublicacionesDTO> listaAlimentos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View vista = inflater.inflate(R.layout.fragment_dashboard,container,false);
        dbHelper = new ConexionSQLHelper(this.getContext());
        recyclerAlimPerfil= vista.findViewById(R.id.recyclerPerfil);
        recyclerAlimPerfil.setLayoutManager(new GridLayoutManager(getContext(),2));
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
        recyclerAlimPerfil.setAdapter(adapter);

    }

    @Override
    public void mostrarUsuario() {

    }

    @Override
    public void respuestaSalirApp() {

    }
}