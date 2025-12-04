module org.example.hotelmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens hotelmanagement.application to javafx.fxml;
    opens hotelmanagement.controller to javafx.fxml;
    opens hotelmanagement.model to javafx.fxml;
    opens hotelmanagement.repository to javafx.fxml;
    opens hotelmanagement.service to javafx.fxml;
    opens hotelmanagement.util to javafx.fxml;
    opens hotelmanagement.view to javafx.fxml;

    exports hotelmanagement.application;
    exports hotelmanagement.controller;
    exports hotelmanagement.model;
    exports hotelmanagement.repository;
    exports hotelmanagement.service;
    exports hotelmanagement.util;
    exports hotelmanagement.view;
}
