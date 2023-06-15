/*Erin Tomorri
 *Mrs Katsman
 * ICS4U
 * This is a game of chess that incorporates my own rules 
 */

package chess2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ICS4U_FP extends Application {

    public static void main(String[] args) {
        intro(); // displays the introduction
        clearFile(); // clears the moves txt
        launch(args); // runs the code
        System.out.println("Bye"); // bye
    }
    private static final int boardSize = 8; // amount of squares
    private static final int tileSize = 60; // amount of pixles per square 60x60
    private ImageView selectedPiece; 
    private boolean whiteTurn = true; // Track the current player turn
    int[][] arr = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 0, 5 }, { 0, 6 }, { 0, 7 }, { 1, 0 }, { 1, 1 },
            { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 1, 6 }, { 1, 7 }, { 6, 0 }, { 6, 1 }, { 6, 2 }, { 6, 3 },
            { 6, 4 }, { 6, 5 }, { 6, 6 }, { 6, 7 }, { 7, 0 }, { 7, 1 }, { 7, 2 }, { 7, 3 }, { 7, 4 }, { 7, 5 },
            { 7, 6 }, { 7, 7 } };
    ImageView[] images = new ImageView[32]; // arr of images this may help me determine the logic behind capturing pieces
    int count = 0;

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        StackedList linkStack = new StackedList(); //I used this linked stack but idk why it showing that its not in use 
        for (int row = 0; row < boardSize; row++) { // 8 rows
            for (int col = 0; col < boardSize; col++) { //8 cols
                Rectangle rectangle = new Rectangle(tileSize, tileSize); //creates a square 60X60 pixels wide

                if ((row + col) % 2 == 0) {
                    rectangle.setFill(Color.WHITE); // for every two pieces it colours one white and one black 
                } else {
                    rectangle.setFill(Color.GRAY);
                }

                gridPane.add(rectangle, col, row); // creates a grid of pieces 
            }
        }
        // Add piece images to the board these need to be the exact path, I tried using a shorter path that is realtive to this file but it didnt work
        Piece chess = new Piece();
        // The pieces below are being added to the board in their respective grids
        ImageView w_pawn = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Pawn_White.png", arr[8][0], arr[8][1], tileSize);  // Example piece
        ImageView w_pawn1 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Pawn_White.png", arr[9][0], arr[9][1], tileSize);  // Example piece
        ImageView w_pawn2 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Pawn_White.png", arr[10][0], arr[10][1], tileSize);  // Example piece
        ImageView w_pawn3 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Pawn_White.png", arr[11][0], arr[11][1], tileSize);  // Example piece
        ImageView w_pawn4 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Pawn_White.png", arr[12][0], arr[12][1], tileSize);  // Example piece
        ImageView w_pawn5 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Pawn_White.png", arr[13][0], arr[13][1], tileSize);  // Example piece
        ImageView w_pawn6 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Pawn_White.png", arr[14][0], arr[14][1], tileSize);  // Example piece
        ImageView w_pawn7 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Pawn_White.png", arr[15][0], arr[15][1], tileSize);  // Example piece
        ImageView b_pawn = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Pawn_Black.png", arr[16][0], arr[16][1], tileSize);  // Example piece
        ImageView b_pawn1 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Pawn_Black.png", arr[17][0], arr[17][1], tileSize);  // Example piece
        ImageView b_pawn2 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Pawn_Black.png", arr[18][0], arr[18][1], tileSize);  // Example piece
        ImageView b_pawn3 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Pawn_Black.png", arr[19][0], arr[19][1], tileSize);  // Example piece
        ImageView b_pawn4 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Pawn_Black.png", arr[20][0], arr[20][1], tileSize);  // Example piece
        ImageView b_pawn5 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Pawn_Black.png", arr[21][0], arr[21][1], tileSize);  // Example piece
        ImageView b_pawn6 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Pawn_Black.png", arr[22][0], arr[22][1], tileSize);  // Example piece
        ImageView b_pawn7 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Pawn_Black.png", arr[23][0], arr[23][1], tileSize);  // Example piece
        ImageView w_knight = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Knight_White.png", arr[1][0], arr[1][1], tileSize);  // Example piece
        ImageView w_knight1 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Knight_White.png", arr[6][0], arr[6][1], tileSize);  // Example piece
        ImageView b_knight = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Knight_Black.png", arr[25][0], arr[25][1], tileSize);  // Example piece
        ImageView b_knight1 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Knight_Black.png", arr[30][0], arr[30][1], tileSize);  // Example piece
        ImageView w_rook = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Rook_White.png", arr[0][0], arr[0][1], tileSize);  // Example piece
        ImageView w_rook1 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Rook_White.png", arr[7][0], arr[7][1], tileSize);  // Example piece
        ImageView b_rook = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Rook_Black.png", arr[24][0], arr[24][1], tileSize);  // Example piece
        ImageView b_rook1 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Rook_Black.png", arr[31][0], arr[31][1], tileSize);  // Example piece
        ImageView w_bishop = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Bishop_White.png", arr[2][0], arr[2][1], tileSize);  // Example piece
        ImageView w_bishop1 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Bishop_White.png", arr[5][0], arr[5][1], tileSize);  // Example piece
        ImageView b_bishop = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Bishop_Black.png", arr[26][0], arr[26][1], tileSize);  // Example piece
        ImageView b_bishop1 = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Bishop_Black.png", arr[29][0], arr[29][1], tileSize);  // Example piece
        ImageView w_queen= chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Queen_White.png", arr[4][0], arr[4][1], tileSize);  // Example piece
        ImageView w_king = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\King_White.png", arr[3][0], arr[3][1], tileSize);  // Example piece
        ImageView b_queen = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\Queen_Black.png", arr[28][0], arr[28][1], tileSize);  // Example piece
        ImageView b_king = chess.addPiece(gridPane, "file:C:\\Users\\etomo\\OneDrive\\Desktop\\Chess\\demo\\src\\main\\java\\chess2\\Pieces\\\\King_Black.png", arr[27][0], arr[27][1], tileSize);  // Example piece
        
        ImageView[] images = { w_pawn, w_pawn1, w_pawn2, w_pawn3, w_pawn4, w_pawn5, w_pawn6, w_pawn7, b_pawn,
                b_pawn1, b_pawn2, b_pawn3, b_pawn4, b_pawn5, b_pawn6, b_pawn7, w_knight, w_knight1, b_knight, b_knight1,
                w_rook, w_rook1, b_rook, b_rook1, w_bishop1, w_bishop, b_bishop, b_bishop1, w_queen, w_king, b_queen,
                b_king }; // contains all the images of the pieces
        
    //this makes the pieces moveable 
    enableDragAndDrop(w_pawn, gridPane);
    enableDragAndDrop(w_pawn1, gridPane);
    enableDragAndDrop(w_pawn2, gridPane);
    enableDragAndDrop(w_pawn3, gridPane);
    enableDragAndDrop(w_pawn4, gridPane);
    enableDragAndDrop(w_pawn5, gridPane);
    enableDragAndDrop(w_pawn6, gridPane);
    enableDragAndDrop(w_pawn7, gridPane);
    enableDragAndDrop(b_pawn, gridPane);
    enableDragAndDrop(b_pawn1, gridPane);
    enableDragAndDrop(b_pawn2, gridPane);
    enableDragAndDrop(b_pawn3, gridPane);
    enableDragAndDrop(b_pawn4, gridPane);
    enableDragAndDrop(b_pawn5, gridPane);
    enableDragAndDrop(b_pawn6, gridPane);
    enableDragAndDrop(b_pawn7, gridPane);
    enableDragAndDrop(w_knight, gridPane);
    enableDragAndDrop(w_knight1, gridPane);
    enableDragAndDrop(b_knight, gridPane);
    enableDragAndDrop(b_knight1, gridPane);
    enableDragAndDrop(w_bishop, gridPane);
    enableDragAndDrop(w_bishop1, gridPane);
    enableDragAndDrop(b_bishop, gridPane);
    enableDragAndDrop(b_bishop1, gridPane);
    enableDragAndDrop(w_rook, gridPane);
    enableDragAndDrop(w_rook1, gridPane);
    enableDragAndDrop(b_rook, gridPane);
    enableDragAndDrop(b_rook1, gridPane);
    enableDragAndDrop(b_king, gridPane);
    enableDragAndDrop(w_king, gridPane);
    enableDragAndDrop(b_queen, gridPane);
    enableDragAndDrop(w_queen, gridPane);

    Group root = new Group(gridPane);
    Scene scene = new Scene(root, boardSize * tileSize, boardSize * tileSize);
    //creates the chessboard
    primaryStage.setTitle("Chessboard");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
}


