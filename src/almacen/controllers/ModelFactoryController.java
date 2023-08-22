package almacen.controllers;
import almacen.model.*;
import almacen.model.Almacen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModelFactoryController {
	
	
	Almacen almacen =  null;
	
    private ObservableList<Cliente> clientesList = FXCollections.observableArrayList();
    private ObservableList<Producto> productoList = FXCollections.observableArrayList();
    private ObservableList<Venta> ventaList = FXCollections.observableArrayList();

	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aquí al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// Metodo para obtener la instancia de la clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {
		System.out.println("invocación clase singleton");
		inicializarDatos();
	}
	
	private void inicializarDatos() {
		
		almacen = new Almacen("Mi Almacen");
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public ObservableList<Cliente> getClientesList() {
		return clientesList;
	}

	public void setClientesList(ObservableList<Cliente> clientesList) {
		this.clientesList = clientesList;
	}

	public ObservableList<Producto> getProductoList() {
		return productoList;
	}

	public void setProductoList(ObservableList<Producto> productoList) {
		this.productoList = productoList;
	}

	public ObservableList<Venta> getVentaList() {
		return ventaList;
	}

	public void setVentaList(ObservableList<Venta> ventaList) {
		this.ventaList = ventaList;
	}
	
	
	
}
