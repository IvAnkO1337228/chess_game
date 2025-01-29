package org.example;

import java.net.URL;

class Bishop extends Piece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int endX, int startY, int endY, Piece[][] board) {
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);

        if (deltaX == deltaY) {
            return isNormalMove(startX, startY, endX, endY, board);
        }

        return false;
    }

    private boolean isNormalMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        int stepX = Integer.compare(endX, startX);
        int stepY = Integer.compare(endY, startY);
        int x = startX + stepX;
        int y = startY + stepY;

        while (x != endX && y != endY) {
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
        String imageName = getColor().equals("white") ? "white_bishop.png" : "black_bishop.png";

        URL imageUrl = getClass().getClassLoader().getResource("org/example/chessfigures/" + imageName);

        if (imageUrl != null) {
            return imageUrl.toString();
        } else {
            System.err.println("Image not found: " + imageName);
            return null;
        }
    }
}
