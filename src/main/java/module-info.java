module com.example.goga {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.goga to javafx.fxml;
    exports com.example.goga;
}