module proyectoAlmacen {

	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.desktop;
	
    exports almacen.controllers;
    
    opens almacen.model to javafx.base;

	opens almacen.controllers to javafx.fxml;

	opens almacen.application to javafx.graphics, javafx.fxml;
}
