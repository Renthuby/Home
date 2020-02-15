package com.renthuby.boobleshooter2d.game;

public class Player {

//    FIELDS
    private int x;
    private int y;
    private int r;

    private int speed;
    private int dx;
    private int dy;

    private float tappedX;
    private float tappedY;

//    CONSTRUCTOR
    public Player(){

    }

//    GETTERS & SETTERS

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTappedX(float tappedX) {
        this.tappedX = tappedX;
    }

    public void setTappedY(float tappedY) {
        this.tappedY = tappedY;
    }
}
