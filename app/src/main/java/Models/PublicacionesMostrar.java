package Models;

public class PublicacionesMostrar {

    private String nombre;
    private String fecha;
    private int foto;
    private String estado;

    public PublicacionesMostrar(String nombre, String fecha, int foto, String estado) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.foto = foto;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
