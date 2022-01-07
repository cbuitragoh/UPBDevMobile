package Controllers;

import android.database.Cursor;

import Contracts.ProductContracts;
import Contracts.UsersContracts;
import Interfaces.InvitarAmigosInterfaz;
import Models.ConexionSQLHelper;
import Models.PublicacionesDTO;
import Models.UsuarioDto;
import db.Product;
import db.User;

public class ControladorInvitarAmigos implements InvitarAmigosInterfaz.Controlador {

    private final InvitarAmigosInterfaz.View view;

    public ControladorInvitarAmigos(InvitarAmigosInterfaz.View view) { this.view = view; }


    @Override
    public void recuperarUsuario(ConexionSQLHelper dbHelper) {
        UsuarioDto usuario = UsuarioDto.getInstance();

        Cursor hostUser = User.getUserPerfil(view.getIdUserCurrent(),dbHelper);

        hostUser.moveToFirst();

        usuario.setNombre(hostUser.getString((int) hostUser.getColumnIndex(UsersContracts.UsersEntry.NAME)));

        hostUser.close();
        view.mostrarNombreUsuario(usuario);

    }

    @Override
    public void recuperarProducto(ConexionSQLHelper dbHelper) {
        PublicacionesDTO publicacion = new PublicacionesDTO();

        Cursor productToInvite = Product.getProductsByUser(view.getIdUserCurrent(), dbHelper);

        productToInvite.moveToLast();
        publicacion.setImage(productToInvite.getBlob((int) productToInvite.getColumnIndex(ProductContracts.ProductEntry.IMAGE)));
        publicacion.setNombre(productToInvite.getString((int) productToInvite.getColumnIndex(ProductContracts.ProductEntry.NAME)));

        productToInvite.close();
        view.mostrarProducto(publicacion);

    }
}
