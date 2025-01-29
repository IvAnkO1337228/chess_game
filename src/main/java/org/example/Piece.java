package org.example;

abstract class Piece {
    protected String color;
    protected int x;
    protected int y;


    public Piece(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public abstract boolean isValidMove(int startX, int endX, int startY, int endY, Piece[][] board);

    public abstract String getImagePath();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
