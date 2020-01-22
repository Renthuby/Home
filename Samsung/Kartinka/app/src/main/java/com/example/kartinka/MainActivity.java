package com.example.kartinka;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.cartinka);
    }

    public void Download(View view) throws IOException {
        Toast.makeText(this, "Кнопка нажата", Toast.LENGTH_SHORT).show();
        try{
        URL url = new URL("http://yandex.ru/collections/card/5d5ffc7355379897c3defafe/?boardId=5b421412e0149a4ff0f203fe");
        Thread InputStream = (Thread) url.getContent();
        InputStream.start();
        Canvas canvas = new Canvas(BitmapFactory.decodeStream(InputStream));
        a.draw(canvas);
        }
        catch (RuntimeException e) {
            Toast.makeText(this, e.getMessage() + "пизда", Toast.LENGTH_SHORT).show();
        }


//        BitmapFactory.decodeStream((InputStream) url.getContent());
    }
}
