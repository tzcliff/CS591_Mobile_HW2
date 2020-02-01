package com.example.addition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button addButton;
    RandomGenerator randomGenerator;
    TextView num1_txt;
    TextView num2_txt;
    TextView res_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = (Button)findViewById(R.id.add_button);
        randomGenerator = new RandomGenerator();

        int num1 = randomGenerator.generate(10, 1);
        int num2 = randomGenerator.generate(10, 1);
        int num3 = 3;

        num1_txt = (TextView)findViewById(R.id.num1_txtView);
        num2_txt = (TextView)findViewById(R.id.num2_txtView);
        res_txt = (TextView)findViewById(R.id.res_txtView);

        num1_txt.setText(String.valueOf(num1));
        num2_txt.setText(String.valueOf(num2));

        /*addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1 = Integer.parseInt(num1_txt.getText().toString());
                int n2 = Integer.parseInt(num2_txt.getText().toString());

                int res = n1 + n2;
                res_txt.setText(res);
            }
        });*/
    }


}