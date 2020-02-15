package com.example.log;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = "Main_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(LOG_TAG, "Creating view..");
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "View created!");

        Thread a = new Thread(){
            @Override
            public void run() {
                super.run();
                //showAd();
            }
        };

    }
}
