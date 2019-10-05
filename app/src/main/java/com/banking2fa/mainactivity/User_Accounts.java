package com.banking2fa.mainactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.Toast;

public class User_Accounts extends AppCompatActivity implements View.OnClickListener {
    //private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__accounts);
        setTitle("Payments");
        /*mButton = findViewById(R.id.btnCancel);
        mButton.setOnClickListener(this);*/
        (findViewById(R.id.btnCancel)).setOnClickListener(this);
        (findViewById(R.id.btnFinish)).setOnClickListener(this);
    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.btnCancel:
                cancelTransaction();
                break;
            case R.id.btnFinish:
                finishTransaction();
                break;
            default:
                break;
        }
    }

    private void finishTransaction(){
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("You are about to pay R" + ((EditText)findViewById(R.id.etPaymentAmount)).getText().toString() +
                "\n to " + ((Spinner)findViewById(R.id.spnRecipientAccounts)).getSelectedItem().toString() + "." +
                "\n\n Would you like to complete the transaction?");
        dlgAlert.setTitle("Complete Transaction?");
        dlgAlert.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss the dialog
                    }
                });
        dlgAlert.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Complete the transaction and save the values to the db at a later stage.
                        Toast.makeText(getApplicationContext(), "Your Payment Was Successful!", Toast.LENGTH_LONG).show();
                    }
                });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    private void cancelTransaction(){
        clearAllFields((ViewGroup) findViewById(R.id.tlUserAccounts));
    }

    private void clearAllFields(ViewGroup group){

        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText)view).setText("");
            }
            if (view instanceof Spinner) {
                ((Spinner)view).setSelection(0);
            }

            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                clearAllFields((ViewGroup)view);
        }
    }
}