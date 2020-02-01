package com.cs591_mobile.part4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView et_input;

    private Button button_C;
    private Button button_devide;
    private Button button_times;
    private Button button_del;

    private Button button_seven;
    private Button button_eight;
    private Button button_nine;
    private Button button_minus;

    private Button button_four;
    private Button button_five;
    private Button button_six;
    private Button button_add;

    private Button button_one;
    private Button button_percentage;
    private Button button_two;
    private Button button_zero;
    private Button button_three;
    private Button button_dot;

    private Button button_equal;
    private Button button_sqrt;

    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create components
        et_input = (TextView)findViewById(R.id.et_input);

        button_C = (Button)findViewById(R.id.button_C);
        button_devide = (Button)findViewById(R.id.button_divide);
        button_times = (Button)findViewById(R.id.button_times);
        button_del = (Button)findViewById(R.id.button_del);

        button_seven = (Button)findViewById(R.id.button_seven);
        button_eight = (Button)findViewById(R.id.button_eight);
        button_nine = (Button)findViewById(R.id.button_nine);
        button_minus = (Button)findViewById(R.id.button_minus);

        button_four = (Button)findViewById(R.id.button_four);
        button_five = (Button)findViewById(R.id.button_five);
        button_six = (Button)findViewById(R.id.button_six);
        button_add = (Button)findViewById(R.id.button_add);

        button_one = (Button)findViewById(R.id.button_one);
        button_percentage = (Button)findViewById(R.id.button_percentage);
        button_two = (Button)findViewById(R.id.button_two);
        button_zero = (Button)findViewById(R.id.button_zero);
        button_three = (Button)findViewById(R.id.button_three);
        button_dot = (Button)findViewById(R.id.button_dot);

        button_equal = (Button)findViewById(R.id.button_equal);
        button_sqrt = (Button)findViewById(R.id.button_sqrt);

        calculator = new Calculator();
        reset();
        //bind events
        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
        button_devide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = calculator.calFuction(et_input.getText().toString());
                if (!res.equals("")) et_input.setText(res);
                calculator.setRef(true);
                calculator.setCal(true);
                calculator.setOp(3);
            }
        });
        button_times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = calculator.calFuction(et_input.getText().toString());
                if (!res.equals("")) et_input.setText(res);
                calculator.setRef(true);
                calculator.setCal(true);
                calculator.setOp(2);
            }
        });
        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = calculator.calFuction(et_input.getText().toString());
                if (!res.equals("")) et_input.setText(res);
                calculator.setRef(true);
                calculator.setCal(true);
                calculator.setOp(1);
            }
        });
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = calculator.calFuction(et_input.getText().toString());
                if (!res.equals("")) et_input.setText(res);
                calculator.setRef(true);
                calculator.setCal(true);
                calculator.setOp(0);
            }
        });

        button_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = et_input.getText().toString();
                if (input.length() > 0){
                    input = input.substring(0, input.length()-1);
                    et_input.setText(input);
                }
            }
        });
        button_percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = et_input.getText().toString();
                if (input.length()>0){
                    double opNum = Double.valueOf(input);
                    if (calculator.percenFlag) {
                        opNum /= 100;
                        calculator.setPercenFlag(false);
                    }
                    et_input.setText(String.valueOf(opNum));
                }
            }
        });

        button_sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = et_input.getText().toString();
                if (input.length() > 0) {
                    double op = Double.valueOf(input);
                    et_input.setText(calculator.sqrt(op));
                }
            }
        });

        button_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = calculator.setNum("7", et_input.getText().toString());
                if (!res.equals("")) et_input.setText(res);
            }
        });
        button_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = calculator.setNum("8", et_input.getText().toString());
                if (!res.equals("")) et_input.setText(res);
            }
        });
        button_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = calculator.setNum("9", et_input.getText().toString());
                if (!res.equals("")) et_input.setText(res);
            }
        });
        button_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = calculator.setNum("4", et_input.getText().toString());
                if (!res.equals("")) et_input.setText(res);
            }
        });
        button_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = calculator.setNum("5", et_input.getText().toString());
                if (!res.equals("")) et_input.setText(res);
            }
        });
        button_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = calculator.setNum("6", et_input.getText().toString());
                if (!res.equals("")) et_input.setText(res);
            }
        });
        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = calculator.setNum("1", et_input.getText().toString());
                if (!res.equals("")) et_input.setText(res);
            }
        });
        button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = calculator.setNum("2", et_input.getText().toString());
                if (!res.equals("")) et_input.setText(res);
            }
        });
        button_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = calculator.setNum("3", et_input.getText().toString());
                if (!res.equals("")) et_input.setText(res);
            }
        });
        button_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = calculator.setNum("0", et_input.getText().toString());
                if (!res.equals("")) et_input.setText(res);
            }
        });

        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = calculator.setNum(".", et_input.getText().toString());
                if (!res.equals("")) et_input.setText(res);
            }
        });

        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = calculator.calFuction(et_input.getText().toString());
                if (!res.equals("")) et_input.setText(res);
                calculator.setRef(true);
                calculator.setCal(false);
            }
        });
    }

    private void reset(){
        calculator.clean();
        et_input.setText("0");
    }
}
