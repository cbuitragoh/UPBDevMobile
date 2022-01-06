package Contracts;

import android.provider.BaseColumns;

public class UsersContracts {

    private UsersContracts() {}

    public static class UsersEntry implements BaseColumns {
        public static final String TABLE_NAME = "usuarios";

        public static final String PHOTO= "foto";
        public static final String NAME= "nombres";
        public static final String LASTNAME= "apellidos";
        public static final String GENDER= "sexo";
        public static final String ADDRESS= "direccion";
        public static final String EMAIL= "correo";
        public static final String CELLPHONE= "celular";
        public static final String CITY= "ciudad";
        public static final String USER = "usuario";
        public static final String PASSWORD= "password";
    }
}
