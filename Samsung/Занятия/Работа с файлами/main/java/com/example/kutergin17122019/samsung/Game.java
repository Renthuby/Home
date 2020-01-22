package com.example.kutergin17122019.samsung;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.kutergin17122019.R;


public class Game extends AppCompatActivity implements View.OnClickListener {
    Button[] buttons = new Button[3];
    TextView textstory, textview;
    public static Character manager;
    public static Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        textstory = findViewById(R.id.textstory);
        textview = findViewById(R.id.textView);
        buttons[0] = findViewById(R.id.btn1);
        buttons[1] = findViewById(R.id.btn2);
        buttons[2] = findViewById(R.id.btn3);
        for (Button b : buttons) {
            b.setOnClickListener(this);
        }
        textview.setText("Вы прошли собеседование и вот-вот станете сотрудником Корпорации. \n "
                + "Осталось уладить формальности - подпись под договором (Введите ваше имя):");
       String[] array = getIntent().getStringExtra("inputname").split(" ");

        manager = new Character(array[0], Integer.parseInt(array[1]),Integer.parseInt(array[2]),
                Integer.parseInt(array[3]));


    }



    @Override
    public void onClick(View v) {
        story = new Story();
        switch (v.getId()) {
            case R.id.btn1:
                GameStory(story, 1);
                break;
            case R.id.btn2:
                GameStory(story, 2);
                break;
            case R.id.btn3:
                GameStory(story, 3);
                break;
        }

    }

    private void GameStory(Story story, int i) {
        while (true) {
            manager.A += story.current_situation.dA;
            manager.K += story.current_situation.dK;
            manager.R += story.current_situation.dR;
            textview.setText(manager.name + "\nКарьера:" + manager.K + "\tАктивы:"
                    + manager.A + "\tРепутация: " + manager.R + "\n=====");
            textstory.setText("============="
                    + story.current_situation.subject + "==============");
            textstory.append("\n" + story.current_situation.text);
            if (story.isEnd()) {
                //System.out.println("====================the end!===================");
                return;
            }
            story.go(i);
        }


    }
}
