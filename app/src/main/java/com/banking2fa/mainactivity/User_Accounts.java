package com.banking2fa.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;

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

        //gets the value of the Amount Field
        EditText edtamount = (EditText) findViewById(R.id.edtAmount); //gets the input
        String AmountString = edtamount.getText().toString(); //converts the EditText into local text
        double Amount = Double.parseDouble(AmountString);       //passes the string into double format


        //gets the value of the reference field
        EditText edtRef = (EditText) findViewById(R.id.edtRef); //gets the input
        String ref = edtRef.getText().toString(); //converts the input into local text

        //gets/sets the values of the radio groups.
        //if From A is selected then To B will auto Select, and vice versa
        RadioButton radFromA = (RadioButton ) findViewById(R.id.radioFromA); //gets the state of the button
        RadioButton radFromB = (RadioButton ) findViewById(R.id.radioFromB);//gets the state of the button
        RadioButton radToA = (RadioButton ) findViewById(R.id.radioToA);//gets the state of the button
        RadioButton radToB = (RadioButton ) findViewById(R.id.radioToB);//gets the state of the button

        boolean FromA = radFromA.isChecked();   //assigned the state locally
        boolean FromB = radFromB.isChecked();   //assigned the state locally
        boolean ToA = radToA.isChecked();   //assigned the state locally
        boolean ToB = radToB.isChecked();   //assigned the state locally

        //does verification check
        if (FromA){     //if From Account A is selected
          radToB.setChecked(true);  //add to Account B
          radToA.setChecked(false); // and NOT to account A
        }
        else if (FromB){   // if From Account B is selected
            radToA.setChecked(true);    //Add to account A
            radToB.setChecked(false);   // and NOT to account B
        }

        
        start_finish(Amount);
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
