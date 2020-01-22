package com.example.kutergin17122019.samsung;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.example.kutergin17122019.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivityStrorage extends AppCompatActivity {
    EditText textbox;
    TextView textView;


    private static String FILE_NAME;
    private static final String MY_LOG = "MY_LOG";

    private boolean permissionGranted;
    private static final int REQEST_PERMISSION_WRITE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage);
        textbox = findViewById(R.id.textbox);
        textView = findViewById(R.id.textOpen);
        FILE_NAME = getIntent().getStringExtra("filename").toLowerCase();
    }

    private File getExternalPath(){
        /*создание файла вне приложения(не временный файл)*/
        return (new File(Environment.getExternalStorageDirectory(), FILE_NAME));
    }

    private String toString(boolean b){
        //переопределяем метод toString, для работы с переменной типа boolean
        if (b) {
            return "true";
        } else {
            return "false";
        }
    }

    public void OnClickSave(View view) {
        Log.d(MY_LOG, "save text...");
        if(!permissionGranted){
            /*проверяем, есть ли у нас разршение на доступ к внешнему хранилищу*/
            Log.d(MY_LOG, "Permission Granted");
            checkPermission();

            String out = toString(checkPermission());
            /*выводим есть ли  нас права*/
            Log.d(MY_LOG, out);
        } else {
            return;
        }

        Log.d(MY_LOG, "text save");
        FileOutputStream fos = null;

        try {
            String text = textbox.getText().toString();
            /*if(getFileStreamPath(FILE_NAME).exists()){
                Toast.makeText(getApplicationContext(), "Файл существует", Toast.LENGTH_SHORT).show();
                fos = openFileOutput(FILE_NAME, MODE_APPEND);
            } else {
                fos = openFileOutput(FILE_NAME,MODE_APPEND);
            }*/

            fos = new FileOutputStream(getExternalPath());
            Log.d(MY_LOG,getExternalPath().toString());


            //fos.write(text.getBytes());

            //String path = getFileStreamPath(FILE_NAME).getAbsoluteFile().getPath();
            long path = getFileStreamPath(fos.toString()/*имя файла*/).lastModified();
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

    private boolean isExternalStorageWritble(){
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    private boolean isExternalStorageReadable(){
        String state = Environment.getExternalStorageState();
        return (Environment.MEDIA_MOUNTED.equals(state)
                || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state));
    }

    private boolean checkPermission() {
        if (!isExternalStorageReadable()||!isExternalStorageWritble()){
            Toast.makeText(getApplicationContext(), "Внешнее хранилище недоступно", Toast.LENGTH_SHORT).show();
            return false;
        }
        int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQEST_PERMISSION_WRITE);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case REQEST_PERMISSION_WRITE:
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    permissionGranted = true;
                    Toast.makeText(getApplicationContext(),
                            "Разрешения получены", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Необходимо дать разрешение", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void OnClickOpen(View view) {
        Log.d(MY_LOG, "open text...");
        if(!permissionGranted){
            /*проверяем, есть ли у нас разршение на доступ к внешнему хранилищу*/
            Log.d(MY_LOG, "Permission Granted");
            checkPermission();

            String out = toString(checkPermission());
            /*выводим есть ли  нас права*/
            Log.d(MY_LOG, out);
        } else {
            return;
        }

        Log.d(MY_LOG, "text open");

        FileInputStream fin = null;
        File file = getExternalPath();
        Log.d(MY_LOG, getExternalPath().toString());

        if (!file.exists()) return;

        try {
            //fin = openFileInput(FILE_NAME);
            fin = new FileInputStream(file);

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
