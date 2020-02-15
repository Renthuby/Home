package com.renthuby.boobleshooter2d.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class DrawThread extends Thread {
    public boolean isRunning = true;
    private Player player;
    private Canvas canvas;
    private SurfaceHolder holder;

    public DrawThread(SurfaceHolder holder) {
        this.holder = holder;
    }

    @Override
    public void run() {
        player = new Player();

//        player.setX(canvas.getWidth() / 2);
//        player.setY(canvas.getHeight() / 2);

//        game Loop
        while (isRunning){
            canvas = holder.lockCanvas();
            if (canvas != null) {
                gameUpdate();
                gameRender();
                gameDraw(canvas);
                try{

                } finally {
                    holder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    private void gameUpdate() {

    }

    private void gameRender() {

    }

    private void gameDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRect(0,0,canvas.getWidth(),canvas.getHeight(), paint);
    }

    public void setTappedPoint(float x, float y) {
        player.setTappedX(x);
        player.setTappedY(y);
    }
}
