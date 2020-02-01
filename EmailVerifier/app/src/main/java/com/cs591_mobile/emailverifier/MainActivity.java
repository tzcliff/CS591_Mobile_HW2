package com.cs591_mobile.emailverifier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt_output;
    EditText txt_input;
    Button btn_check;
    EmailChecker emailChecker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailChecker = new EmailChecker();
        txt_output = findViewById(R.id.txt_output);
        txt_input = findViewById(R.id.txt_input);
        btn_check = findViewById(R.id.btn_check);

        btn_check.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String email = txt_input.getText().toString();
                if(emailChecker.checkEmail(email)){
                    txt_output.setText("VALID");
                }
                else{
                    txt_output.setText("INVALID");
                }
            }
        });
    }
}
