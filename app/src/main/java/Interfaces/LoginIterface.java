package Interfaces;

import Models.ConexionSQLHelper;

public interface LoginIterface {

    interface View {
        void validarResultado(String editText, String mensaje);
        void usuarioAutorizado(Boolean valida);
    }

    interface Controlador {
        Boolean validarLogin(String editText, String indicador);
        Boolean usuarioPermitido(String usuario, String password, ConexionSQLHelper dbHelper);
    }

    interface Modelo {
    }

}
