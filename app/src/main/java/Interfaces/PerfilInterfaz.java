package Interfaces;

import java.util.List;

import Models.ConexionSQLHelper;
import Models.PublicacionesDTO;

public interface PerfilInterfaz {

    interface View {
        void mostrarLista(List<PublicacionesDTO> publicacionesDTOList);
        void mostrarUsuario();
        void respuestaSalirApp();
    }

    interface Controlador {
        void recuperarLista(ConexionSQLHelper dbHelper);
        void recuperarUsuario(ConexionSQLHelper dbHelper);
        void salirApp();
    }

    interface Modelo {
        void obtenerLista();
    }
}
