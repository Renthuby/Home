package com.example.kutergin17122019.samsung;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.kutergin17122019.R;

public class MainActivity extends AppCompatActivity {
    EditText nameperson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameperson = findViewById(R.id.inputname);

    }

    public void InGame(View view) {

        String name = nameperson.getText().toString();
        String[] ar = name.split(" ");
        try {
            nameperson.setText("" + (Integer.parseInt(ar[0]) / Integer.parseInt(ar[1])));
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Деление на 0", Toast.LENGTH_SHORT).show();
            System.err.println("ArithmeticException");
            System.err.println(e.toString());
        }
        /*Intent intent = new Intent(MainActivity.this, Game.class);
        intent.putExtra("inputname", name);
        startActivity(intent);*/

    }

    public void InFile(View view) {
        String name = nameperson.getText().toString();
        Intent intent = new Intent(MainActivity.this, FileActivity.class);
        intent.putExtra("filename", name);
        startActivity(intent);
    }

    public void InFileStorage(View view) {
        String name = nameperson.getText().toString();
        Intent intent = new Intent(MainActivity.this, FileActivityStrorage.class);
        intent.putExtra("filename", name);
        startActivity(intent);
    }
}
