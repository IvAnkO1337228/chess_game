package org.example;

import java.net.URL;

class Queen extends Piece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int endX, int startY, int endY, Piece[][] board) {
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);

        if (deltaX == 0 || deltaY == 0 || deltaX == deltaY) {
            return isClear(startX, startY, endX, endY, board);
        }

        return false;
    }

    private boolean isClear(int startX, int startY, int endX, int endY, Piece[][] board) {
        int stepX = Integer.compare(endX, startX);
        int stepY = Integer.compare(endY, startY);
        int x = startX + stepX;
        int y = startY + stepY;

        while (x != endX || y != endY) {
            if (board[x][y] != null) {
                return false;
            }
            x += stepX;
            y += stepY;
        }

        if (board[endX][endY] != null && board[endX][endY].getColor().equals(this.color)) {
            return false;
        }

        return true;
    }

    @Override
    public String getImagePath() {
        String imageName = getColor().equals("white") ? "white_queen.png" : "black_queen.png";

        URL imageUrl = getClass().getClassLoader().getResource("org/example/chessfigures/" + imageName);

        if (imageUrl != null) {
            return imageUrl.toString();
        } else {

            System.err.println("Image not found: " + imageName);
            return null;
        }
    }

}