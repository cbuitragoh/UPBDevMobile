package Controllers;

import Interfaces.FormularioInterfaz;
import Models.ConexionSQLHelper;
import Models.FormularioDTO;
import Models.UsuarioDto;

public class ControladorFormulario implements FormularioInterfaz.Controlador {

    private final FormularioInterfaz.View view;

    public ControladorFormulario(FormularioInterfaz.View view) {
        this.view = view;
    }


    @Override
    public Boolean validarFormulario(FormularioDTO formularioDTO) {
        if (formularioDTO.getEditNombres().trim().isEmpty()) {
            view.validarResultadoFormulario("nombre", "Los campos no pueden estar vacíos");
            return false;
        } else if (formularioDTO.getEditApellidos().trim().isEmpty()) {
            view.validarResultadoFormulario("apellido", "Los campos no pueden estar vacíos");
            return false;
        } else if (formularioDTO.getSpSexo().trim().equalsIgnoreCase("SELECCIONE EL SEXO")) {
            view.validarResultadoFormulario("sexo", "Seleccione el sexo");
            return false;
        } else if (formularioDTO.getEditDireccion().trim().isEmpty()) {
            view.validarResultadoFormulario("direccion", "Los campos no pueden estar vacíos");
            return false;
        } else if (formularioDTO.getEditCorreo().trim().isEmpty()) {
            view.validarResultadoFormulario("correo", "Los campos no pueden estar vacíos");
            return false;
        } else if (!formularioDTO.getEditCorreo().trim().matches("[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+")) {
            view.validarResultadoFormulario("correo", "El correo debe ser valido");
            return false;
        } else if (formularioDTO.getEditCiudad().trim().isEmpty()) {
            view.validarResultadoFormulario("ciudad", "Los campos no pueden estar vacíos");
            return false;
        } else if (formularioDTO.getEditCelular().trim().isEmpty()) {
            view.validarResultadoFormulario("celular", "Los campos no pueden estar vacíos");
            return false;
        } else if (formularioDTO.getEditUsuario().trim().isEmpty()) {
            view.validarResultadoFormulario("usuario", "Los campos no pueden estar vacíos");
            return false;
        } else if (formularioDTO.getEditPassword().trim().isEmpty()) {
            view.validarResultadoFormulario("password", "Los campos no pueden estar vacíos");
            return false;
        } else if (formularioDTO.getEditPassword().trim().length() < 6) {
            view.validarResultadoFormulario("password_length", "La contraseña debe tener mínimo 6 caracteres");
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
            usuario.setUsuario(formularioDTO.getEditCorreo());
            usuario.setPassword(formularioDTO.getEditPassword());
            return saveUser(dbHelper, usuario);
        } else {
            view.respuestaGuardadoUsuario(false);
            return false;
        }
    }

    public boolean saveUser(ConexionSQLHelper db, UsuarioDto usuario) {

        long userSaved = db.saveUser(usuario);

        view.respuestaGuardadoUsuario(userSaved > 0);
        return userSaved > 0;

    }



}
