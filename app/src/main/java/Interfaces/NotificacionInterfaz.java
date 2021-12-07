package Interfaces;

import Models.FormularioPublicacionDTO;

public interface NotificacionInterfaz {

    interface View {
        void respuestaValidacion(String indicador, String mensaje);
        void respuestaGuardado(Boolean respuesta);
    }

    interface Controlador {
       Boolean validarCampos(FormularioPublicacionDTO formularioPublicacionDTO);
       Boolean guardarPublicacion(FormularioPublicacionDTO formularioPublicacionDTO);
    }

    interface Modelo {
    }

}
