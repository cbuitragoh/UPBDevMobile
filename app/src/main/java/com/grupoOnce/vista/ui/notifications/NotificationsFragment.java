package com.grupoOnce.vista.ui.notifications;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.SharedPreferencesKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.grupoOnce.vista.R;
import com.grupoOnce.vista.databinding.ActivityNavigationMenuBinding;
import com.grupoOnce.vista.databinding.FragmentNotificationsBinding;
import com.grupoOnce.vista.login;
import com.grupoOnce.vista.ui.home.HomeFragment;

import Controllers.ControladorNotificacion;
import Interfaces.NotificacionInterfaz;
import Models.FormularioDTO;
import Models.FormularioPublicacionDTO;
import Models.PublicacionesDTO;

public class NotificationsFragment extends Fragment implements NotificacionInterfaz.View{

    private final ControladorNotificacion Controlador = new ControladorNotificacion(this);
    private FragmentNotificationsBinding binding;

    private ImageView selectedImage;
    private Button cameraBt;
    public static final int CAMERA_PERMISSION_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //notificationsViewModel =
          //      new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Registrar();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /*------------------Métodos de la interfaz------------------------*/


    @Override
    public void respuestaValidacion(String indicador, String mensaje) {
        if(indicador.equals("nombreAlimento")){

            binding.editNombreProducto.setFocusable(true);
            binding.editNombreProducto.setFocusableInTouchMode(true);
            binding.editNombreProducto.requestFocus();
            binding.editNombreProducto.setError(mensaje);


        }else if(indicador.equals("fecha")){

            binding.editFechaVencimiento.setFocusable(true);
            binding.editFechaVencimiento.setFocusableInTouchMode(true);
            binding.editFechaVencimiento.requestFocus();
            binding.editFechaVencimiento.setError(mensaje);

        }else if(indicador.equals("tipo")){

            binding.editTipoProducto.setFocusable(true);
            binding.editTipoProducto.setFocusableInTouchMode(true);
            binding.editTipoProducto.requestFocus();
            binding.editTipoProducto.setError(mensaje);

        }else if(indicador.equals("comentario")){

            binding.editDescripcionProducto.setFocusable(true);
            binding.editDescripcionProducto.setFocusableInTouchMode(true);
            binding.editDescripcionProducto.requestFocus();
            binding.editDescripcionProducto.setError(mensaje);
        }

    }

    @Override
    public void respuestaGuardado(Boolean respuesta) {
        String message = respuesta ? "Alimento Guardado" : "Alimento no guardado";
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
    /*----------------------Botón Guardar Producto--------------------*/

    public void Registrar() {
        binding.btnGuardarProducto.setOnClickListener(v -> {

            final FormularioPublicacionDTO instance = FormularioPublicacionDTO.getInstance();
            instance.setNombreAlimento(binding.editNombreProducto.getText().toString());
            instance.setFechaVencimiento(binding.editFechaVencimiento.getText().toString());
            instance.setTipoAlimento(binding.editTipoProducto.getText().toString());
            instance.setComentario(binding.editDescripcionProducto.getText().toString());

            boolean isValid = Controlador.validarCampos(instance);
            if (isValid) {
                Controlador.guardarPublicacion(instance);

            }
            binding.editNombreProducto.setText("");
            binding.editFechaVencimiento.setText("");
            binding.editTipoProducto.setText("");
            binding.editDescripcionProducto.setText("");
        });
    }





    /* ----------------- Servicio de la cámara -------------*/


}