package com.grupoOnce.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import Interfaces.FormularioInterfaz;

public class Registro extends AppCompatActivity implements FormularioInterfaz.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
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
}