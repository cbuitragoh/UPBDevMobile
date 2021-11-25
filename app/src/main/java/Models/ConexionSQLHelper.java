package Models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class ConexionSQLHelper extends SQLiteOpenHelper {

   private static final int DATA_VERSION = 1;
   private static final String DATABASE_NOMBRE = "FoodForAll.db";
   public static final String TABLA_USUARIOS = "usuarios";

    public ConexionSQLHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATA_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLA_USUARIOS + "(" +
                " idUsuario INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nombres TEXT NOT NULL, " +
                " apellidos TEXT NOT NULL," +
                " sexo TEXT NOT NULL," +
                " direccion TEXT NOT NULL," +
                " correo TEXT NOT NULL," +
                " celular TEXT NOT NULL," +
                " ciudad TEXT NOT NULL," +
                " usuario TEXT NOT NULL," +
                " password TEXT NOT NULL)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+ TABLA_USUARIOS);
        onCreate(db);
    }
}
