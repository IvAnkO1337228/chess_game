package org.example;

public class Board {
    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
        initializedBoard();
    }

    private void initializedBoard() {
        // Pawn
        for(int i = 0; i < 8; i++) {
            board[i][1] = new Pawn("white");
            board[i][6] = new Pawn("black");
        }
        //Rook
        board[0][0] = new Rook("white");
        board[7][0] = new Rook("white");
        board[0][7] = new Rook("black");
        board[7][7] = new Rook("black");

        //Bishop
        board[2][0] = new Bishop("white");
        board[5][0] = new Bishop("white");
        board[2][7] = new Bishop("black");
        board[5][7] = new Bishop("black");


        //Knight
        board[1][0] = new Knight("white");
        board[6][0] = new Knight("white");
        board[1][7] = new Knight("black");
        board[6][7] = new Knight("black");

        //Queen
        board[4][0] = new Queen("white");
        board[4][7] = new Queen("black");


        //King
        board[3][0] = new King("white");
        board[3][7] = new King("black");
    }

    public boolean movePiece(int startX, int startY, int endX, int endY) {
        Piece piece = board[startX][startY];
        if (piece != null && piece.isValidMove(startX, endX, startY, endY, board)) {
            board[endX][endY] = piece;
            board[startX][startY] = null;
            return true;
        }
        return false;
    }

    public Piece getPiece(int x, int y) {
        return board[x][y];
    }


}
