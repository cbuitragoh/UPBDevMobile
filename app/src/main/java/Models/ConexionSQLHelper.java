package Models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import Contracts.UsersContracts;
import Contracts.UsersContracts.UsersEntry;
import db.Product;
import db.User;

public class ConexionSQLHelper extends SQLiteOpenHelper {

   private static final int DATA_VERSION = 1;
   private static final String DATABASE_NOMBRE = "FoodForAll.db";
   public static final String TABLA_USUARIOS = "usuarios";
    public static final String TABLA_PRODUCTOS = "productos";

    public ConexionSQLHelper(Context context) {
        super(context, DATABASE_NOMBRE, null, DATA_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        User.createUserTable(db);
        Product.createProductTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+ TABLA_USUARIOS);
        db.execSQL("DROP TABLE "+ TABLA_PRODUCTOS);
        onCreate(db);
    }

    public SQLiteDatabase getReadableDb() {
        return getReadableDatabase();
    }

    public SQLiteDatabase getWritableDb() {
        return getReadableDatabase();
    }



}
