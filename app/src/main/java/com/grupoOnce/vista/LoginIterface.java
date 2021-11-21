package com.grupoOnce.vista;

import android.view.View;

public interface LoginIterface {

    interface loginView {
        void resVal(String editText, String message);
    }

    interface loginController {
        Boolean loginVal(String editText, String indicator);
    }

    interface Model {
    }

}
