package com.grupoOnce.vista;

import android.content.Intent;
import android.os.AsyncTask;
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
                    Intent newView = new Intent(this, NavigationMenu.class);
                    startActivity(newView);
                    finish();
                }

            }

        });






    }

    /*class task extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute(){
            binding.progressBar1.setVisibility(View.VISIBLE);
            binding.btnIngresar.setEnabled(false);
        }
        @Override
        protected String doInBackground(String... strings){
            try{
                Thread.sleep(3000);

            }catch(InterruptedException e){
                e.printStackTrace();
            }
            return strings[0];
        }
        @Override
        protected void onPostExecute(String s){
            binding.progressBar1.setVisibility(View.INVISIBLE);
            binding.btnIngresar.setEnabled(true);
            Intent intent = new Intent(login.this, NavigationMenu.class);
            startActivity(intent);
        }

    }*/
}

