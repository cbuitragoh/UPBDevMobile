package Contracts;

import android.provider.BaseColumns;

public class ProductContracts {

    public static abstract class ProductEntry implements BaseColumns {
        public static final String TABLE_NAME = "productos";

        public static final String NAME= "nombres";
        public static final String IMAGE= "imagen";
        public static final String EXPIREDDATE= "fechavencimiento";
        public static final String TYPE= "tipo";
        public static final String COMMENT= "comentario";
        public static final String STATE = "estado";
        public static final String USERID= "idUsuario";

    }
}
