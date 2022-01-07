package com.grupoOnce.vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.grupoOnce.vista.databinding.ActivityHomeInfoBinding;
import com.grupoOnce.vista.databinding.ActivityInvitarAmigosBinding;

import Controllers.ControladorInvitarAmigos;
import Interfaces.InvitarAmigosInterfaz;
import Models.ConexionSQLHelper;
import Models.PublicacionesDTO;
import Models.UsuarioDto;
import db.Product;

public class InvitarAmigos extends AppCompatActivity implements InvitarAmigosInterfaz.View {
    Menu menu;
    private ActivityInvitarAmigosBinding binding;
    private String url;
    public ControladorInvitarAmigos controlador = new ControladorInvitarAmigos(this);
    private static ConexionSQLHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInvitarAmigosBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();
        dbHelper = new ConexionSQLHelper(this);

        url="https://wa.me/?text=¡Hola!, Estoy en Food for all app, te invito a" +
                " colaborar para reducir el desperdicio de alimentos";

        controlador.recuperarUsuario(dbHelper);
        controlador.recuperarProducto(dbHelper);
        invitarAmigos();
    }


    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_superior, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if (id == R.id.menu_invitar_amigos){

            Intent newView = new Intent(this, InvitarAmigos.class);
            startActivity(newView);
            finish();
            //Toast.makeText(this, "Ha elegido la opción Invitar Amigos", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menu_salir){
            AlertDialog.Builder builder = new AlertDialog.Builder(InvitarAmigos.this);
            builder.setMessage("¿Realemente desea Salir?");
            builder.setCancelable(true);

            builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setPositiveButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            Toast.makeText(this, "Ha elegido la opción Salir", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void mostrarNombreUsuario(UsuarioDto usuario) {
        binding.textViewUsuarioInvita.setText(usuario.getNombre());
    }

    @Override
    public void mostrarProducto(PublicacionesDTO publicacion) {
        binding.idnombreProdinvitacion.setText(publicacion.getNombre());
        binding.imageProducto.setImageBitmap(Product.convertByteArrayToBitmap(publicacion.getImage()));
    }

    @Override
    public String getIdUserCurrent() {
        SharedPreferences sharedPref = this.getSharedPreferences("data", Context.MODE_PRIVATE);
        return sharedPref.getString("currentIdUser","Usuario Actual");
    }

    public void invitarAmigos(){
        binding.btnInvitarAmigos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}