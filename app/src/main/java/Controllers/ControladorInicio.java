package Controllers;


import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import Contracts.ProductContracts;
import Interfaces.InicioInterface;
import Models.ConexionSQLHelper;
import Models.PublicacionesDTO;
import Models.productState;
import db.Product;
import db.User;

public class ControladorInicio extends User implements InicioInterface.Controlador {

    private final InicioInterface.View view;

    public ControladorInicio(InicioInterface.View view) {
        this.view = view;
    }

    @Override
    public void recuperarLista(ConexionSQLHelper dbHelper) {

        List<PublicacionesDTO> publicacionesDTOList = new ArrayList<>();

        Cursor currentProducts = Product.getProducts(dbHelper);

        while (currentProducts.moveToNext()) {
            PublicacionesDTO currentPublicacion = handleCursorData(currentProducts);
            publicacionesDTOList.add(currentPublicacion);
        }

        currentProducts.close();
        view.mostrarLista(publicacionesDTOList);


    }

    @Override
    public void salirApp() {
        view.respuestaSalirApp();
    }

    private PublicacionesDTO handleCursorData(Cursor publicacion) {
        PublicacionesDTO publicacionNew = new PublicacionesDTO();

        publicacionNew.setTipo(publicacion.getString((int) publicacion.getColumnIndex(ProductContracts.ProductEntry.TYPE)));
        publicacionNew.setNombre(publicacion.getString((int) publicacion.getColumnIndex(ProductContracts.ProductEntry.NAME)));
        publicacionNew.setFecha(publicacion.getString((int) publicacion.getColumnIndex(ProductContracts.ProductEntry.EXPIREDDATE)));
        publicacionNew.setComentario(publicacion.getString((int) publicacion.getColumnIndex(ProductContracts.ProductEntry.COMMENT)));
        publicacionNew.setEstado(productState.valueOf(publicacion.getString((int) publicacion.getColumnIndex(ProductContracts.ProductEntry.STATE))));

        return publicacionNew;
    }


}

