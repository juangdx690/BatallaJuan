module com.example.batallajuan {
    requires javafx.controls;
    requires javafx.fxml;
    
    requires javafx.media;


    opens com.example.batallajuan to javafx.fxml;
    exports com.example.batallajuan;
}