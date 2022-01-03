package Controllers;

import Interfaces.DetalleInterfaz;
import Models.ConexionSQLHelper;
import Models.PublicacionesDTO;
import db.Product;

public class ControladorDetalle implements DetalleInterfaz.Controlador{

    private final DetalleInterfaz.View view;

    public ControladorDetalle(DetalleInterfaz.View view) { this.view = view; }

    @Override
    public boolean eliminarPublicacion(PublicacionesDTO publicacion, ConexionSQLHelper dbHelper) {
        int productDeleted = Product.deleteProducts(publicacion, dbHelper);
        if(productDeleted>0){
            view.respuestaEliminacion(true);
            return true;
        }else{
            view.respuestaEliminacion(false);
            return false;
        }

    }

}
