package com.grupoOnce.vista;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.grupoOnce.vista.databinding.ActivityRegistroBinding;

import java.util.ArrayList;

import Controllers.ControladorFormulario;
import Interfaces.FormularioInterfaz;
import Models.ConexionSQLHelper;
import Models.FormularioDTO;


public class Registro extends AppCompatActivity implements FormularioInterfaz.View, AdapterView.OnItemSelectedListener{

    private ActivityRegistroBinding binding;
    private final ControladorFormulario Controlador = new ControladorFormulario(this);
    private ConexionSQLHelper dbHelper;

    private Spinner seleccionarSexo;
    private final ArrayList<String> listaSexo = new ArrayList<String>();

    private ImageView selectedImage;
    private Button cameraBt;
    public static final int CAMERA_PERMISSION_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        dbHelper = new ConexionSQLHelper(getApplicationContext());
        setContentView(view);
        getSupportActionBar().hide();
        registroXML();
        agregarValores();
        darClic();
        tomarFoto(this);
    }

    /* ------------------- Métodos de la Interfaz --------------*/

    @Override
    public void validarResultadoFormulario(String editText, String mensaje) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, mensaje, duration);
        toast.show();
    }

    @Override
    public void respuestaGuardadoUsuario(Boolean respuesta) {

        if(respuesta){
            Toast.makeText(this, "Usuario Guardado", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Usuario no Guardado. ", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void tomarFoto(Activity activity) {

        cameraBt = binding.btnTomarFoto;

        cameraBt.setOnClickListener(v -> {
            Toast.makeText(activity,"Se activará la cámara", Toast.LENGTH_SHORT).show();
            askCameraPermission();
            openCamera();
        });
    }

    /* ------------- Botón de registro ------------*/

    public void Registrar() {
        binding.btnRegistrar.setOnClickListener(v -> {
            //Aqui deberia ir el formulario de la vista
            FormularioDTO form = getFormValues();

            boolean isValid = Controlador.validarFormulario(form);

            if (isValid) {
                boolean userCreated  = Controlador.usuarioGuardarUsuario(form, dbHelper);
            }
        });
    }

    private FormularioDTO getFormValues() {
        return new FormularioDTO(
                binding.editNombres.getText().toString(),
                binding.editApellidos.getText().toString(),
                binding.editDireccion.getText().toString(),
                binding.editCorreo.getText().toString(),
                binding.editCiudad.getText().toString(),
                binding.editCelular.getText().toString(),
                binding.editUsuario.getText().toString(),
                binding.editTextTextPassword.getText().toString(),
                binding.spSexo.getSelectedItem().toString());

    }

    /* -------------- Implementación del Spinner --------------*/

    private void registroXML()
    {
        seleccionarSexo = binding.spSexo;
    }

    private void agregarValores() {
        listaSexo.add("Sexo");
        listaSexo.add("Hombre");
        listaSexo.add("Mujer");
        listaSexo.add("Prefiero no decir");
    }

    private void darClic() {
        seleccionarSexo.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaSexo){
            @Override
            public boolean isEnabled(int position){
                if (position == 0){
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0) {
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seleccionarSexo.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /* ----------------- Servicio de la cámara -------------*/

    private void askCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
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
                Toast.makeText(this, "Se requiere acceder a la cámara para continuar", Toast.LENGTH_LONG).show();
            }
        }
    }


    private void openCamera(){
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //startActivityForResult(camera, CAMERA_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        selectedImage = binding.editFoto;
        if (requestCode == CAMERA_REQUEST_CODE) {
            assert data != null;
            Bitmap image = (Bitmap) data.getExtras().get("data");
            selectedImage.setImageBitmap(image);
        }
    }

}