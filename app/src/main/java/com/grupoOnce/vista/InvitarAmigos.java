package com.grupoOnce.vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.grupoOnce.vista.databinding.ActivityHomeInfoBinding;
import com.grupoOnce.vista.databinding.ActivityInvitarAmigosBinding;

public class InvitarAmigos extends AppCompatActivity {

    private ActivityInvitarAmigosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInvitarAmigosBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();
    }
}