package Controllers;

import android.database.Cursor;

import Contracts.UsersContracts;
import Interfaces.LoginIterface;
import Models.ConexionSQLHelper;
import db.User;

public class ControladorLogin extends User implements LoginIterface.Controlador {

    private final LoginIterface.View view;

    public ControladorLogin(LoginIterface.View view) {
        this.view = view;
    }

    @Override
    public Boolean validarLogin(String editText, String indicador) {
        if (indicador.equals("usuario")) {
            if (editText.trim().isEmpty()) {
                view.validarResultado(indicador, "Los campos no pueden estar vacíos");
                return false;
            } else if (editText.trim().length() <= 4) {
                view.validarResultado(indicador, "Los campos deben ser mayor o igual a 5");
                return false;
            }
        } else if (indicador.equals("password")) {
            if (editText.trim().isEmpty()) {
                view.validarResultado(indicador, "Los campos no pueden estar vacíos");
                return false;
            } else if (editText.trim().length() <= 4) {
                view.validarResultado(indicador, "Los campos deben ser mayor o igual a 5");
                return false;
            }
        }

        return true;
    }

    @Override
    public Boolean usuarioPermitido(String usuario, String password, ConexionSQLHelper dbHelper) {

        Cursor authorizedUser = getUser(usuario, password, dbHelper);
        authorizedUser.moveToFirst();
        int userIndex = authorizedUser.getColumnIndex(UsersContracts.UsersEntry._ID);
        setCurrentIdUser(authorizedUser.getString(userIndex));

        boolean userAutho = (authorizedUser.getCount() > 0);
        view.usuarioAutorizado(userAutho);
        authorizedUser.close();
        return userAutho;
    }
}
