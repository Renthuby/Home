package com.example.daniilkutergin29112019;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    Button button;
    TextView tvsecond;
    String name;
    int price;
    int count;
    int c = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvsecond = findViewById(R.id.tvsecond);
        name = getIntent().getStringExtra("name");
        price = Integer.parseInt(getIntent().getStringExtra("price"));
        count = Integer.parseInt(getIntent().getStringExtra("count"));
        tvsecond.setText( "name: " + name + "\nprice: " + price + "\ncount: " + count);

    }

    public void MyClickNext(View view) {
        c++;
        if(c==2){
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
        }
        if(name.equals("&")) {//побитовое умножение
            tvsecond.append("\n " + Integer.toBinaryString(price) +
                    "\n "  + Integer.toBinaryString(count) +
                    "\n " + Integer.toBinaryString(price&count));
        }
        if(name.equals("^")) {//побитовое исключающее или
            tvsecond.append("\n " + Integer.toBinaryString(price) +
                    "\n "  + Integer.toBinaryString(count) +
                    "\n " + Integer.toBinaryString(price^count));
        }
        if(name.equals("|")) {//побитовое или
            tvsecond.append("\n " + Integer.toBinaryString(price) +
                    "\n "  + Integer.toBinaryString(count) +
                    "\n " + Integer.toBinaryString(price|count));
        }
        if(name.equals("<<")) {//побиовый сдвиг влево
            tvsecond.append("\n " + Integer.toBinaryString(price) +
                    "\n "  + Integer.toBinaryString(count) +
                    "\n " + Integer.toBinaryString(price<<count));
        }
        if(name.equals(">>")) {//побиовый сдвиг вправо
            tvsecond.append("\n " + Integer.toBinaryString(price) +
                    "\n "  + Integer.toBinaryString(count) +
                    "\n " + Integer.toBinaryString(price>>count));
        }

    }
}
