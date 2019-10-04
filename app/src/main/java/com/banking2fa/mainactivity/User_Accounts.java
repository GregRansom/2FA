package com.banking2fa.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class User_Accounts extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__accounts);
    }

    //listens for the cancel button to be clicked.
    public void cancel_transfer(android.view.View canceled){
        Intent logout = new Intent(this.context, FingerprintHandler.class);
        context.startActivity(logout);
    }

    //listens for the finish button to be clicked.
    //then performs the verification check on the amount.
    public void finish_transfer(android.view.View finished){
        start_finish(20000.00);
    }

    //performs a verification check on the amount being requested to transfer.
    private void start_finish(double amount){
        if (amount >= 2000){
            request_auth();
        }
    }

    private boolean request_auth(){
    return true;
    }
}
