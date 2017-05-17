package com.example.dyl59.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void reverseWord(View view) {
// Do something in response to button
        TextView tv = (TextView) findViewById(R.id.edit_message);
        String builder= new StringBuilder(tv.getText()).reverse().toString();
        tv.setText(builder);
    }

    public void clearWord(View view) {
// Do something in response to button
        TextView tv = (TextView) findViewById(R.id.edit_message);
        //String builder= new StringBuilder(tv.getText()).reverse().toString();
        tv.setText("");
    }

}
