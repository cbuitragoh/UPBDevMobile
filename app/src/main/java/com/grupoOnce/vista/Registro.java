package com.grupoOnce.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.grupoOnce.vista.databinding.ActivityLoginBinding;

import Controllers.ControladorFormulario;
import Controllers.ControladorLogin;
import Interfaces.FormularioInterfaz;
import Models.ConexionSQLHelper;
import Models.FormularioDTO;

public class Registro extends AppCompatActivity implements FormularioInterfaz.View{

    private ActivityLoginBinding binding;
    private final ControladorFormulario Controlador = new ControladorFormulario(this);
    private final ConexionSQLHelper dbHelper = new ConexionSQLHelper(getApplicationContext());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();
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
}