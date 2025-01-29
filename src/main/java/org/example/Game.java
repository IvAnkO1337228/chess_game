package org.example;

import java.util.Scanner;

class Game {
    private Board board;
    private String currentPlayer;

    public Game() {
        board = new Board();
        currentPlayer = "white";
    }

    public boolean makeMove(int startX, int startY, int endX, int endY) {
        if (board.movePiece(startX, startY, endX, endY)) {
            currentPlayer = currentPlayer.equals("white") ? "black" : "white";
            return true;
        }
        return false;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }
}


//public class Game {
//    private ChessBoard board;
//    private String currentPlayer;
//
//    public Game() {
//        board = new ChessBoard();
//        currentPlayer = "white";
//    }
//
//    public void makeMove(int startX, int endX, int startY, int endY) {
//        if(board.movePiece(startX, startY, endX, endY)) {
//            currentPlayer = currentPlayer.equals("white") ? "black" : "white";
//        }
//    }
//
//    public void displayBoard() {
//        board.printBoard();
//    }

//}
