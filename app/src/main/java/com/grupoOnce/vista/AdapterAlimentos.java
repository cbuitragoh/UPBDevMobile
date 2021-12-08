package com.grupoOnce.vista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Models.PublicacionesMostrar;

public class AdapterAlimentos
        extends RecyclerView.Adapter<AdapterAlimentos.ViewHolderAlimentos>
        implements View.OnClickListener{

    ArrayList<PublicacionesMostrar> listaAlimentos;
    private View.OnClickListener listener;


    public AdapterAlimentos(ArrayList<PublicacionesMostrar> listaAlimentos) {
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
        holder.fotoAlimento.setImageResource(listaAlimentos.get(position).getFoto());
        holder.estadoAlimento.setText(listaAlimentos.get(position).getEstado());

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

        TextView nombreAlimen, fechaVenc, estadoAlimento;
        ImageView fotoAlimento;

        public ViewHolderAlimentos(@NonNull View itemView) {
            super(itemView);
            nombreAlimen = (TextView) itemView.findViewById(R.id.nombreAlimento);
            fechaVenc = (TextView) itemView.findViewById(R.id.fechaVencimiento);
            estadoAlimento = (TextView) itemView.findViewById(R.id.idEstadoProducto);
            fotoAlimento = (ImageView) itemView.findViewById(R.id.imagenAlimento);
        }
    }
}
