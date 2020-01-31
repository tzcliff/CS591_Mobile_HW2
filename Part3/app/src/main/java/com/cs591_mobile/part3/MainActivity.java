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
