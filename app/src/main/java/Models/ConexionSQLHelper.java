package Models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import Contracts.UsersContracts;
import Contracts.UsersContracts.UsersEntry;

public class ConexionSQLHelper extends SQLiteOpenHelper {

   private static final int DATA_VERSION = 1;
   private static final String DATABASE_NOMBRE = "FoodForAll.db";
   public static final String TABLA_USUARIOS = "usuarios";

    public ConexionSQLHelper(Context context) {
        super(context, DATABASE_NOMBRE, null, DATA_VERSION);
        System.out.println("I AM HERE");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + UsersEntry.TABLE_NAME + "("
                + UsersEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + UsersEntry.NAME + "TEXT NOT NULL, "
                + UsersEntry.LASTNAME + "TEXT NOT NULL,"
                + UsersEntry.GENDER + "TEXT NOT NULL,"
                + UsersEntry.ADDRESS + "TEXT NOT NULL,"
                + UsersEntry.EMAIL + "TEXT NOT NULL,"
                + UsersEntry.CELLPHONE  + "TEXT NOT NULL,"
                + UsersEntry.CITY + "TEXT NOT NULL,"
                + UsersEntry.USER  + "TEXT NOT NULL,"
                + UsersEntry.PASSWORD + "TEXT NOT NULL)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+ TABLA_USUARIOS);
        onCreate(db);
    }

    public long saveUser(UsuarioDto usuario) {
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(UsersContracts.UsersEntry.TABLE_NAME, null, usuario.toContentValues());
    }

}
