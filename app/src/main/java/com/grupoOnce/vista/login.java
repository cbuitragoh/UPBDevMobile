package com.grupoOnce.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.grupoOnce.vista.databinding.ActivityLoginBinding;

import Interfaces.LoginIterface;
import Controllers.ControladorLogin;

public class login extends AppCompatActivity implements LoginIterface.View {

    private ActivityLoginBinding binding;
    private final ControladorLogin Controlador = new ControladorLogin(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();
        Controlador.validarLogin(binding.editUsuario.getText().toString(),"usuario");
        Controlador.validarLogin(binding.editPassword.getText().toString(),"password");
        Registrar();

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
        if(valida){
            Toast.makeText(this, "Usuario Autorizado", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Usuario/Contrasena Incorrecto", Toast.LENGTH_SHORT).show();
        }

    }

    public void Registrar(){
        binding.btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Controlador.usuarioPermitido(binding.editUsuario.getText().toString(),binding.editPassword.getText().toString());
            }
        });
    }
}

