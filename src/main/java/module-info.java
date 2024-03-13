module es.ieslosmontecillos.testfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testfx;
    requires org.junit.jupiter.api;
    requires org.testfx.junit5;


    opens es.ieslosmontecillos.testfx to javafx.fxml;
    exports es.ieslosmontecillos.testfx;
}