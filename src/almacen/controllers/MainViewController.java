package almacen.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.table.DefaultTableModel;

import almacen.controllers.ModelFactoryController;
import almacen.application.Aplicacion;
import almacen.model.Almacen;
import almacen.model.Cliente;
import almacen.model.ClienteJuridico;
import almacen.model.ClienteNatural;
import almacen.model.DetalleVenta;
import almacen.model.PaisOrigen;
import almacen.model.Producto;
import almacen.model.ProductoEnvasado;
import almacen.model.ProductoPerecedero;
import almacen.model.ProductoRefrigerado;
import almacen.model.TipoProducto;
import almacen.model.Venta;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainViewController implements Initializable{

	//Llamamos a la clase Banco
	private Almacen almacen;

	//Creamos una variable aplicacion para comunicarme con la aplicacion y me pase datos de la empresa
	private Aplicacion aplicacion;
	
	//
    private Venta venta = new Venta(); // Inicializar la venta
	
	//
	private ObservableList<DetalleVenta> listaDetallesVenta = FXCollections.observableArrayList();

	//Llamamos a la clase Singleton
	ModelFactoryController mfm = ModelFactoryController.getInstance();
	
	//Cliente para las ediciones
	private Cliente clienteSeleccionado;

	//Producto para las ediciones
	private Producto productoSeleccionado;

	@FXML
	private Button btnAgregarCliente;

	@FXML
	private Button btnAgregarVenta;

	@FXML
	private Button btnBuscarProducto;

	@FXML
	private Button btnBuscarCliente;

	@FXML
	private Button btnAniadirProducto;

	@FXML
	private Button btnAniadirProductoVenta;

	@FXML
	private Button btnEditarCliente;

	@FXML
	private Button btnEditarProducto;

	@FXML
	private Button btnEditarVenta;

	@FXML
	private Button btnEliminarCliente;

	@FXML
	private Button btnEliminarProducto;

	@FXML
	private Button btnEliminarVenta;

	@FXML
	private TableColumn<Cliente, String> columnApellido;

	@FXML
	private TableColumn<Producto, Integer> columnCantProducto;

	@FXML
	private TableColumn<Venta, Integer> columnClienteVenta;

	@FXML
	private TableColumn<Producto, Integer> columnCodAprovacion;

	@FXML
	private TableColumn<Producto, String> columnCodigoProd;

	@FXML
	private TableColumn<Venta, Integer> columnCodigoVenta;

	@FXML
	private TableColumn<Producto, String> columnDescProd;

	@FXML
	private TableColumn<Venta, String> columnDetallesVenta;

	@FXML
	private TableColumn<Cliente, String> columnDireccion;

	@FXML
	private TableColumn<Cliente, String> columnEmail;

	@FXML
	private TableColumn<Cliente, String> columnFechaNacim;

	@FXML
	private TableColumn<Producto, String> columnFechaVenc;

	@FXML
	private TableColumn<Venta, String> columnFechaVenta;

	@FXML
	private TableColumn<Cliente, Integer> columnIdentificacion;

	@FXML
	private TableColumn<Cliente, Float> columnIvaVenta;

	@FXML
	private TableColumn<Cliente, Integer> columnNit;

	@FXML
	private TableColumn<Cliente, String> columnNombre;

	@FXML
	private TableColumn<Producto, String> columnNombreProd;
	
	@FXML
	private TableColumn<DetalleVenta, String> columnNombreProducto;

	@FXML
	private TableColumn<Producto, String> columnPaisOrigen;

	@FXML
	private TableColumn<Cliente, Integer> columnTelefono;

	@FXML
	private TableColumn<Producto, Integer> columnTempRefrig;

	@FXML
	private TableColumn<Producto, Float> columnPesoEnvase;

	@FXML
	private TableColumn<Producto, String> columnFechaEnvase;

	@FXML
	private TableColumn<?, ?> columnTipoC;

	@FXML
	private TableColumn<Producto, String> columnTipoProducto;

	@FXML
	private TableColumn<Venta, Integer> columnTotalVenta;

	@FXML
	private TableColumn<Producto, Float> columnValorUnit;

	@FXML
	private ComboBox<String> comboBoxCliente;

	@FXML
	private ComboBox<String> comboBoxPaisOrigen;

	@FXML
	private ComboBox<String> comboBoxTipoProducto;

	@FXML
	private ComboBox<String> comboBoxProductosVenta;

	@FXML
	private TableColumn<Venta, String> columnProductoVenta;

	@FXML
	private TableColumn<Venta, Integer> columnCantProductoVenta;

	@FXML
	private DatePicker dateFechaVenta;

	@FXML
	private DatePicker dateFechaNacimiento;

	@FXML
	private DatePicker dateFechaVencimiento;

	@FXML
	private DatePicker dateFechaEnvasado;

	@FXML
	private ScrollPane scrollPaneProducto;

	@FXML
	private TableView<Cliente> tableViewClientes;

	@FXML
	private TableView<Producto> tableViewProductos;

	@FXML
	private TableView<DetalleVenta> tableViewVentas;

	@FXML
	private TextArea textAreaDatosCliente;

	@FXML
	private TextField textFieldApellido;

	@FXML
	private TextField textFieldCantProducto;

	@FXML
	private TextField textFieldCantProdVenta;
	
    @FXML
    private TextField textFieldValorProdVenta;
    
	@FXML
	private TextField textFieldClienteID;

	@FXML
	private TextField textFieldCodigo;

	@FXML
	private TextField textFieldCodigoAprobacion;

	@FXML
	private TextField textFieldCodigoProduc;

	@FXML
	private TextField textFieldDescripcion;

	@FXML
	private TextField textFieldDetalleVenta;

	@FXML
	private TextField textFieldDireccion;

	@FXML
	private TextField textFieldEmail;

	@FXML
	private TextField textFieldIdentificacion;

	@FXML
	private TextField textFieldIVA;

	@FXML
	private TextField textFieldNit;

	@FXML
	private TextField textFieldNombre;

	@FXML
	private TextField textFieldNombreProduc;

	@FXML
	private TextField textFieldPesoEnvase;

	@FXML
	private TextField textFieldTelefono;

	@FXML
	private TextField textFieldTempRefrig;

	@FXML
	private TextField textFieldTotal;

	@FXML
	private TextField textFieldValorUnitario;

	//------------------------ METODOS DE LAS VENTANAS -----------------------------------------------------

	@FXML
	void agregarCliente(ActionEvent event) {

		String nombre = textFieldNombre.getText();
		String apellido = textFieldApellido.getText();
		String direccion = textFieldDireccion.getText();
		int telefono = Integer.parseInt(textFieldTelefono.getText());
		int identificacion = Integer.parseInt(textFieldIdentificacion.getText());
		String email = textFieldEmail.getText();
		String nit = textFieldNit.getText();
		String tipoCliente = comboBoxCliente.getValue(); // Obtener el valor seleccionado
		Cliente nuevoCliente = null; // Declaración e inicialización de la variable

		try {
			if (tipoCliente.equals("Jurídico")) {
				nuevoCliente = new ClienteJuridico(nombre, apellido, identificacion, direccion, telefono, nit);

			} else if (tipoCliente.equals("Natural")) {
				String fechaNacimiento = dateFechaNacimiento.getValue().toString();
				nuevoCliente = new ClienteNatural(nombre, apellido, identificacion, direccion, telefono, email, fechaNacimiento);
			} else {
				// Manejar un caso por defecto si es necesario
				nuevoCliente = null;
			}
		} catch (NumberFormatException e) {
			// Manejar una excepción si no se pueden convertir los valores a enteros
		}

		if (nuevoCliente != null) {
			almacen.listaClientes.add(nuevoCliente);
			refrescarTableViewClientes();
		}

		limpiarCampos();
	}

	@FXML
	void agregarVenta(ActionEvent event) {

	}

	@FXML
	void aniadirProducto(ActionEvent event) {


	    String codigo = textFieldCodigoProduc.getText();
	    String nombre = textFieldNombreProduc.getText();
	    String descripcion = textFieldDescripcion.getText();

	    // Verificar si los campos de texto no están vacíos
	    String valorUnitarioText = textFieldValorUnitario.getText();
	    String cantidadText = textFieldCantProducto.getText();

	    if (valorUnitarioText.isEmpty() || cantidadText.isEmpty()) {
	        mostrarMensajeError("Campos Vacíos", "Por favor, ingrese un valor en los campos de valor unitario y cantidad.");
	        return;
	    }

	    float valorUnitario = Float.parseFloat(valorUnitarioText);
	    int cantidad = Integer.parseInt(cantidadText);

	    String tipoProducto = comboBoxTipoProducto.getValue();

	    Producto nuevoProducto = null;

	    if (tipoProducto != null) {
	        if (tipoProducto.equals("PERECEDERO")) {
	            String fechaVencimiento = dateFechaVencimiento.getValue().toString();
	            nuevoProducto = new ProductoPerecedero(nombre, codigo, descripcion, valorUnitario, cantidad, TipoProducto.PERECEDERO, fechaVencimiento);
	        } else if (tipoProducto.equals("REFRIGERADO")) {
	            String codigoAprobacion = textFieldCodigoAprobacion.getText();
	            float temperaturaRefrigeracion = Float.parseFloat(textFieldTempRefrig.getText());
	            nuevoProducto = new ProductoRefrigerado(nombre, codigo, descripcion, valorUnitario, cantidad, TipoProducto.REFRIGERADO, codigoAprobacion, temperaturaRefrigeracion);
	        } else if (tipoProducto.equals("ENVASADO")) {
	            String paisOrigen = comboBoxPaisOrigen.getValue().toString();
	            String fechaEnvasado = dateFechaEnvasado.getValue().toString();
	            float pesoEnvase = Float.parseFloat(textFieldPesoEnvase.getText());
	            nuevoProducto = new ProductoEnvasado(nombre, codigo, descripcion, valorUnitario, cantidad,TipoProducto.ENVASADO,  fechaEnvasado, pesoEnvase, paisOrigen);
	        }
	    }

	    if (nuevoProducto != null) {
	        almacen.listaProductos.add(nuevoProducto);
	        refrescarTableViewProductos();

	        // Limpiar los campos después de agregar
	        limpiarCamposProducto();
	        actualizarComboBoxProductos();
	    }
	}

	@FXML
	private void aniadirProductoVenta(ActionEvent event) {
	    String nombreProductoSeleccionado = comboBoxProductosVenta.getValue();
	    int cantidadProducto = Integer.parseInt(textFieldCantProdVenta.getText());

	    if (nombreProductoSeleccionado == null || nombreProductoSeleccionado.isEmpty()) {
	        mostrarMensajeError("Error", "Debe seleccionar un producto.");
	        return;
	    }

	    Producto productoSeleccionado = almacen.getProductoPorNombre(nombreProductoSeleccionado);

	    if (productoSeleccionado == null) {
	        mostrarMensajeError("Error", "El producto seleccionado no existe.");
	        return;
	    }

	    if (cantidadProducto <= 0) {
	        mostrarMensajeError("Error", "La cantidad debe ser mayor a cero.");
	        return;
	    }

	    float valorUnitario = productoSeleccionado.getValorUnitario();
	    float total = valorUnitario * cantidadProducto;

	    // Calcular el IVA (19%)
	    float iva = total * 0.19f;

	    // Crear el detalle de venta
	    DetalleVenta detalleVenta = new DetalleVenta(cantidadProducto, total, iva, productoSeleccionado);

	    // Agregar el detalle de venta a la tabla
	    listaDetallesVenta.add(detalleVenta);

	    // Limpiar campos
	    limpiarCamposVenta();
	}


	private void limpiarCamposVenta() {
	    comboBoxProductosVenta.getSelectionModel().clearSelection(); // Limpiar selección del ComboBox
	    textFieldCantProdVenta.clear(); // Limpiar el campo de cantidad
	    textFieldValorProdVenta.clear(); // Limpiar el campo de valor unitario
	}

	private void actualizarTableViewVentas() {
	    List<Venta> ventas = almacen.getListaVentas();

	    // Crear una lista de detalles de venta a partir de las ventas
	    List<DetalleVenta> detallesVentas = new ArrayList<>();
	    for (Venta venta : ventas) {
	        // Aquí debes obtener los detalles de cada venta y agregarlos a la lista detallesVentas
	        // Por ejemplo: detallesVentas.addAll(venta.getListaDetallesVenta());
	    	detallesVentas.addAll(venta.getListaDetallesVenta());
	    }

	    // Actualizar la lista de detalles de venta en la tabla
	    listaDetallesVenta.setAll(detallesVentas);

	    tableViewVentas.refresh();
	}


	private void limpiarCamposProducto() {
		textFieldCodigoProduc.clear();
		textFieldNombreProduc.clear();
		textFieldDescripcion.clear();
		textFieldValorUnitario.clear();
		textFieldCantProducto.clear();
		dateFechaVencimiento.setValue(null);
		textFieldCodigoAprobacion.clear();
		textFieldTempRefrig.clear();
		comboBoxPaisOrigen.getSelectionModel().clearSelection();
		dateFechaEnvasado.setValue(null);
		textFieldPesoEnvase.clear();
		comboBoxTipoProducto.getSelectionModel().clearSelection();
	}


	private void refrescarTableViewProductos() {
		tableViewProductos.setItems(almacen.getObservableProductoList());	
		tableViewProductos.refresh();
	}


	@FXML
	void editarProducto(ActionEvent event) {
		if (productoSeleccionado != null) {
			// Actualizar los datos del producto seleccionado
			actualizarDatosProducto(productoSeleccionado);

			// Refrescar la tabla con los datos actualizados
			refrescarTableViewProductos();

			// Limpiar la selección y los campos
			limpiarCamposProducto();
			productoSeleccionado = null;
		}
	}


	@FXML
	void editarCliente(ActionEvent event) {
		if (clienteSeleccionado != null) {
			// Modificar los datos del cliente seleccionado en la lista de almacen
			modificarDatosCliente(clienteSeleccionado);
			refrescarTableViewClientes();


			// Refrescar la tabla con los datos actualizados
			refrescarTableViewClientes();

			// Limpiar la selección y campos
			clienteSeleccionado = null; // Limpiar la selección
			// Quitar la selección del cliente en la tabla
			tableViewClientes.getSelectionModel().clearSelection();
			limpiarCampos();
		}
	}



	// Limpiar los campos después de agregar
	private void limpiarCampos() {
		clienteSeleccionado = null;
		textFieldNombre.clear();
		textFieldApellido.clear();
		textFieldDireccion.clear();
		textFieldTelefono.clear();
		textFieldEmail.clear();
		textFieldNit.clear();
		textFieldIdentificacion.clear();
		dateFechaNacimiento.setValue(null);
	}


	@FXML
	void editarVenta(ActionEvent event) {

	}

	@FXML
	void eliminarCliente(ActionEvent event) {
		if (clienteSeleccionado != null) {
			// Eliminar el cliente seleccionado de la lista de almacen
			almacen.getListaClientes().remove(clienteSeleccionado);

			// Refrescar la tabla con los datos actualizados
			refrescarTableViewClientes();

			// Limpiar la selección y campos
			limpiarCampos();
		}
	}


	@FXML
	void eliminarProducto(ActionEvent event) {
		if (productoSeleccionado != null) {
			// Remover el producto seleccionado de la lista de productos
			almacen.getListaProductos().remove(productoSeleccionado);

			// Refrescar la tabla para reflejar los cambios
			refrescarTableViewProductos();

			// Limpiar la selección y los campos
			limpiarCamposProducto();
			productoSeleccionado = null;
		}
	}


	@FXML
	void eliminarVenta(ActionEvent event) {
	    DetalleVenta ventaSeleccionada = tableViewVentas.getSelectionModel().getSelectedItem();

	    if (ventaSeleccionada == null) {
	        mostrarMensajeError("Error", "Debe seleccionar una venta para eliminar.");
	        return;
	    }

	    // Remover la venta de la lista de ventas y de la lista observable
	    listaDetallesVenta.remove(ventaSeleccionada);

	    // Limpiar la lista de detalles de la venta eliminada
	    venta.getListaDetallesVenta().clear();

	    // Actualizar la tabla de detalles de venta
	    actualizarTableViewVentas();

	    // Limpiar campos o realizar cualquier otra acción necesaria
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		almacen = new Almacen(); // O cualquier otra forma de inicializarlo

		ObservableList<String> tiposClientes = FXCollections.observableArrayList("Jurídico", "Natural");
		comboBoxCliente.setItems(tiposClientes);

		// Inicialmente, deshabilitar los campos nit, fecha de nacimiento y email
		textFieldNit.setDisable(true);
		dateFechaNacimiento.setDisable(true);
		textFieldEmail.setDisable(true);

		// Llamar al método para cargar los datos iniciales en la tabla
		refrescarTableViewClientes();

		// Configurar listener para el ComboBox
		comboBoxCliente.setOnAction(event -> {
			String tipoCliente = comboBoxCliente.getValue();

			if (tipoCliente != null) {
				// Habilitar/deshabilitar campos según la selección en el ComboBox
				textFieldNit.setDisable(!tipoCliente.equals("Jurídico"));
				dateFechaNacimiento.setDisable(!tipoCliente.equals("Natural"));
				textFieldEmail.setDisable(!tipoCliente.equals("Natural"));

				// Mostrar/ocultar columnas según el tipo de cliente
				columnFechaNacim.setVisible(tipoCliente.equals("Natural"));
				columnEmail.setVisible(tipoCliente.equals("Natural"));
			}
		});

		// Configurar las columnas para enlazarlas con las propiedades del objeto Cliente
		columnNit.setCellValueFactory(new PropertyValueFactory<>("nit"));
		columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columnApellido.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
		columnFechaNacim.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
		columnDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		columnIdentificacion.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
		columnTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		columnTipoC.setCellValueFactory(new PropertyValueFactory<>("tipoCliente"));

		tableViewClientes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				clienteSeleccionado = newValue;
				mostrarDatosClienteSeleccionado(clienteSeleccionado);
			}
		});

		//METODOS PRODUCTO INITIALIZE

		comboBoxTipoProducto.getItems().addAll("PERECEDERO", "REFRIGERADO", "ENVASADO");
		comboBoxPaisOrigen.getItems().addAll("COLOMBIA", "ARGENTINA","CHILE", "ECUADOR","PERU");

		// Configurar las columnas para enlazarlas con las propiedades del objeto Producto
		columnCodigoProd.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		columnNombreProd.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columnDescProd.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		columnValorUnit.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
		columnCantProducto.setCellValueFactory(new PropertyValueFactory<>("cantExistente"));
		columnFechaVenc.setCellValueFactory(new PropertyValueFactory<>("fechaVencimiento"));
		columnCodAprovacion.setCellValueFactory(new PropertyValueFactory<>("codigoAprobacion"));
		columnTempRefrig.setCellValueFactory(new PropertyValueFactory<>("tempRefrigerado"));
		columnPaisOrigen.setCellValueFactory(new PropertyValueFactory<>("paisOrigen"));
		columnTipoProducto.setCellValueFactory(new PropertyValueFactory<>("tipoProducto"));
		columnPesoEnvase.setCellValueFactory(new PropertyValueFactory<>("pesoEnvase"));
		columnFechaEnvase.setCellValueFactory(new PropertyValueFactory<>("fechaEnvasado"));

		//deshabilito inicialmente
		dateFechaVencimiento.setDisable(true);
		textFieldCodigoAprobacion.setDisable(true);
		textFieldTempRefrig.setDisable(true);
		comboBoxPaisOrigen.setDisable(true);
		dateFechaEnvasado.setDisable(true);
		textFieldPesoEnvase.setDisable(true);

		// Listener para el ComboBox
		comboBoxTipoProducto.setOnAction(event -> {
			String tipoSeleccionado = comboBoxTipoProducto.getValue();
			if(tipoSeleccionado != null) {    
				// Habilitar o deshabilitar campos según la selección
				dateFechaVencimiento.setDisable(!tipoSeleccionado.equals("PERECEDERO"));
				textFieldCodigoAprobacion.setDisable(!tipoSeleccionado.equals("REFRIGERADO"));
				textFieldTempRefrig.setDisable(!tipoSeleccionado.equals("REFRIGERADO"));
				comboBoxPaisOrigen.setDisable(!tipoSeleccionado.equals("ENVASADO"));
				dateFechaEnvasado.setDisable(!tipoSeleccionado.equals("ENVASADO"));
				textFieldPesoEnvase.setDisable(!tipoSeleccionado.equals("ENVASADO"));
			}
		});

		//Listener de la tabla
		tableViewProductos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				productoSeleccionado = newValue;
				cargarDatosProductoSeleccionado(productoSeleccionado);
			}
		});

		//METODOS DE PESTAÑA VENTAS

	    // Configurar el ComboBox con los nombres de los productos al iniciar la interfaz
	    List<String> nombresProductos = almacen.obtenerNombresProductos();
	    comboBoxProductosVenta.setItems(FXCollections.observableArrayList(nombresProductos));
	    tableViewVentas.setItems(listaDetallesVenta);

	    // Configurar el listener para la selección del producto en el ComboBox
	    comboBoxProductosVenta.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	        // Obtener el producto seleccionado por su nombre
	        Producto productoSeleccionado = almacen.getProductoPorNombre(newValue);
	        if (productoSeleccionado != null) {
	            // Mostrar el valor unitario del producto en el TextField
	            textFieldValorProdVenta.setText(String.valueOf(productoSeleccionado.getValorUnitario()));
	        } else {
	        	textFieldValorProdVenta.setText("");
	        }
	    });
	    
	    // Configurar celdas de las columnas de la tabla de Ventas
	    columnNombreProducto.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
	    columnCantProductoVenta.setCellValueFactory(new PropertyValueFactory<>("cantProductos"));
	    columnTotalVenta.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
	    columnIvaVenta.setCellValueFactory(new PropertyValueFactory<>("iva"));

	    actualizarTableViewVentas();
	}


	//METODO PARA QUE APAREZCAN LOS DATOS DEL CLIENTE EN LOS CAMPOS
	private void mostrarDatosClienteSeleccionado(Cliente cliente) {
		textFieldNombre.setText(cliente.getNombre());
		textFieldApellido.setText(cliente.getApellidos());
		textFieldIdentificacion.setText(String.valueOf(cliente.getIdentificacion()));
		textFieldDireccion.setText(cliente.getDireccion());
		textFieldTelefono.setText(String.valueOf(cliente.getTelefono()));
		// Verificar si es ClienteNatural y mostrar datos específicos
		if (cliente instanceof ClienteNatural) {
			ClienteNatural clienteNatural = (ClienteNatural) cliente;
			dateFechaNacimiento.setValue(LocalDate.parse(clienteNatural.getFechaNacimiento()));
			textFieldEmail.setText(clienteNatural.getEmail());

			// Limpiar campos específicos de ClienteJuridico
			textFieldNit.clear();
		}

		// Verificar si es ClienteJuridico y mostrar datos específicos
		if (cliente instanceof ClienteJuridico) {
			ClienteJuridico clienteJuridico = (ClienteJuridico) cliente;
			textFieldNit.setText(clienteJuridico.getNit());

			// Limpiar campos específicos de ClienteNatural
			dateFechaNacimiento.setValue(null);
			textFieldEmail.clear();
		}
	}


	// Método para refrescar la TableView con la lista actualizada de clientes
	public void refrescarTableViewClientes() {
		if (almacen != null) { // Verifica que la instancia de Almacen no sea nula
			tableViewClientes.setItems(almacen.getObservableClienteList());
			tableViewClientes.refresh(); // Refrescar la tabla
		}
	}


	// Método para actualizar el cliente seleccionado
	private void modificarDatosCliente(Cliente cliente) {
		String nuevoNombre = textFieldNombre.getText();
		String nuevoApellido = textFieldApellido.getText();
		int nuevaIdentificacion = Integer.parseInt(textFieldIdentificacion.getText());
		String nuevaDireccion = textFieldDireccion.getText();
		int nuevoTelefono = Integer.parseInt(textFieldTelefono.getText());

		if (cliente instanceof ClienteNatural) {
			ClienteNatural clienteNatural = (ClienteNatural) cliente;
			String nuevaFechaNacimiento = dateFechaNacimiento.getValue().toString();
			String nuevoEmail = textFieldEmail.getText();

			clienteNatural.setNombre(nuevoNombre);
			clienteNatural.setApellidos(nuevoApellido);
			clienteNatural.setIdentificacion(nuevaIdentificacion);
			clienteNatural.setDireccion(nuevaDireccion);
			clienteNatural.setTelefono(nuevoTelefono);
			clienteNatural.setFechaNacimiento(nuevaFechaNacimiento);
			clienteNatural.setEmail(nuevoEmail);
			// Actualizar la tabla después de modificar los datos
			refrescarTableViewClientes();
		}

		if (cliente instanceof ClienteJuridico) {
			ClienteJuridico clienteJuridico = (ClienteJuridico) cliente;
			String nuevoNit = textFieldNit.getText();

			clienteJuridico.setNombre(nuevoNombre);
			clienteJuridico.setApellidos(nuevoApellido);
			clienteJuridico.setIdentificacion(nuevaIdentificacion);
			clienteJuridico.setDireccion(nuevaDireccion);
			clienteJuridico.setTelefono(nuevoTelefono);
			clienteJuridico.setNit(nuevoNit);
		}
	}


	private void cargarDatosProductoSeleccionado(Producto producto) {
		textFieldCodigoProduc.setText(producto.getCodigo());
		textFieldNombreProduc.setText(producto.getNombre());
		textFieldDescripcion.setText(producto.getDescripcion());
		textFieldValorUnitario.setText(Float.toString(producto.getValorUnitario()));
		textFieldCantProducto.setText(Integer.toString(producto.getCantExistente()));

		// Aquí carga los datos específicos según el tipo de producto
		if (producto instanceof ProductoPerecedero) {
			ProductoPerecedero perecedero = (ProductoPerecedero) producto;
			dateFechaVencimiento.setValue(LocalDate.parse(perecedero.getFechaVencimiento()));
		} else if (producto instanceof ProductoRefrigerado) {
			ProductoRefrigerado refrigerado = (ProductoRefrigerado) producto;
			textFieldCodigoAprobacion.setText(refrigerado.getCodigoAprobado());
			textFieldTempRefrig.setText(Float.toString(refrigerado.getTempRefrigerado()));
		} else if (producto instanceof ProductoEnvasado) {
			ProductoEnvasado envasado = (ProductoEnvasado) producto;
			comboBoxPaisOrigen.setValue(envasado.getPaisOrigen().toString());
			dateFechaEnvasado.setValue(LocalDate.parse(envasado.getFechaEnvasado()));
			textFieldPesoEnvase.setText(Float.toString(envasado.getPesoEnvase()));
		}

		comboBoxTipoProducto.setValue(producto.getTipoProducto().toString());
	}


	private void actualizarDatosProducto(Producto producto) {
		// Actualiza los datos generales del producto
		producto.setCodigo(textFieldCodigoProduc.getText());
		producto.setNombre(textFieldNombreProduc.getText());
		producto.setDescripcion(textFieldDescripcion.getText());
		producto.setValorUnitario(Float.parseFloat(textFieldValorUnitario.getText()));
		producto.setCantExistente(Integer.parseInt(textFieldCantProducto.getText()));

		// Actualiza los datos específicos según el tipo de producto
		if (producto instanceof ProductoPerecedero) {
			ProductoPerecedero perecedero = (ProductoPerecedero) producto;
			perecedero.setFechaVencimiento(dateFechaVencimiento.getValue().toString());
		} else if (producto instanceof ProductoRefrigerado) {
			ProductoRefrigerado refrigerado = (ProductoRefrigerado) producto;
			refrigerado.setCodigoAprobado(textFieldCodigoAprobacion.getText());
			refrigerado.setTempRefrigerado(Float.parseFloat(textFieldTempRefrig.getText()));
		} else if (producto instanceof ProductoEnvasado) {
			ProductoEnvasado envasado = (ProductoEnvasado) producto;
			envasado.setPaisOrigen(PaisOrigen.valueOf(comboBoxPaisOrigen.getValue()));
			envasado.setFechaEnvasado(dateFechaEnvasado.getValue().toString());
			envasado.setPesoEnvase(Float.parseFloat(textFieldPesoEnvase.getText()));
		}
	}


	@FXML
	void buscarCliente(ActionEvent event) {
		clienteSeleccionado = almacen.buscarCliente(textFieldClienteID.getText());
		if (clienteSeleccionado != null) {
			textAreaDatosCliente.setText(clienteSeleccionado.toString());
		} else {
			textAreaDatosCliente.setText("Cliente no encontrado");
		}
	}


	@FXML
	void buscarProducto(ActionEvent event) {
		// Implementa la lógica para buscar un producto y almacenar el producto seleccionado
		productoSeleccionado = almacen.buscarProductoPorCodigo(textFieldCodigo.getText());
		if (productoSeleccionado != null) {
			// Mostrar detalles del producto en los campos correspondientes
		} else {
			// Producto no encontrado
		}
	}


	private void actualizarComboBoxProductos() {
		List<String> nombresProductos = almacen.obtenerNombresProductos();
		comboBoxProductosVenta.setItems(FXCollections.observableArrayList(nombresProductos));
	}


	public void setAplicacion(Aplicacion aplicacion) {

		this.aplicacion = aplicacion;
		this.almacen = mfm.getAlmacen();
	}


	private void mostrarMensajeError(String titulo, String mensaje) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(titulo);
		alert.setHeaderText(null);
		alert.setContentText(mensaje);
		alert.showAndWait();
	}
}