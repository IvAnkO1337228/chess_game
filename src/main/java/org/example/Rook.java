package org.example;

import java.net.URL;

class Rook extends Piece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int endX, int startY, int endY, Piece[][] board) {
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);

            if(deltaX == 0 || deltaY == 0) {
                if (isClear(endX, startX, startY, endY, board)) {
                    return board[endX][endY] == null ||
                            !board[endX][endY].getColor().equals(this.color);
                }
            }
        return false;
    }

    private boolean isClear(int endX, int startX, int startY, int endY, Piece board[][]) {
        int stepX = Integer.compare(endX, startX);
        int stepY = Integer.compare(endY, startY);

        int x = stepX + startX;
        int y = stepY + startY;

        while(x != endX || y != endY) {
            if(board[x][y] != null) {
                return false;
            } else {
                x += stepX;
                y += stepY;
            }
        }
        return true;
    }


    @Override
    public String getImagePath() {
        String imageName = getColor().equals("white") ? "white_rook.png" : "black_rook.png";

        URL imageUrl = getClass().getClassLoader().getResource("org/example/chessfigures/" + imageName);

        if (imageUrl != null) {
            return imageUrl.toString();
        } else {

            System.err.println("Image not found: " + imageName);
            return null;
        }
    }

}
