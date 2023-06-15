package chess2;
/*Erin Tomorri
 *Mrs Katsman
 * ICS4U
 * adds a piece to the grid of rectangles 
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

public class Piece {
    private Image image;
    private ImageView imageView;

    public ImageView addPiece(GridPane gridPane, String imagePath, int row, int col, int tileSize) { // adds the piece to the board
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(tileSize);// changes the height and width
        imageView.setFitHeight(tileSize);
        gridPane.add(imageView, col, row); //adds the piece
        return imageView;
    }

    public ImageView getImageView() {
        return imageView; //get the image
    }
}