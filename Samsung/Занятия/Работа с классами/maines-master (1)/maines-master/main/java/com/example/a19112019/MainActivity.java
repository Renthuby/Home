package com.example.a19112019;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button buttonadd;
    EditText inputAnimal;
    RadioButton radioBird, radioFish;
    Bird bird;
    Fish fish;
    static private final String LOG_TAG = "MY_LOG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "OnCreate ");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "OnCreated.... ");
        Toast.makeText(getApplicationContext(),"OnCreate", Toast.LENGTH_SHORT).show();
        textView = findViewById(R.id.textview);
        buttonadd = findViewById(R.id.buttonadd);
        inputAnimal = findViewById(R.id.inputAnimal);
        radioBird = findViewById(R.id.radiobird);
        radioFish = findViewById(R.id.radiofish);


        buttonadd.setOnClickListener(this);
        textView.setText("");
/*
        textView.setText("");
        Fish fish = new Fish("Карась", 1, false, 0);
        textView.append("\n" + fish + " ");

        Bird bird = new Bird("OpeL", 2, true, 500);
        textView.append("\n" + bird);
        textView.append("\n" + fish.PrintAnimal() + "\n" + bird.PrintAnimal());
*/

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonadd: {
                if (inputAnimal.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Пустая строка",
                            Toast.LENGTH_SHORT).show();

                } else {
                    String[] animals = inputAnimal.getText().toString().split(" ");


                  /*  for (int i = 0; i <animals[0].length()-1; i+=2) {
                        textView.append(animals[0].charAt(i)+""+animals[0].charAt(i+1)+"\n");
                    }*/

                    //textView.setText(animals[0]+" "+animals[1]);
                    if (radioFish.isChecked()) {

                        Log.d(LOG_TAG, "Create Fish  ");
                        Toast.makeText(getApplicationContext(),"Create Fish", Toast.LENGTH_SHORT).show();
                        Fish fish = new Fish(animals[0],
                                Integer.parseInt(animals[1]),
                                Integer.parseInt(animals[2]) > 0 ? true : false,
                                Integer.parseInt(animals[3]));
                        textView.append("\n" + fish);
                        Log.d(LOG_TAG, "Fish Created " + fish);
                        Toast.makeText(getApplicationContext(),"Fish Created " + fish, Toast.LENGTH_SHORT).show();
                    }
                    if (radioBird.isChecked()) {
                        Log.d(LOG_TAG, "Create Bird  ");
                        Toast.makeText(getApplicationContext(),"Create Bird", Toast.LENGTH_SHORT).show();
                        Bird bird = new Bird(animals[0],
                                Integer.parseInt(animals[1]),
                                Integer.parseInt(animals[2]) > 0 ? true : false,
                                Integer.parseInt(animals[3]));
                        textView.append("\n" + bird);
                        Log.d(LOG_TAG, "Bird Created " + bird);
                        Toast.makeText(getApplicationContext(),"Bird Created " + bird, Toast.LENGTH_SHORT).show();
                    }
                    /*textView.setText(matrixToString(createMatrix(Integer.parseInt(animals[0]),
                            Integer.parseInt(animals[1]))));*/
                }

            }
            break;

        }
    }

    public int[][] createMatrix(int n, int m) {
        int[][] array = new int[n][m];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 10);
            }
        }
        return array;
    }

    public String matrixToString(int[][] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result += array[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(LOG_TAG, "onPostResume");
        Toast.makeText(getApplicationContext(),"OnPostResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
        Toast.makeText(getApplicationContext(),"OnStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
        Toast.makeText(getApplicationContext(),"OnStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
        Toast.makeText(getApplicationContext(),"OnDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
        Toast.makeText(getApplicationContext(),"OnPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
        Toast.makeText(getApplicationContext(),"OnResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
        Toast.makeText(getApplicationContext(),"OnRestart", Toast.LENGTH_SHORT).show();
    }
}
