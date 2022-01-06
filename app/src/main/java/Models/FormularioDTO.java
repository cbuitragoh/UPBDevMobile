package Models;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class FormularioDTO {

    private String editNombres;
    private String editApellidos;
    private String editDireccion;
    private String editCorreo;
    private String editCiudad;
    private String editCelular;
    private String editUsuario;
    private String editPassword;
    private String spSexo;
    private Drawable editFoto;


    public FormularioDTO(String editNombres, String editApellidos, String editDireccion, String editCorreo, String editCiudad, String editCelular, String editUsuario, String editPassword, String spSexo, Drawable editFoto) {
        this.editNombres = editNombres;
        this.editApellidos = editApellidos;
        this.editDireccion = editDireccion;
        this.editCorreo = editCorreo;
        this.editCiudad = editCiudad;
        this.editCelular = editCelular;
        this.editUsuario = editUsuario;
        this.editPassword = editPassword;
        this.spSexo = spSexo;
        this.editFoto = editFoto;
    }

    public String getEditNombres() {
        return editNombres;
    }

    public void setEditNombres(String editNombres) {
        this.editNombres = editNombres;
    }

    public String getEditApellidos() {
        return editApellidos;
    }

    public void setEditApellidos(String editApellidos) {
        this.editApellidos = editApellidos;
    }

    public String getEditDireccion() {
        return editDireccion;
    }

    public void setEditDireccion(String editDireccion) {
        this.editDireccion = editDireccion;
    }

    public String getEditCorreo() {
        return editCorreo;
    }

    public void setEditCorreo(String editCorreo) {
        this.editCorreo = editCorreo;
    }

    public String getEditCiudad() {
        return editCiudad;
    }

    public void setEditCiudad(String editCiudad) {
        this.editCiudad = editCiudad;
    }

    public String getEditCelular() {
        return editCelular;
    }

    public void setEditCelular(String editCelular) {
        this.editCelular = editCelular;
    }

    public String getEditUsuario() {
        return editUsuario;
    }

    public void setEditUsuario(String editUsuario) {
        this.editUsuario = editUsuario;
    }

    public String getEditPassword() {
        return editPassword;
    }

    public void setEditPassword(String editPassword) {
        this.editPassword = editPassword;
    }

    public String getSpSexo() {
        return spSexo;
    }

    public void setSpSexo(String spSexo) {
        this.spSexo = spSexo;
    }

    public Drawable getEditFoto() {
        return editFoto;
    }

    public void setEditFoto(Drawable editFoto) {
        this.editFoto = editFoto;
    }
}
