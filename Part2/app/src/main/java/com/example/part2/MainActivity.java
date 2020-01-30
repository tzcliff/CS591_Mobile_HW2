package com.example.part2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText1;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double cel = Double.valueOf(editText1.getText().toString());
                    double fah = cel * 9 / 5 + 32;
                    editText2.setText(String.valueOf(fah));
                }catch (NumberFormatException e) {
                    AlertDialog alertDialog1 = new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Warning")
                            .setMessage("Please enter a correct number!")
                            .setPositiveButton("Confirm", null)
                            .create();
                    alertDialog1.show();

                    editText1.setText("");
                    editText2.setText("");
                }
            }
        });
    }
}
