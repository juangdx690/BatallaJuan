module com.example.batallajuan {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.batallajuan to javafx.fxml;
    exports com.example.batallajuan;
}