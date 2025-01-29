package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChessBoard extends Application {
    private Button[][] buttons = new Button[8][8];
    private Game game;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        game = new Game();
        GridPane grid = new GridPane();

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Button button = new Button();
                buttons[x][y] = button;
                button.setPrefSize(100, 100);

                if ((x + y) % 2 == 0) {
                    button.setStyle("-fx-background-color: white;");
                } else {
                    button.setStyle("-fx-background-color: black;");
                }

                updateButton(x, y);

                final int finalX = x;
                final int finalY = y;

                button.setOnAction(e -> handleButtonClick(finalX, finalY));
                grid.add(button, x, y);
            }
        }

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chess Game");
        primaryStage.show();
    }

    private void updateButton(int x, int y) {
        Piece piece = game.getBoard().getPiece(x, y);
        if (piece != null) {
            ImageView imageView = new ImageView(new Image(piece.getImagePath()));
            imageView.setFitWidth(60);
            imageView.setFitHeight(60);
            buttons[x][y].setGraphic(imageView);
        } else {
            buttons[x][y].setGraphic(null);
        }
    }

    private Piece selectedPiece = null;
    private int selectedX = -1;
    private int selectedY = -1;

    private void handleButtonClick(int x, int y) {
        if (selectedPiece == null) {
            selectedPiece = game.getBoard().getPiece(x, y);
            if (selectedPiece != null && selectedPiece.getColor().equals(game.getCurrentPlayer())) {
                selectedX = x;
                selectedY = y;
            }
        } else {
            if (game.makeMove(selectedX, selectedY, x, y)) {
                selectedPiece = null;
            } else {
                selectedPiece = null;
            }
        }
        updateBoard();
    }

    private void updateBoard() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                updateButton(x, y);
            }
        }
    }
}
