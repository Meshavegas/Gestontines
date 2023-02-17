module com.marius.tontine {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;
    requires jfoenix;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.logging;
    requires java.sql;


    opens com.marius.tontine to javafx.fxml;
    exports com.marius.tontine;
    exports com.marius.tontine.viewRefactory;
    opens com.marius.tontine.viewRefactory to javafx.fxml;
    exports com.marius.tontine.controller;
    exports com.marius.tontine.View;
    exports com.marius.tontine.modele;
}