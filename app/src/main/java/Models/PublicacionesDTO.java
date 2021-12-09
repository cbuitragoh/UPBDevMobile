package Models;

import android.content.ContentValues;

import Contracts.ProductContracts;
import Contracts.UsersContracts;

public class PublicacionesDTO {
    private String idUser;
    private String comentario;
    private String fecha;
    private String nombre;
    private String tipo;
    private productState estado;
    private String image;

    public PublicacionesDTO() { }

    public PublicacionesDTO(String id, String comentario, String fecha, String nombre_alimento, String tipo_alimento) {
        this.idUser = id;
        this.comentario = comentario;
        this.fecha = fecha;
        this.nombre = nombre_alimento;
        this.tipo = tipo_alimento;
        this.estado = productState.NUEVO;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ProductContracts.ProductEntry.NAME, nombre);
        values.put(ProductContracts.ProductEntry.TYPE, tipo);
        values.put(ProductContracts.ProductEntry.EXPIREDDATE, fecha);
        values.put(ProductContracts.ProductEntry.COMMENT, comentario);
        values.put(ProductContracts.ProductEntry.USERID, idUser);
        values.put(ProductContracts.ProductEntry.STATE, String.valueOf(estado));
        return values;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public productState getEstado() {
        return estado;
    }

    public void setEstado(productState estado) {
        this.estado = estado;
    }
}
