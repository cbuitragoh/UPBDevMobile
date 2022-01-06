package Controllers;

import android.database.Cursor;

import Interfaces.FormularioInterfaz;
import Models.ConexionSQLHelper;
import Models.FormularioDTO;
import Models.UsuarioDto;
import db.User;

public class ControladorFormulario implements FormularioInterfaz.Controlador {

    private final FormularioInterfaz.View view;

    public ControladorFormulario(FormularioInterfaz.View view) {
        this.view = view;
    }


    @Override
    public Boolean validarFormulario(FormularioDTO formularioDTO) {
        boolean isValidName = validFormFieldEmpty("nombres", formularioDTO.getEditNombres());
        boolean isValidLastName = validFormFieldEmpty("apellidos", formularioDTO.getEditApellidos());
        boolean isValidAddress = validFormFieldEmpty("direccion", formularioDTO.getEditDireccion());
        boolean isValidEmail = validFormFieldEmpty("correo", formularioDTO.getEditCorreo());
        boolean isValidCity = validFormFieldEmpty("ciudad", formularioDTO.getEditCiudad());
        boolean isValidCellphone = validFormFieldEmpty("celular", formularioDTO.getEditCelular());
        boolean isValidUser = validFormFieldEmpty("usuario", formularioDTO.getEditCorreo());
        boolean isValidPassword = validFormFieldEmpty("password", formularioDTO.getEditPassword());

        if (!(isValidName && isValidLastName && isValidAddress && isValidEmail && isValidCity && isValidCellphone && isValidUser && isValidPassword)) {
            return false;
        } else if (formularioDTO.getSpSexo().trim().equalsIgnoreCase("SELECCIONE EL SEXO")) {
            view.validarResultadoFormulario("sexo", "Seleccione el sexo");
            return false;
        } else if (!formularioDTO.getEditCorreo().trim().matches("[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+")) {
            view.validarResultadoFormulario("correo", "El correo debe ser valido");
            return false;
        }  else if (formularioDTO.getEditPassword().trim().length() < 6) {
            view.validarResultadoFormulario("password", "La contraseña debe tener mínimo 6 caracteres");
            return false;
        }

        return true;
    }

    @Override
    public Boolean usuarioGuardarUsuario(FormularioDTO formularioDTO, ConexionSQLHelper dbHelper) {
        if (formularioDTO != null) {
            UsuarioDto usuario = UsuarioDto.getInstance();
            usuario.setNombre(formularioDTO.getEditNombres());
            usuario.setApellido(formularioDTO.getEditApellidos());
            usuario.setSexo(formularioDTO.getSpSexo());
            usuario.setDireccion(formularioDTO.getEditDireccion());
            usuario.setCorreo(formularioDTO.getEditCorreo());
            usuario.setCiudad(formularioDTO.getEditCiudad());
            usuario.setCelular(formularioDTO.getEditCelular());
            usuario.setUsuario(formularioDTO.getEditUsuario());
            usuario.setPassword(formularioDTO.getEditPassword());
            usuario.setFoto(User.getBitmatAsByteArray(formularioDTO.getEditFoto()));
            return saveUser(usuario, dbHelper);
        } else {
            view.respuestaGuardadoUsuario(false);
            return false;
        }
    }

    public boolean saveUser(UsuarioDto usuario, ConexionSQLHelper dbHelper) {

        Cursor authorizedUser = User.getUser(usuario.getUsuario(), usuario.getPassword(), dbHelper);
        if (authorizedUser.getCount() > 0 ) {
            view.respuestaUsuarioExistente(true);
            return false;
        }

        long userSaved = User.saveUser(usuario, dbHelper);
        view.respuestaGuardadoUsuario(userSaved > 0);
        return userSaved > 0;

    }

    private Boolean validFormFieldEmpty(String field, String value) {

        if (!value.trim().isEmpty()) return true;

        view.validarResultadoFormulario(field, "Los campos no pueden estar vacíos");
        return false;
    }

}
