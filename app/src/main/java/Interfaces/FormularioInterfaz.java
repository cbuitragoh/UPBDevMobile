package Interfaces;


import android.app.Activity;

import Models.ConexionSQLHelper;
import Models.FormularioDTO;

public interface FormularioInterfaz {

    interface View {
        void validarResultadoFormulario(String editText, String mensaje);
        void respuestaGuardadoUsuario(Boolean respuesta);
        void tomarFoto(Activity activity);
    }

    interface Controlador {
        Boolean validarFormulario(FormularioDTO formularioDTO);
        Boolean usuarioGuardarUsuario(FormularioDTO formularioDTO, ConexionSQLHelper dbHelper);
    }

    interface Modelo {
    }

}
