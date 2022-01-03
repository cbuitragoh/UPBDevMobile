package db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import javax.xml.namespace.QName;

import Contracts.ProductContracts;
import Contracts.ProductContracts.ProductEntry;
import Contracts.UsersContracts;
import Models.ConexionSQLHelper;
import Models.PublicacionesDTO;

public class Product {

    public static void createProductTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ProductEntry.TABLE_NAME + "("
                + ProductEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ProductEntry.NAME + " TEXT NOT NULL, "
                + ProductEntry.EXPIREDDATE + " TEXT NOT NULL,"
                + ProductEntry.COMMENT + " TEXT NOT NULL,"
                + ProductEntry.TYPE + " TEXT NOT NULL,"
                + ProductEntry.IMAGE + " TEXT ,"
                + ProductEntry.STATE  + " TEXT NOT NULL,"
                + ProductEntry.USERID + " TEXT NOT NULL)" );
    }

    public static long saveProduct(PublicacionesDTO producto, ConexionSQLHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getWritableDb();
        return db.insert(ProductEntry.TABLE_NAME, null, producto.toContentValues());
    }

    public static Cursor getProductsByUser(String idUser, ConexionSQLHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDb();
        String query = "Select * FROM " + ProductEntry.TABLE_NAME + " WHERE " + ProductEntry.USERID + " = ? ";
        return db.rawQuery(query, new String[]{idUser});
    }

    public static Cursor getProducts(ConexionSQLHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDb();

        String [] projection = {
                ProductEntry.NAME,
                ProductEntry.EXPIREDDATE,
                ProductEntry.STATE,
                ProductEntry.TYPE,
                ProductEntry.COMMENT
        };


        return db.query(
                ProductEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }

    public static int deleteProducts(PublicacionesDTO producto, ConexionSQLHelper dbHelper){
        SQLiteDatabase db = dbHelper.getWritableDb();
        String [] args = new String[]{producto.getNombre()};
        return db.delete(ProductEntry.TABLE_NAME, ProductEntry.NAME+ " = ?",args);

    }
}
