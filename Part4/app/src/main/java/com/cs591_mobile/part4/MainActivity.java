package com.cs591_mobile.part4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    private double rst;//last result
    private int op;
    private boolean ref, cal;//if refresh is false, refresh text when input #s
                            //if cal, do calculation when operator pressed

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
                calculate();
                ref = true;
                cal = true;
                op = 3;
            }
        });
        button_times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                ref = true;
                cal = true;
                op = 2;
            }
        });
        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                ref = true;
                cal = true;
                op = 1;
            }
        });
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                ref = true;
                cal = true;
                op = 0;
            }
        });

        button_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = et_input.getText().toString();
                if (input.length()>0){
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
                    et_input.setText(String.valueOf(opNum/100));
                }
            }
        });


        button_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum("7");
            }
        });
        button_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum("8");
            }
        });
        button_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum("9");
            }
        });
        button_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum("4");
            }
        });
        button_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum("5");
            }
        });
        button_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum("6");
            }
        });
        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum("1");
            }
        });
        button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum("2");
            }
        });
        button_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum("3");
            }
        });
        button_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum("0");
            }
        });
        button_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum("0");
            }
        });
        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(".");
            }
        });

        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                ref = true;
                cal = false;
            }
        });
    }

    private void reset(){
        rst = 0;
        op = 0;
        ref = true;
        cal = true;
        et_input.setText("0");
    }
    private void calculate(){
        if (!cal||et_input.getText().length()==0)
            return;
        double opNum = Double.valueOf(et_input.getText().toString());
        switch(op){
            case 0:rst = rst+opNum;break;
            case 1:rst = rst-opNum;break;
            case 2:rst = rst*opNum;break;
            case 3:
                if (opNum == 0){
                    et_input.setText("error");
                    ref = true;
                    return;
                }
                rst = rst/opNum;
                break;
            default:break;
        }
        if (rst == Math.floor(rst)){
            et_input.setText(String.valueOf((long)rst));
        }
        else
            et_input.setText(String.valueOf(rst));
    }
    private void setNum(String num){
        if (ref||
                Double.valueOf(et_input.getText().toString())==0){
            et_input.setText(num);
            ref = false;
            if (!cal) {
                rst = 0;
                op = 0;
                cal = true;
            }
        }
        else{
            String input = et_input.getText().toString();
            et_input.setText(input+num);
        }
    }
}
