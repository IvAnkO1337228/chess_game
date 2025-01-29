package org.example;

import java.net.URL;

class Pawn extends Piece{
    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int endX, int startY, int endY, Piece[][] board) {
        int direction;
        if (color.equals("white")) {
            direction = 1;
        } else {
            direction = -1;
        }

            if (startX == endX) {
                if (isNormalMove(startY, endY, direction, board, endX)) {
                    return true;
                }
                if (isDoubleMove(startX, startY, endY, board, direction)) {
                    return true;
                }
            }

        if (Math.abs(startX - endX) == 1 && (endY - startY == direction)) {
            return isDiagonalAttack(startX, startY, endY, endX, board, direction);
        }

        return false;

    }
    private boolean isNormalMove(int startY, int endY, int direction, Piece board[][], int endX) {
        return (endY - startY == direction) && (board[endX][endY] == null);
    }

    private boolean isDoubleMove(int startX, int startY, int endY, Piece board[][], int direction) {
        return (color.equals("white") && startY == 1 || color.equals("black") && startY == 6) &&
                (endY - startY == 2 * direction) &&
                (board[startX][startY + direction] == null && board[startX][startY + 2 * direction] == null);
    }

    private boolean isDiagonalAttack(int startX, int startY, int endY, int endX, Piece board[][], int direction) {
        return endY >= 0 && endY < 8 && endX >= 0 && endX < 8 &&
                (board[endX][endY] != null && !board[endX][endY].getColor().equals(color) &&
                        (Math.abs(startX - endX) == 1 && (endY - startY == direction)));
    }


    @Override
    public String getImagePath() {
        String imageName = getColor().equals("white") ? "white_pawn.png" : "black_pawn.png";

        URL imageUrl = getClass().getClassLoader().getResource("org/example/chessfigures/" + imageName);

        if (imageUrl != null) {
            return imageUrl.toString();
        } else {

            System.err.println("Image not found: " + imageName);
            return null;
        }
    }
}
