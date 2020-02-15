package com.renthuby.boobleshooter2d.game;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    DrawThread drawThread;


    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawThread = new DrawThread(holder);
        drawThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        drawThread.isRunning = false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        drawThread.setTappedPoint((int) event.getX(), (int) event.getY());

        return super.onTouchEvent(event);
    }
}
