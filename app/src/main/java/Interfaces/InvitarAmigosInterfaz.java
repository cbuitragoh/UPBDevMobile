package Interfaces;

import Models.ConexionSQLHelper;
import Models.PublicacionesDTO;
import Models.UsuarioDto;

public interface InvitarAmigosInterfaz {

    interface View{
        void mostrarNombreUsuario(UsuarioDto usuario);
        void mostrarProducto(PublicacionesDTO publicacion);
        String getIdUserCurrent();

    }

    interface Controlador {
        void recuperarUsuario(ConexionSQLHelper dbHelper);
        void recuperarProducto(ConexionSQLHelper dbHelper);
    }
}
