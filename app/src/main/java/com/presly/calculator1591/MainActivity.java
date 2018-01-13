package com.presly.calculator1591;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean plus = false, minus = false, multiply = false, divide = false;
    private EditText resultBar;
    private int current_number = 0, stored_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           resultBar = (EditText)findViewById(R.id.resultBar);
           resultBar.setText("");

        //preventing the keyboard from popping up on start:
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void one(View view) {
        if(resultBar != null){
            current_number = (current_number * 10) + 1;
        }
        else {
            current_number = 1;
        }
        resultBar.setText("" + current_number);
        Log.i("tag", "1");
    }

    public void two(View view) {
        if(resultBar != null){
            current_number = (current_number * 10) + 2;
        }
        else {
            current_number = 2;
        }
        resultBar.setText("" + current_number);
        Log.i("tag", "2");
    }

    public void three(View view) {
        if(resultBar != null){
            current_number = (current_number * 10) + 3;
        }
        else {
            current_number = 3;
        }
        resultBar.setText("" + current_number);
        Log.i("tag", "3");
    }

    public void four(View view) {
        if(resultBar != null){
            current_number = (current_number * 10) + 4;
        }
        else {
            current_number = 4;
        }
        resultBar.setText("" + current_number);
        Log.i("tag", "4");
    }

    public void five(View view) {
        if(resultBar != null){
            current_number = (current_number * 10) + 5;
        }
        else {
            current_number = 5;
        }
        resultBar.setText("" + current_number);
        Log.i("tag", "5");
    }

    public void six(View view) {
        if(resultBar != null){
            current_number = (current_number * 10) + 6;
        }
        else {
            current_number = 6;
        }
        resultBar.setText("" + current_number);
        Log.i("tag", "6");
    }


    public void seven(View view) {
        if(resultBar != null){
           current_number = (current_number * 10) + 7;
        }
        else {
            current_number = 7;
        }
        resultBar.setText("" + current_number);
        Log.i("tag", "7");
    }

    public void eight(View view) {
        if(resultBar != null){
            current_number = (current_number * 10) + 8;
        }
        else {
            current_number = 8;
        }
        resultBar.setText("" + current_number);
        Log.i("tag", "8");
    }

    public void nine(View view) {
        if(resultBar != null){
            current_number = (current_number * 10) + 9;
        }
        else {
            current_number = 9;
        }
        resultBar.setText("" + current_number);
        Log.i("tag", "9");
    }

    public void zero(View view) {
        if(resultBar != null){
            current_number = (current_number * 10);
        }
        else {
            current_number = 0;
        }
        resultBar.setText("" + current_number);
        Log.i("tag", "0");
    }



    public void divide(View view) {
        if(current_number != 0){
            stored_number = current_number;
            current_number = 0;
            resultBar.setText("");
            divide = true;
        }
        else {
            Toast.makeText(this,"cant divide by 0", Toast.LENGTH_LONG).show();
        }
        Log.i("tag", "divide");
    }

    public void minus(View view) {
        stored_number = current_number;
        current_number = 0;
        resultBar.setText("");
        minus = true;
        Log.i("tag", "minus");
    }


    public void multiply(View view) {
        stored_number = current_number;
        current_number = 0;
        resultBar.setText("");
        multiply = true;
        Log.i("tag", "multiply");
    }

    public void delete(View view) {
        if(current_number != 0){
            current_number = current_number/10;
            resultBar.setText("" + current_number);
        }
        Log.i("tag", "delete");
    }

    public void plus(View view) {
        stored_number = current_number;
        current_number = 0;
        resultBar.setText("");
        plus = true;
        Log.i("tag", "plus");
    }

    public void equal(View view) {
        if(plus == true){
            current_number = current_number + stored_number;
            resultBar.setText("" + current_number);

        }

        if(multiply == true){
                if (current_number == 0 || stored_number == 0) {
                    Toast.makeText(this, " cant do that with 0...", Toast.LENGTH_LONG).show();
                }
                 else {
                    current_number = stored_number * current_number;
                    resultBar.setText("" + current_number);
                }
            }


        if(divide == true){
            if(current_number ==0 || stored_number == 0){
                Toast.makeText(this, " cant do that with 0...", Toast.LENGTH_LONG).show();
            }
            else {
                current_number = stored_number / current_number;
                resultBar.setText("" + current_number);
            }

        }

        if (minus == true){
            current_number = stored_number - current_number;
            resultBar.setText("" + current_number);

        }

        minus = false;
        divide = false;
        multiply = false;
        plus = false;
    }

   protected void savedInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);

        outstate.putInt("current", current_number);
        outstate.putInt("stored", stored_number);
   }

   protected void onRestoreInstanceState(Bundle savedInstanceState){
       super.onRestoreInstanceState(savedInstanceState);

       current_number = savedInstanceState.getInt("current");
       stored_number = savedInstanceState.getInt("stored");

   }
}
