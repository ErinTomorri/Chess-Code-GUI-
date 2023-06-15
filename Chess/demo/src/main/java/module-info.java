module chess2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens chess2 to javafx.fxml;
    exports chess2;
}
