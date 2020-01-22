package com.example.kutergin17122019.samsung;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.kutergin17122019.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {
EditText textbox;
TextView textView;
    private static String FILE_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        textbox = findViewById(R.id.textbox);
        textView = findViewById(R.id.textOpen);
        FILE_NAME = getIntent().getStringExtra("filename").toLowerCase();
    }

    public void OnClickSave(View view) {
        FileOutputStream fos = null;
        try {
            String text = textbox.getText().toString();
            if(getFileStreamPath(FILE_NAME).exists()){
                Toast.makeText(getApplicationContext(), "Файл существует", Toast.LENGTH_SHORT).show();
                fos = openFileOutput(FILE_NAME, MODE_APPEND);
            } else {
                fos = openFileOutput(FILE_NAME,MODE_APPEND);
            }


            //fos.write(text.getBytes());

            //String path = getFileStreamPath(FILE_NAME).getAbsoluteFile().getPath();
            long path = getFileStreamPath(FILE_NAME).lastModified();
            fos.write((text + "   -->     " + path/(3_600_000)/24/365.25).getBytes());

            Toast.makeText(getApplicationContext(), "Файл записан", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();

            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void OnClickOpen(View view) {
        FileInputStream fin = null;
        try {
            fin = openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            textView.setText(text);
        }
        catch (IOException e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally {
            if(fin!=null){
                try {
                    fin.close();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
