package chess2;
/*Erin Tomorri
 *Mrs Katsman
 * ICS4U
 * checks if the piece is valid
 */
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Node;

public class IsValidMove extends PieceVerification {
    int currentRow;
    int currentCol;
    String imageUrl;
    boolean isWhitePiece;
    public boolean isValidMoveCheck(ImageView piece, int rowIndex, int colIndex, GridPane gridPane, boolean whiteTurn) {
        currentRow = GridPane.getRowIndex(piece); //gets the row and col of the piece
        currentCol = GridPane.getColumnIndex(piece);

        imageUrl = piece.getImage().getUrl(); // gets the name of the file 

        isWhitePiece = imageUrl.contains("_White"); // checks if it has white in the file name 

        if (imageUrl.contains("Pawn") && whiteTurn) { //checks if its a pawn and white, if its white you increase the number of rows by one
            return isValidPawnMoveWhite(piece, currentRow, currentCol, rowIndex, colIndex, isWhitePiece, gridPane);
        } else if (imageUrl.contains("Pawn") && !whiteTurn) {//check if its a pawn and black, if its black you decrease the number of rows by one
            return isValidPawnMoveBlack(piece, currentRow, currentCol, rowIndex, colIndex, isWhitePiece, gridPane);
        } else if (imageUrl.contains("Knight")) { // checks if its a knight
            return isValidKnightMove(piece, currentRow, currentCol, rowIndex, colIndex);
        } else if (imageUrl.contains("Bishop")) {// checks if its a bishop
            return isValidBishopMove(piece, currentRow, currentCol, rowIndex, colIndex);
        } else if (imageUrl.contains("Rook")) {// checks if its a rook
            return isValidRookMove(piece, currentRow, currentCol, rowIndex, colIndex);
        } else if (imageUrl.contains("Queen")) {// checks if its a queen
            return isValidQueenMove(piece, currentRow, currentCol, rowIndex, colIndex);
        } else if (imageUrl.contains("King")) {// checks if its a king
            return isValidKingMove(piece, currentRow, currentCol, rowIndex, colIndex);
        }

        return false;
    }
    protected ImageView getImageViewAt(int columnIndex, int rowIndex, GridPane gridPane) { // views the image at a specific col and row 
        for (Node node : gridPane.getChildren()) { //for all the nodes in the grid (32)
            if (GridPane.getColumnIndex(node) == columnIndex && GridPane.getRowIndex(node) == rowIndex) {
                if (node instanceof ImageView) { //gets the image at the node
                    return (ImageView) node;
                }
            }
        }
        return null;
    }
}