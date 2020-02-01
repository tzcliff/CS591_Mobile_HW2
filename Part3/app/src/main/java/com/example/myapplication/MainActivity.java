package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String MyFlag = "KOBE";  //this will be our trail of breadcrumbs for logging events.
    private static int eventCount = 0;

    private Button btnSayHello;
    private TextView tvMsg;
    private EditText edtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onCreate State Transition");
        setContentView(R.layout.activity_main);

        btnSayHello = (Button)findViewById(R.id.btnSayHello);
        tvMsg = (TextView)findViewById(R.id.tvMsg);
        edtMsg = (EditText)findViewById(R.id.edtMsg);

        btnSayHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvMsg.setText("Hello World.");
                edtMsg.setText("Hello World.");
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onPause State Transition");
    }

    @Override
    protected void onStart() {
        super.onStart();
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onStart State Transition");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onSaveInstanceState State Transition");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onRestoreInstanceState State Transition");
    }

    @Override
    protected void onResume() {
        super.onResume();
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onResume State Transition");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onRestart State Transition");
    }

    @Override
    protected void onStop() {
        super.onStop();
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onStop State Transition");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onDestroy State Transition");
    }

    //Handy Helpers...
    public String intToStr(Integer i)
    {
        Log.i(MyFlag, "converting: " + i.toString());
        return i.toString();
    }

    public int strToInt(String S)
    {
        return Integer.parseInt(S);
    }

}
