package Interfaces;

import java.util.List;

import Models.ConexionSQLHelper;
import Models.PublicacionesDTO;
import Models.UsuarioDto;

public interface PerfilInterfaz {

    interface View {
        void mostrarLista(List<PublicacionesDTO> publicacionesDTOList);
        void mostrarUsuario(UsuarioDto usuario);
        String getIdUserCurrent();

    }

    interface Controlador {
        void recuperarLista(ConexionSQLHelper dbHelper);
        void recuperarUsuario(ConexionSQLHelper dbHelper);

    }

    interface Modelo {
        void obtenerLista();
    }
}
