package chess2;
/*Erin Tomorri
 *Mrs Katsman
 * ICS4U
 * checks if the logic of the pieces are valid and if it has valid rules
 */
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import javafx.scene.Node;
public class PieceVerification {
        protected boolean isValidPawnMoveBlack(ImageView pawn, int currentRow, int currentCol, int newRow, int newCol, // this will check the possible moves for a pawn
                                        boolean isWhitePiece, GridPane gridPane) {
        ImageView targetNode = getImageViewAt(newRow, newCol, gridPane);
        ImageView image = ((ImageView) targetNode);

        int forwardStep = -1;
        if (Math.abs(currentCol - newCol) == 1 && currentRow + forwardStep == newRow && image != null) { // captures diagonally, checks if there is an image on the diagonally and finds if its on the edge or not
            return true;
        }

        if (currentCol == newCol && currentRow + forwardStep == newRow && image == null) {
            return true;
        } // checks if its at the ends (i.e. row 0, row 8)

        int startingRow = 6;
        if (currentCol == newCol && currentRow + forwardStep * 2 == newRow && currentRow == startingRow) {
            return true; //checks if its in the starting position of row 6 (0-7)
        }

        return false;
    }

    protected boolean isValidPawnMoveWhite(ImageView pawn, int currentRow, int currentCol, int newRow, int newCol,
                                        boolean isWhitePiece, GridPane gridPane) { // check for valid white pawn moves
        int forwardStep = 1;
        ImageView targetNode = getImageViewAt(newRow, newCol, gridPane);
        ImageView image = ((ImageView) targetNode);

        if (Math.abs(currentCol - newCol) == 1 && currentRow + forwardStep == newRow && image != null) {
            return true;// captures diagonally, checks if there is an image on the diagonally and finds if its on the edge or not
        }

        if (currentCol == newCol && currentRow + forwardStep == newRow && image == null) {
            return true;// checks if its at the ends (i.e. row 0, row 8)
        }

        int startingRow = 1;
        if (currentCol == newCol && currentRow + forwardStep * 2 == newRow && currentRow == startingRow) {
            return true;//checks if its in the starting position of row 6 (0-7)
        }

        return false;
    }

    protected boolean isValidKnightMove(ImageView knight, int currentRow, int currentCol, int newRow, int newCol) {
        int rowDiff = Math.abs(newRow - currentRow);
        int colDiff = Math.abs(newCol - currentCol);

        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2); //I couldnt figure this math out so I copied it, just checks if it has viable L shape moves
    }

    protected boolean isValidBishopMove(ImageView bishop, int currentRow, int currentCol, int newRow, int newCol) {
        int rowDiff = Math.abs(newRow - currentRow);
        int colDiff = Math.abs(newCol - currentCol);

        return rowDiff == colDiff;//checks if its in the diagonal 
    }

    protected boolean isValidRookMove(ImageView rook, int currentRow, int currentCol, int newRow, int newCol) {
        return currentRow == newRow || currentCol == newCol;// check if its in the horizontal or vertical 
    }

    protected boolean isValidQueenMove(ImageView queen, int currentRow, int currentCol, int newRow, int newCol) {
        return isValidBishopMove(queen, currentRow, currentCol, newRow, newCol)
                || isValidRookMove(queen, currentRow, currentCol, newRow, newCol); // a queen is a combination of a rook and bishop so you can combine the two to check if a move is valid
    }

    protected boolean isValidKingMove(ImageView king, int currentRow, int currentCol, int newRow, int newCol) {
        int rowDiff = Math.abs(newRow - currentRow);
        int colDiff = Math.abs(newCol - currentCol);

        return rowDiff <= 1 && colDiff <= 1; // checks if the move is one block away
    }

    protected ImageView getImageViewAt(int columnIndex, int rowIndex, GridPane gridPane) {// views the image at a specific col and row 
        for (Node node : gridPane.getChildren()) {//for all the nodes in the grid (32)
            if (GridPane.getColumnIndex(node) == columnIndex && GridPane.getRowIndex(node) == rowIndex) {
                if (node instanceof ImageView) {//gets the image at the node
                    return (ImageView) node;
                }
            }
        }
        return null;
    }
}