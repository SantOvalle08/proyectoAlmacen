package almacen.model;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Almacen {

	public String nombre;
	public List<Producto> listaProductos = new ArrayList<Producto>();
	public List<Venta> listaVentas = new ArrayList<Venta>();
	public List<Cliente> listaClientes = new ArrayList<Cliente>();

	public Almacen(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Almacen() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public List<Venta> getListaVentas() {
		return listaVentas;
	}

	public void setListaVentas(List<Venta> listaVentas) {
		this.listaVentas = listaVentas;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public ObservableList<Cliente> getObservableClienteList() {
		return FXCollections.observableArrayList(listaClientes);
	}

	public ObservableList<Producto> getObservableProductoList() {
		return FXCollections.observableArrayList(listaProductos);
	}

	public ObservableList<Venta> getObservableVentaList() {
		return FXCollections.observableArrayList(listaVentas);
	}
	@Override
	public String toString() {
		return "Almacen [nombre=" + nombre + ", listaProductos=" + listaProductos + ", listaVentas=" + listaVentas
				+ ", listaClientes=" + listaClientes + "]";
	}

	//-------------------------------------------------------------------------------------------------

	//-------------METODOS DE ALMACEN -----------------------------------

	public void agregarCliente(Cliente cliente) {
		listaClientes.add(cliente);
	}

	public void actualizarCliente(Cliente clienteActualizado) {
		int indice = -1;

		for (int i = 0; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).getIdentificacion() == clienteActualizado.getIdentificacion()) {
				indice = i;
				break;
			}
		}

		if (indice != -1) {
			listaClientes.set(indice, clienteActualizado);
		}
	}


	public void eliminarCliente(int identificacion) {
		listaClientes.removeIf(cliente -> cliente.getIdentificacion() == identificacion);
	}

	public Cliente buscarCliente(String clienteId) {
		int idBuscado;
		try {
			idBuscado = Integer.parseInt(clienteId); // Convertir a int
		} catch (NumberFormatException e) {
			return null; // Manejar el caso en que no sea un número válido
		}

		for (Cliente cliente : listaClientes) {
			if (cliente.getIdentificacion() == idBuscado) {
				return cliente;
			}
		}
		return null; // Si no se encontró ningún cliente con ese ID
	}

	public Producto buscarProductoPorCodigo(String codigoProducto) {
		for (Producto producto : listaProductos) {
			if (producto.getCodigo().equals(codigoProducto)) {
				return producto; // Devolver el producto encontrado
			}
		}
		return null; // Si no se encontró ningún producto con ese código
	}

	public void agregarVenta(Venta venta) {
		listaVentas.add(venta);
	}

	public char[] calcularTotalVentas() {
		float total = 0;

		for (Venta venta : listaVentas) {
			total += venta.getTotal();
		}

		String totalString = String.format("%.2f", total); // Formatear el total como cadena con dos decimales
		return totalString.toCharArray(); // Convertir la cadena en un arreglo de caracteres
	}

	public List<String> obtenerNombresProductos() {
        List<String> nombresProductos = new ArrayList<>();
        for (Producto producto : listaProductos) {
            nombresProductos.add(producto.getNombre());
        }

        return nombresProductos;
    }

	public Producto getProductoPorNombre(String nombreProductoSeleccionado) {
	    for (Producto producto : listaProductos) {
	        if (producto.getNombre().equals(nombreProductoSeleccionado)) {
	            return producto;
	        }
	    }
	    return null;
	}

}
