package com.renthuby.boobleshooter2d;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.renthuby.boobleshooter2d.game.GameStart;
import com.renthuby.boobleshooter2d.game.GameView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(new GameView(this));
    }
}
