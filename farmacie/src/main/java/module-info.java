module gestiune.farmacie {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.microsoft.sqlserver.jdbc;
    requires java.sql;

    opens gestiune.farmacie to javafx.fxml;
    exports gestiune.farmacie;
    exports gestiune.farmacie.controller;
    opens gestiune.farmacie.controller to javafx.fxml;
    requires java.naming;
}
