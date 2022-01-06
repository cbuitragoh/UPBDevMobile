package Controllers;

import android.database.Cursor;

import Interfaces.NotificacionInterfaz;
import Models.ConexionSQLHelper;
import Models.FormularioPublicacionDTO;
import Models.PublicacionesDTO;
import Models.UsuarioDto;
import Models.productState;
import db.Product;
import db.User;

public class ControladorNotificacion extends User implements NotificacionInterfaz.Controlador {

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
    public Boolean guardarPublicacion(FormularioPublicacionDTO formularioPublicacionDTO, ConexionSQLHelper dbHelper) {
        if (formularioPublicacionDTO != null) {
            PublicacionesDTO publicacionDTO = new PublicacionesDTO();
            publicacionDTO.setImage(Product.getBitmatAsByteArray(formularioPublicacionDTO.getFotoAlimento()));
            publicacionDTO.setNombre(formularioPublicacionDTO.getNombreAlimento());
            publicacionDTO.setFecha(formularioPublicacionDTO.getFechaVencimiento());
            publicacionDTO.setTipo(formularioPublicacionDTO.getTipoAlimento());
            publicacionDTO.setComentario(formularioPublicacionDTO.getComentario());
            //publicacionDTO.setIdUser(getCurrentIdUser());
            publicacionDTO.setIdUser("1");
            publicacionDTO.setEstado(productState.NUEVO);

            return saveProduct(publicacionDTO, dbHelper);
        }
        view.respuestaGuardado(false);
        return false;
    }

    public boolean saveProduct(PublicacionesDTO publicacion, ConexionSQLHelper dbHelper) {

        long productSaved = Product.saveProduct(publicacion, dbHelper);
        view.respuestaGuardado(productSaved > 0);
        return productSaved > 0;

    }

}
