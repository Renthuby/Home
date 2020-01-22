package com.example.cal;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button btnP, btnM, btnU, btnD;
    TextView answer;
    EditText arg1, arg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnD = (Button) findViewById(R.id.devide);
        btnU = (Button) findViewById(R.id.mul);
        btnM = (Button) findViewById(R.id.subtr);
        btnP = (Button) findViewById(R.id.add);

        answer = (TextView) findViewById(R.id.answer);

        arg1 = (EditText) findViewById(R.id.arg1);
        arg2 = (EditText) findViewById(R.id.arg2);
    }

    public void AddNumbers(View view) {
        try {
            int a = Integer.parseInt(arg1.getText().toString());
            int b = Integer.parseInt(arg2.getText().toString());
            answer.setText("\t" + (a+b));
        } catch (IllegalArgumentException e) {
            answer.setText("Input Error");
        } catch (ArithmeticException e) {
            answer.setText("Div by zero");
        }

    }

    public void Vichitanie(View view) {
        try {
            int a = Integer.parseInt(arg1.getText().toString());
            int b = Integer.parseInt(arg2.getText().toString());
            answer.setText("\t" + (a-b));
        } catch (IllegalArgumentException e) {
            answer.setText("Input Error");
        } catch (ArithmeticException e) {
            answer.setText("Div by zero");
        }
    }

    public void Umnogenie(View view) {
        try {
            int a = Integer.parseInt(arg1.getText().toString());
            int b = Integer.parseInt(arg2.getText().toString());
            answer.setText("\t" + (a*b));
        } catch (IllegalArgumentException e) {
            answer.setText("Input Error");
        } catch (ArithmeticException e) {
            answer.setText("Div by zero");
        }
    }

    public void Delenie(View view) {
        try {
            int a = Integer.parseInt(arg1.getText().toString());
            int b = Integer.parseInt(arg2.getText().toString());
            answer.setText("\t" + (a/b));
        } catch (IllegalArgumentException e) {
            answer.setText("Input Error");
        } catch (ArithmeticException e) {
            answer.setText("Div by zero");
        }
    }
}
