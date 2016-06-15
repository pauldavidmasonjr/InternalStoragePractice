package com.example.paul_.inclassstoragepractice;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //load the number from memory
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        //pull number from memory
        number = settings.getInt(SAVED_INT, 0);

        //call update view function
        updateView();
    }
    //member variables
    private int number;
    public static final String PREFS_NAME = "MyPrefsFile";
    public static final String SAVED_INT = "savedInt";

    void increment(View view){
        //pull number from storage
        number ++;

        //update the view
        updateView();
    }

    void save(View view){
        //save number to the internal storage
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(SAVED_INT, number);

        editor.commit();
    }

    void updateView(){
        //set up text view box
        TextView textview = (TextView) findViewById(R.id.textView);

        //place into text View
        textview.setText(Integer.toString(number));
    }
}
