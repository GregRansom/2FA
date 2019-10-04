package com.banking2fa.mainactivity.data;

import android.content.Context;
import android.content.Intent;

import com.banking2fa.mainactivity.FingerprintHandler;
import com.banking2fa.mainactivity.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    private Context context;

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            " Johnathan Tester");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
        Intent logout = new Intent(this.context,  FingerprintHandler.class);
        context.startActivity(logout);
    }
}
