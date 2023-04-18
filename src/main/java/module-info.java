module com.example.londonunderground {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.londonunderground to javafx.fxml;
    exports com.example.londonunderground;
    exports controller;
    opens controller to javafx.fxml;
//    exports com.example.londonunderground;
//    opens com.example.londonunderground to javafx.fxml;
}