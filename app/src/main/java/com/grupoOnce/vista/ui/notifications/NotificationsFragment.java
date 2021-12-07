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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.grupoOnce.vista.R;
import com.grupoOnce.vista.databinding.ActivityNavigationMenuBinding;
import com.grupoOnce.vista.databinding.FragmentNotificationsBinding;

import Interfaces.NotificacionInterfaz;

public class NotificationsFragment extends Fragment implements NotificacionInterfaz.View{

    //private NotificationsViewModel notificationsViewModel;
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

    }

    @Override
    public void respuestaGuardado(Boolean respuesta) {

    }
    /*----------------------Botón Guardar Producto--------------------*/




    /* ----------------- Servicio de la cámara -------------*/


}