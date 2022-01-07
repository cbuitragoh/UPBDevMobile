package Controllers;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import Contracts.ProductContracts;
import Contracts.UsersContracts;
import Interfaces.InicioInterface;
import Interfaces.PerfilInterfaz;
import Models.ConexionSQLHelper;
import Models.PublicacionesDTO;
import Models.UsuarioDto;
import Models.productState;
import db.Product;
import db.User;

public class ControladorPerfil implements PerfilInterfaz.Controlador {

    private final PerfilInterfaz.View view;

    public ControladorPerfil(PerfilInterfaz.View view) { this.view = view; }


    @Override
    public void recuperarLista(ConexionSQLHelper dbHelper) {
        List<PublicacionesDTO> publicacionesDTOList = new ArrayList<>();

        Cursor currentProducts = Product.getProductsByUser(view.getIdUserCurrent(), dbHelper);

        while (currentProducts.moveToNext()) {
            PublicacionesDTO currentPublicacion = handleCursorData(currentProducts);
            publicacionesDTOList.add(currentPublicacion);
        }

        currentProducts.close();
        view.mostrarLista(publicacionesDTOList);
    }

    @Override
    public void recuperarUsuario(ConexionSQLHelper dbHelper) {
        UsuarioDto user = UsuarioDto.getInstance();

        Cursor currentUser = User.getUserPerfil(view.getIdUserCurrent(),dbHelper);

        currentUser.moveToFirst();

        user.setNombre(currentUser.getString((int) currentUser.getColumnIndex(UsersContracts.UsersEntry.NAME)));
        user.setFoto(currentUser.getBlob((int) currentUser.getColumnIndex(UsersContracts.UsersEntry.PHOTO)));

        currentUser.close();
        view.mostrarUsuario(user);
    }



    private PublicacionesDTO handleCursorData(Cursor publicacion) {
        PublicacionesDTO publicacionNew = new PublicacionesDTO();

        publicacionNew.setTipo(publicacion.getString((int) publicacion.getColumnIndex(ProductContracts.ProductEntry.TYPE)));
        publicacionNew.setNombre(publicacion.getString((int) publicacion.getColumnIndex(ProductContracts.ProductEntry.NAME)));
        publicacionNew.setFecha(publicacion.getString((int) publicacion.getColumnIndex(ProductContracts.ProductEntry.EXPIREDDATE)));
        publicacionNew.setComentario(publicacion.getString((int) publicacion.getColumnIndex(ProductContracts.ProductEntry.COMMENT)));
        publicacionNew.setImage(publicacion.getBlob((int) publicacion.getColumnIndex(ProductContracts.ProductEntry.IMAGE)));
        publicacionNew.setEstado(productState.valueOf(publicacion.getString((int) publicacion.getColumnIndex(ProductContracts.ProductEntry.STATE))));

        return publicacionNew;
    }


}
