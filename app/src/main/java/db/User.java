package db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import Contracts.UsersContracts.UsersEntry;
import Models.ConexionSQLHelper;
import Models.UsuarioDto;

public class User {

    public String currentIdUser;

    public static void createUserTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + UsersEntry.TABLE_NAME + "("
                + UsersEntry._ID + " INTEGER PRIMARY KEY, "
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

        String [] projection = {
            UsersEntry._ID,
            UsersEntry.USER,
            UsersEntry.PASSWORD
        };

        String selection = UsersEntry.USER + " = ?" + " AND "+ UsersEntry.PASSWORD + " = ?";
        String[] selectionArgs = {usuario, password};

        return db.query(
            UsersEntry.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            null
        );

    }


    public String getCurrentIdUser() {
        return currentIdUser;
    }

    public void setCurrentIdUser(String currentIdUser) {
        this.currentIdUser = currentIdUser;
    }
}
