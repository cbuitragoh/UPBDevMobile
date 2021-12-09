package com.grupoOnce.vista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Models.PublicacionesDTO;
import Models.PublicacionesMostrar;

public class AdapterAlimentos
        extends RecyclerView.Adapter<AdapterAlimentos.ViewHolderAlimentos>
        implements View.OnClickListener{

    List<PublicacionesDTO> listaAlimentos;
    private View.OnClickListener listener;

    public AdapterAlimentos(List<PublicacionesDTO> listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
    }

    @NonNull
    @Override
    public ViewHolderAlimentos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.alimentos_items,null, false);

        vista.setOnClickListener(this);

        return new ViewHolderAlimentos(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAlimentos holder, int position) {
        holder.nombreAlimen.setText(listaAlimentos.get(position).getNombre());
        holder.fechaVenc.setText(listaAlimentos.get(position).getFecha());
        holder.fotoAlimento.setImageResource(Integer.parseInt(listaAlimentos.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        return listaAlimentos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderAlimentos extends RecyclerView.ViewHolder {

        TextView nombreAlimen, fechaVenc;
        ImageView fotoAlimento;

        public ViewHolderAlimentos(@NonNull View itemView) {
            super(itemView);
            nombreAlimen = itemView.findViewById(R.id.nombreAlimento);
            fechaVenc = itemView.findViewById(R.id.fechaVencimiento);
            fotoAlimento = itemView.findViewById(R.id.imagenAlimento);
        }
    }
}
