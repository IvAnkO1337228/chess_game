package org.example;

import java.net.URL;

class King extends Piece{
    public King(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int endX, int startY, int endY, Piece[][] board) {
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);

        if ((deltaX <= 1 && deltaY <= 1) && (deltaX + deltaY > 0)) {
            if (board[endX][endY] == null || !board[endX][endY].getColor().equals(this.color)) {
                return true;
            }
        }
        return false;
    }
    //


    @Override
    public String getImagePath() {
        String imageName = getColor().equals("white") ? "white_king.png" : "black_king.png";

        URL imageUrl = getClass().getClassLoader().getResource("org/example/chessfigures/" + imageName);

        if (imageUrl != null) {
            return imageUrl.toString();
        } else {
            System.err.println("Image not found: " + imageName);
            return null;
        }
    }
}







