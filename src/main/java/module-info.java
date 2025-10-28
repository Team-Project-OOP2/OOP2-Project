module org.example.hotelmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.hotelmanagementsystem to javafx.fxml;
    exports org.example.hotelmanagementsystem;
    exports hotelmanagement;
    opens hotelmanagement to javafx.fxml;
}