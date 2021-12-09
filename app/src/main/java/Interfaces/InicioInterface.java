package Interfaces;


import java.util.List;

import Models.ConexionSQLHelper;
import Models.PublicacionesDTO;

public interface InicioInterface {

    interface View {
        void mostrarLista(List<PublicacionesDTO> publicacionesDTOList);
        void respuestaSalirApp();
    }

    interface Controlador {
        void recuperarLista(ConexionSQLHelper dbHelper);
        void salirApp();
    }

    interface Modelo {
        void obtenerLista();
    }

}

