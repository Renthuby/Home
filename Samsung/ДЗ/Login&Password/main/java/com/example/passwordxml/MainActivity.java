package com.example.passwordxml;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    final String login = "Renthuby";
    final String password = "1234";
    Button button;
    EditText getLogin;
    EditText getPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        getLogin = findViewById(R.id.login);
        getPassword = findViewById(R.id.password);
    }

    public void OntTheClick(View view) {
        if (getLogin.getText().toString().equals("")||getPassword.getText().toString().equals("")){
            //Toast.makeText(this,"start",Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Заполните поля", Toast.LENGTH_SHORT).show();
        } else if (getLogin.getText().toString().equals(login)&&getPassword.getText().toString().equals(password)){
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("username", getLogin.getText().toString());
            startActivity(i);
            finish();
        } else {
            Toast.makeText(this,"Введены неверные данные" , Toast.LENGTH_SHORT).show();
        }
    }
}
