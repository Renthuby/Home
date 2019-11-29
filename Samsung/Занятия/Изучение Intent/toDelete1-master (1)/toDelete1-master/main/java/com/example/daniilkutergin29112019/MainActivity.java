package com.example.daniilkutergin29112019;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Myclick(View view) {
        EditText name = findViewById(R.id.name);
        EditText price = findViewById(R.id.price);
        EditText count = findViewById(R.id.count);
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        i.putExtra("name", name.getText().toString());
        i.putExtra("price", price.getText().toString());
        i.putExtra("count", count.getText().toString());
        startActivity(i);
    }
}
