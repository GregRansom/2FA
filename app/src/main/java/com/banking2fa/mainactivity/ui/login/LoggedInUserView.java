package com.banking2fa.mainactivity.ui.login;

import android.content.Context;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private Context context;
    private String displayName;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName) {
        this.displayName = displayName;
    }

    String getDisplayName() {
        return displayName;
    }
}
