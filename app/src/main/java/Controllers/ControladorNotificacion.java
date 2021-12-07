package Controllers;

import Interfaces.NotificacionInterfaz;
import Models.FormularioPublicacionDTO;

public class ControladorNotificacion implements NotificacionInterfaz.Controlador {

    private final NotificacionInterfaz.View view;

    public ControladorNotificacion(NotificacionInterfaz.View view) {
        this.view = view;
    }


    @Override
    public Boolean validarCampos(FormularioPublicacionDTO formularioPublicacionDTO) {
        if (formularioPublicacionDTO != null) {
            if (formularioPublicacionDTO.getNombreAlimento().isEmpty()) {
                view.respuestaValidacion("nombreAlimento", "Los campos no pueden estar vacíos");
                return false;
            } else if (formularioPublicacionDTO.getFechaVencimiento().isEmpty()) {
                view.respuestaValidacion("fecha", "Los campos no pueden estar vacíos");
                return false;
            } else if (formularioPublicacionDTO.getTipoAlimento().isEmpty()) {
                view.respuestaValidacion("tipo", "Los campos no pueden estar vacíos");
                return false;
            } else if (formularioPublicacionDTO.getComentario().isEmpty()) {
                view.respuestaValidacion("comentario", "Los campos no pueden estar vacíos");
                return false;
            }
            return true;
        } else {
            view.respuestaValidacion("", "Error de implementación");
            return false;
        }


    }

    @Override
    public Boolean guardarPublicacion(FormularioPublicacionDTO formularioPublicacionDTO) {
        if (formularioPublicacionDTO != null) {
            FormularioPublicacionDTO publicacionDTO = FormularioPublicacionDTO.getInstance();
            publicacionDTO.setNombreAlimento(formularioPublicacionDTO.getNombreAlimento());
            publicacionDTO.setFechaVencimiento(formularioPublicacionDTO.getFechaVencimiento());
            publicacionDTO.setTipoAlimento(formularioPublicacionDTO.getTipoAlimento());
            publicacionDTO.setComentario(formularioPublicacionDTO.getComentario());
            view.respuestaGuardado(true);
            return true;
        }
        view.respuestaGuardado(false);
        return false;
    }

}
