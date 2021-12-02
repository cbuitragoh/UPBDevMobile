package com.grupoOnce.vista;

//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.grupoOnce.vista.databinding.ActivityLoginBinding;

import Interfaces.LoginIterface;
import Controllers.ControladorLogin;
import Models.ConexionSQLHelper;

public class login extends AppCompatActivity implements LoginIterface.View {

    private ActivityLoginBinding binding;
    private final ControladorLogin Controlador = new ControladorLogin(this);
    private ConexionSQLHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        dbHelper = new ConexionSQLHelper(getApplicationContext());
        setContentView(view);
        getSupportActionBar().hide();
        Loguear();

    }


    @Override
    public void validarResultado(String editText, String mensaje) {
        if(editText.equals("usuario")){

            binding.editUsuario.setFocusable(true);
            binding.editUsuario.setFocusableInTouchMode(true);
            binding.editUsuario.requestFocus();
            binding.editUsuario.setError(mensaje);


        }else if(editText.equals("password")){

            binding.editPassword.setFocusable(true);
            binding.editPassword.setFocusableInTouchMode(true);
            binding.editPassword.requestFocus();
            binding.editPassword.setError(mensaje);


        }
    }

    @Override
    public void usuarioAutorizado(Boolean valida) {

        String message = valida ? "Usuario Autorizado" : "Usuario/Contrasena Incorrecto";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();


    }

    public void Loguear(){
        binding.btnIngresar.setOnClickListener(v -> {
            binding.editUsuario.setError(null);
            binding.editUsuario.clearFocus();
            binding.editPassword.setError(null);
            binding.editPassword.clearFocus();

            Boolean p;
            Boolean q;
            p = Controlador.validarLogin(binding.editUsuario.getText().toString(), "usuario");
            q = Controlador.validarLogin(binding.editPassword.getText().toString(),"password");

            if(p & q) {
                Controlador.usuarioPermitido(binding.editUsuario.getText().toString(), binding.editPassword.getText().toString(), dbHelper);

                Intent newView = new Intent(this, Inicio.class);
                startActivity(newView);
                finish();
            }
        });
    }
}

