package Interfaces;


import Models.ConexionSQLHelper;
import Models.FormularioDTO;

public interface FormularioInterfaz {

    interface View {
        void validarResultadoFormulario(String editText, String mensaje);
        void respuestaGuardadoUsuario(Boolean respuesta);
    }

    interface Controlador {
        Boolean validarFormulario(FormularioDTO formularioDTO);
        Boolean usuarioGuardarUsuario(FormularioDTO formularioDTO, ConexionSQLHelper dbHelper);
    }

    interface Modelo {
    }

}
