package com.grupoOnce.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.grupoOnce.vista.databinding.ActivityMainBinding;

import Interfaces.LoginIterface;

public class login extends AppCompatActivity implements LoginIterface.View {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }


    @Override
    public void validarResultado(String editText, String mensaje) {
        if(editText.equals("usuario")){
            binding.include.editUsuario.setFocusable(true);
            binding.include.editUsuario.setFocusableInTouchMode(true);
            binding.include.editUsuario.requestFocus();
            binding.include.editUsuario.setError(mensaje);

        }else if(editText.equals("password")){
            binding.include.editPassword.setFocusable(true);
            binding.include.editPassword.setFocusableInTouchMode(true);
            binding.include.editPassword.requestFocus();
            binding.include.editPassword.setError(mensaje);

        }
    }

    @Override
    public void usuarioAutorizado(Boolean valida) {
        if(valida){
            Toast.makeText(this, "Usuario Autorizado", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Usuario/Contrasena Incorrecto", Toast.LENGTH_SHORT).show();
        }

    }
}

