package Interfaces;


import java.util.List;

import Models.PublicacionesDTO;

public interface InicioInterface {

    interface View {
        void mostrarLista(List<PublicacionesDTO> publicacionesDTOList);
        void respuestaSalirApp();
    }

    interface Controlador {
        void recuperarLista();
        void salirApp();
    }

    interface Modelo {
        void obtenerLista();
    }

}

