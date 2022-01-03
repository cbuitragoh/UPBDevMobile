package Interfaces;

import Models.ConexionSQLHelper;
import Models.PublicacionesDTO;

public interface DetalleInterfaz {

    public interface View{
        void mostrarPublicaciones();
        void respuestaEliminacion(Boolean respuesta);

    }
    public interface Controlador{
        boolean eliminarPublicacion(PublicacionesDTO publicacion, ConexionSQLHelper dbHelper);
    }
}
