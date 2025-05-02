module lp.atividade {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.management;
    requires java.desktop;
    requires java.sql;

    opens lp.atividade to javafx.fxml;
    exports lp.atividade;
}