public boolean recursion(int row, int col, int c) { //recursivly searchs for a col and row that equals to c this will help determine if the piece is being captured
    if (arr[row][col] == c) { // base case checks if its O(1) in the recursive search
        return true;
    } else {
        if (col + 1 < arr[0].length) { // checks if col is more than the arr len of 0
            recursion(row, col + 1, c);
        } else if (row + 1 < arr[1].length) {// checks if col is more than the arr len of 1
            recursion(row + 1, 0, c);
        } else {
            return false; //not in the list, not possible case but we need one just in case
            // System.out.print(arry[0][1]);
        }
    }
    return false;
}

private void enableDragAndDrop(ImageView piece, GridPane gridPane) { // does the dragging and dropping of the pieces
    piece.setOnDragDetected(event -> {
        if ((whiteTurn && piece.getImage().getUrl().contains("_White")) //check if the turn is white or black and also checks if the piece has white or black in the URL to the image
                || (!whiteTurn && piece.getImage().getUrl().contains("_Black"))) {
            Dragboard db = piece.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(""); //sets the image to the clip board and we use that clipboard for our dragging
            db.setContent(content);
            selectedPiece = piece;
        }
    });

    for (Node node : gridPane.getChildren()) { // checks nodes (images) for ever instance of the children in the grid pane (runs 32 times basically)
        if (node instanceof Rectangle) { //check if the node is a rectangle and then if it is a rectangle it will highlight it green
            Rectangle tile = (Rectangle) node;
            tile.setOnDragOver(event -> {
                event.acceptTransferModes(TransferMode.MOVE); //you are now able to transfer the piece horray
            });

            tile.setOnDragEntered(event -> {
                if (selectedPiece != null) {
                    tile.setFill(Color.GREEN); //highlights the square green 
                }
            });

            tile.setOnDragExited(event -> {
                if (selectedPiece != null) {
                    if ((gridPane.getRowIndex(tile) + gridPane.getColumnIndex(tile)) % 2 == 0) {
                        tile.setFill(Color.WHITE); // if the square is divisble by 2 then fill with white
                    } else {
                        tile.setFill(Color.GRAY); //fill with black if it isnt
                    }
                }
            });

            tile.setOnDragDropped(event -> { //drops the piece in its new spot
                if (selectedPiece != null) {
                    int rowIndex = gridPane.getRowIndex(tile); //life saving feature is the getrowindex and getcolindex
                    int colIndex = gridPane.getColumnIndex(tile); // this will get the row and col of the piece that you have dragged

                    IsValidMove isValidMove = new IsValidMove(); //calls the valid object
                    boolean valid = isValidMove.isValidMoveCheck(selectedPiece, rowIndex, colIndex, gridPane,whiteTurn);//check if a move is valid
                    ImageView targetNode = isValidMove.getImageViewAt(colIndex, rowIndex, gridPane); //this is only important for when a pawn captures diagonally
                    ImageView image = ((ImageView) targetNode); // baically checks if the pawn is able to capture diagonally by seeing if the square has an image or not

                    if (valid == true) {
                        gridPane.getChildren().remove(selectedPiece); // remove the piece you have in your hand
                        gridPane.getChildren().remove(image); // remove the piece that you are moving to
                        gridPane.add(selectedPiece, colIndex, rowIndex); // adds the piece to the new square

                        selectedPiece = null;
                        count++;
                        writeRowAndColumnToFile(rowIndex, colIndex); // writes the move to a new file
                        //readAndWrite(rowIndex, colIndex, count);
                        checkmateOrSwitchTurn(gridPane); //switches to the other colour

                    }
                }
            });
        }
    }
}

    private void checkmateOrSwitchTurn(GridPane gridPane) {
        whiteTurn = !whiteTurn; //switchs to the other colour
    }
    private void writeRowAndColumnToFile(int sourceRow, int sourceCol) { // writes the col and row of the moved piece
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("demo\\src\\main\\java\\chess2\\text\\moves.txt", true))) {
            // Append the row and column information to the file
            writer.write("Row " + sourceRow + ", Column " + sourceCol);
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void clearFile(){ //clears the file of the moves so it starts fresh 
            String filePath = "demo\\src\\main\\java\\chess2\\text\\moves.txt"; 
            
            try {
                FileWriter fileWriter = new FileWriter(filePath);
                fileWriter.write(""); // Write an empty string to clear the file
                fileWriter.close();
                
                System.out.println("File cleared successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    private static void readAndWrite(int row, int col, int content){ //this is used to sort the data within the moves file 
        String filePath = "demo\\src\\main\\java\\chess2\\text\\moves.txt";
        StackedList stack = new StackedList();
        stack.push(row);
        stack.push(col);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stack.sort();
            }
        } catch (IOException e) {
            System.err.println("esdf");
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.err.println("An error occurred while writing the file: " + e.getMessage());
        }
    }
    private static void intro(){ // print the intro from the intro txt 
        String filePath = "demo\\src\\main\\java\\chess2\\text\\intro.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("yrdy");
            e.printStackTrace();
        }
    }
}

