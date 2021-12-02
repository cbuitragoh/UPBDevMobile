package Models;

public class PublicacionesDTO {
    private String id;
    private String comentario;
    private String fecha;
    private String nombre_alimento;
    private String tipo_alimento;

    public PublicacionesDTO() { }

    public PublicacionesDTO(String id, String comentario, String fecha, String nombre_alimento, String tipo_alimento) {
        this.id = id;
        this.comentario = comentario;
        this.fecha = fecha;
        this.nombre_alimento = nombre_alimento;
        this.tipo_alimento = tipo_alimento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getNombre_alimento() {
        return nombre_alimento;
    }

    public void setNombre_alimento(String nombre_alimento) {
        this.nombre_alimento = nombre_alimento;
    }

    public String getTipo_alimento() {
        return tipo_alimento;
    }

    public void setTipo_alimento(String tipo_alimento) {
        this.tipo_alimento = tipo_alimento;
    }
}
