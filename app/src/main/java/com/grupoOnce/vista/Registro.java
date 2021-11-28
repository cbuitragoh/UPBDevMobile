package com.grupoOnce.vista;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.grupoOnce.vista.databinding.ActivityLoginBinding;

import java.util.ArrayList;

import Controllers.ControladorFormulario;
import Interfaces.FormularioInterfaz;
import Models.ConexionSQLHelper;
import Models.FormularioDTO;

public class Registro extends AppCompatActivity implements FormularioInterfaz.View, AdapterView.OnItemSelectedListener{

    private ActivityLoginBinding binding;
    private final ControladorFormulario Controlador = new ControladorFormulario(this);
    private final ConexionSQLHelper dbHelper = new ConexionSQLHelper(getApplicationContext());

    private Spinner seleccionarSexo;
    private ArrayList<String> listaSexo = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //setContentView(R.layout.activity_registro);
        getSupportActionBar().hide();

        registroXML();
        agregarValores();
        darClic();
    }

    @Override
    public void validarResultadoFormulario(String editText, String mensaje) {

    }

    @Override
    public void respuestaGuardadoUsuario(Boolean respuesta) {

        if(respuesta){
            Toast.makeText(this, "Usuario Guardado", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Usuario no Guardado. ", Toast.LENGTH_SHORT).show();
        }

    }

    public void Registrar() {
        binding.btnIngresar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Aqui deberia ir el formulario de la vista
                FormularioDTO form = new FormularioDTO();
                boolean isValid = Controlador.validarFormulario(form);

                if (isValid) {
                    boolean userCreated  = Controlador.usuarioGuardarUsuario(form, dbHelper);
                }
            }
        });
    }

    private void registroXML()
    {
        seleccionarSexo = findViewById(R.id.spinnerSexo);
    }

    private void agregarValores() {
        listaSexo.add("Hombre");
        listaSexo.add("Mujer");
    }

    private void darClic() {
        seleccionarSexo.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaSexo);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seleccionarSexo.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}