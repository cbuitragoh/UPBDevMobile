package Models;

import android.content.ContentValues;
import android.widget.ImageView;

import Contracts.UsersContracts;

public class UsuarioDto {

    private String nombre;
    private String apellido;
    private String sexo;
    private String direccion;
    private String correo;
    private byte[] foto;
    private String ciudad;
    private String celular;
    private String usuario;
    private String password;

    private static UsuarioDto instance = new UsuarioDto();

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(UsersContracts.UsersEntry.PHOTO, foto);
        values.put(UsersContracts.UsersEntry.NAME, nombre);
        values.put(UsersContracts.UsersEntry.LASTNAME, apellido);
        values.put(UsersContracts.UsersEntry.GENDER, sexo);
        values.put(UsersContracts.UsersEntry.ADDRESS, direccion);
        values.put(UsersContracts.UsersEntry.EMAIL, correo);
        values.put(UsersContracts.UsersEntry.CELLPHONE, celular);
        values.put(UsersContracts.UsersEntry.CITY, ciudad);
        values.put(UsersContracts.UsersEntry.USER, usuario);
        values.put(UsersContracts.UsersEntry.PASSWORD, password);
        return values;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UsuarioDto getInstance() {
        return instance;
    }

    public static void setInstance(UsuarioDto instance) {
        UsuarioDto.instance = instance;
    }
}
