package com.banking2fa.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

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
        //gets the current values of the accounts.
        TextView AccountAFrom = (TextView) findViewById(R.id.lblAccountAAmount); //sets the amount to be subtracted from
        TextView AccountBFrom = (TextView) findViewById(R.id.lblAccountBAmount);//sets the amount to be subtracted from
        TextView AccountATo = (TextView) findViewById(R.id.lblAccountAAmount2);//sets the amount to be added to
        TextView AccountBTo = (TextView) findViewById(R.id.lblAccountBAmount2);//sets the amount to be added to

        String AccountAFromString = AccountAFrom.getText().toString();  //converts into local string
        String AccountBFromString = AccountAFrom.getText().toString();//converts into local string
        String AccountAToString = AccountAFrom.getText().toString();//converts into local string
        String AccountBToString = AccountAFrom.getText().toString();//converts into local string

        double FromAccountA = Double.parseDouble(AccountAFromString); //assigns proper variable type
        double FromAccountB = Double.parseDouble(AccountBFromString);//assigns proper variable type
        double ToAccountA = Double.parseDouble(AccountAToString);//assigns proper variable type
        double ToAccountB = Double.parseDouble(AccountBToString);//assigns proper variable type

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

        //does the arithmetic on the accounts

        //checks if Account A is being transferred into Account A
        if (FromA && ToA){
            if (Amount >= 2000){
                request_auth();
            }
            else {
                double temp = FromAccountA - Amount;
                double finalAmount = ToAccountA + temp;
                String updated = String.valueOf(finalAmount);
                AccountAFrom.setText(updated);
                AccountATo.setText(updated);
            }
        }

        //checks if Account A is being transferred into Account B
        if (FromA && ToB){
            if (Amount >= 2000){
                request_auth();
            }
            else {
                double temp = FromAccountA - Amount;
                double finalAmount = ToAccountB + temp;
                String updatedUp = String.valueOf(finalAmount); //finalAmount is the new amount
                String updatedDown = String.valueOf(temp); //temp is the subtracted amount
                AccountAFrom.setText(updatedDown);
                AccountBTo.setText(updatedUp);
            }
        }

        //checks if Account B is being transferred into Account A
        if (FromB && ToA){
            if (Amount >= 2000){
                request_auth();
            }
            else {
                double temp = FromAccountB - Amount;
                double finalAmount = ToAccountA + temp;
                String updatedUp = String.valueOf(finalAmount); //finalAmount is the new amount
                String updatedDown = String.valueOf(temp); //temp is the subtracted amount
                AccountBFrom.setText(updatedDown);
                AccountATo.setText(updatedUp);
            }
        }

        //checks if Account B is being transferred into Account B
        if (FromB && ToB){
            if (Amount >= 2000){
                request_auth();
            }
            else {
                double temp = FromAccountA - Amount;
                double finalAmount = ToAccountA + temp;
                String updated = String.valueOf(finalAmount);
                AccountBFrom.setText(updated);
                AccountBTo.setText(updated);
            }
        }
    }

    private boolean request_auth(){
    return true;
    }
}
