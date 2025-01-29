package org.example;

import java.net.URL;

class Knight extends Piece {
    public Knight(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int endX, int startY, int endY, Piece[][] board) {
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);


        if ((deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2)) {
            if (board[startX][startY] != null && board[startX][startY].getColor().equals(this.color)) {
                return board[endX][endY] == null || !board[endX][endY].getColor().equals(this.color);
            }
        }
        return false;
    }

    @Override
    public String getImagePath() {
        String imageName = getColor().equals("white") ? "white_knight.png" : "black_knight.png";

        URL imageUrl = getClass().getClassLoader().getResource("org/example/chessfigures/" + imageName);

        if (imageUrl != null) {
            return imageUrl.toString();
        } else {
            System.err.println("Image not found: " + imageName);
            return null;
        }
    }

}
