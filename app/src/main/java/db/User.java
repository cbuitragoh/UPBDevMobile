package db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import Contracts.UsersContracts.UsersEntry;
import Models.ConexionSQLHelper;
import Models.UsuarioDto;

public class User {

    public String currentIdUser;

    public static void createUserTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + UsersEntry.TABLE_NAME + "("
                + UsersEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + UsersEntry.NAME + " TEXT NOT NULL, "
                + UsersEntry.LASTNAME + " TEXT NOT NULL,"
                + UsersEntry.GENDER + " TEXT NOT NULL,"
                + UsersEntry.ADDRESS + " TEXT NOT NULL,"
                + UsersEntry.EMAIL + " TEXT NOT NULL,"
                + UsersEntry.CELLPHONE  + " TEXT NOT NULL,"
                + UsersEntry.CITY + " TEXT NOT NULL,"
                + UsersEntry.USER  + " TEXT NOT NULL,"
                + UsersEntry.PASSWORD + " TEXT NOT NULL)" );
    }

    public static long saveUser(UsuarioDto usuario, ConexionSQLHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getWritableDb();
        return db.insert(UsersEntry.TABLE_NAME, null, usuario.toContentValues());
    }

    public static Cursor getUser(String usuario, String password, ConexionSQLHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDb();
        String query = "Select * FROM " + UsersEntry.TABLE_NAME + " WHERE " + UsersEntry.USER + " = ? AND " + UsersEntry.PASSWORD + " =  ?";
        return db.rawQuery(query, new String[]{usuario, password});
    }


    public String getCurrentIdUser() {
        return currentIdUser;
    }

    public void setCurrentIdUser(String currentIdUser) {
        this.currentIdUser = currentIdUser;
    }
}
