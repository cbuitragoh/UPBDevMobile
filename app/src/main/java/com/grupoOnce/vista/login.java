package com.grupoOnce.vista;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.grupoOnce.vista.databinding.ActivityLoginBinding;

import java.util.Objects;

import Interfaces.LoginIterface;
import Controllers.ControladorLogin;
import Models.ConexionSQLHelper;

public class login extends AppCompatActivity implements LoginIterface.View {

    private ActivityLoginBinding binding;
    private final ControladorLogin Controlador = new ControladorLogin(this);
    private static ConexionSQLHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        dbHelper = new ConexionSQLHelper(this.getApplicationContext());
        setContentView(view);
        Objects.requireNonNull(getSupportActionBar()).hide();

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

            boolean userSuccess;
            boolean passwordSuccess;
            userSuccess = Controlador.validarLogin(binding.editUsuario.getText().toString(), "usuario");
            passwordSuccess = Controlador.validarLogin(binding.editPassword.getText().toString(),"password");

            if(userSuccess & passwordSuccess) {
                boolean passUser;
                passUser = Controlador.usuarioPermitido(binding.editUsuario.getText().toString(), binding.editPassword.getText().toString(), dbHelper);

                if (passUser){
                    SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("data",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("currentIdUser", Controlador.getCurrentIdUser());
                    editor.apply();

                    Intent newView = new Intent(this, NavigationMenu.class);
                    startActivity(newView);
                    finish();
                }

            }

        });






    }

}

