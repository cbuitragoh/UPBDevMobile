package com.grupoOnce.vista.ui.notifications;

import android.Manifest;
import android.app.Activity;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.grupoOnce.vista.NavigationMenu;
import com.grupoOnce.vista.R;
import com.grupoOnce.vista.databinding.FragmentNotificationsBinding;
import com.grupoOnce.vista.ui.home.HomeFragment;

import java.util.Objects;

import Controllers.ControladorNotificacion;
import Interfaces.NotificacionInterfaz;
import Models.FormularioPublicacionDTO;
import Models.ConexionSQLHelper;

public class NotificationsFragment extends Fragment implements NotificacionInterfaz.View{


    private FragmentNotificationsBinding binding;

    private ImageView selectedImage;
    private Button cameraBt;
    public static final int CAMERA_PERMISSION_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;

    private static ConexionSQLHelper dbHelper;

    private final ControladorNotificacion Controlador = new ControladorNotificacion(this);


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        dbHelper = new ConexionSQLHelper(this.getContext());
        tomarFoto();
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
            FormularioPublicacionDTO form = getFormValues();

            boolean isValid = Controlador.validarCampos(form);
            if (isValid) {
                boolean productCreated  = Controlador.guardarPublicacion(form, dbHelper);
                /*Crear redireccion a la vista de productos*/
                if (productCreated) {
                    Intent intent = new Intent(getContext(), NavigationMenu.class);
                    startActivity(intent);
                    requireActivity().finish();
                }
            }
        });
    }

    private FormularioPublicacionDTO getFormValues() {
        FormularioPublicacionDTO newForm = FormularioPublicacionDTO.getInstance();

        newForm.setComentario(binding.editDescripcionProducto.getText().toString());
        newForm.setFechaVencimiento(binding.editFechaVencimiento.getText().toString());
        newForm.setTipoAlimento(binding.editTipoProducto.getText().toString());
        newForm.setNombreAlimento(binding.editNombreProducto.getText().toString());
        newForm.setFotoAlimento(binding.editFotoAlimentoFormulario.getDrawable());

        return newForm;
    }


    /* ----------------- Servicio de la cámara -------------*/

    public void tomarFoto() {

        selectedImage = binding.editFotoAlimentoFormulario;
        cameraBt = binding.btnFotoProducto;

        cameraBt.setOnClickListener(v -> {
            //Toast.makeText(activity,"Se activará la cámara", Toast.LENGTH_SHORT).show();
            askCameraPermission();

        });
    }
    private void askCameraPermission() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
        }else {
            openCamera();
        }

    }

    @Override
    public  void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera();
            } else {
                Toast.makeText(getContext(), "Se requiere acceder a la cámara para continuar", Toast.LENGTH_LONG).show();
            }
        }
    }


    private void openCamera(){
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera, CAMERA_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST_CODE) {
            assert data != null;
            Bitmap image = (Bitmap) data.getExtras().get("data");
            selectedImage.setImageBitmap(image);
        }
    }

}