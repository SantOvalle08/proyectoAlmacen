package almacen.model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Producto {
	
	public String nombre; 
	public String codigo;
	public String descripcion;
	public float valorUnitario;
	public int cantExistente;
	public TipoProducto tipoProducto;
	
	public Producto(String nombre, String codigo, String descripcion, float valorUnitario, int cantExistente, TipoProducto tipoProducto) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.valorUnitario = valorUnitario;
		this.cantExistente = cantExistente;
		this.tipoProducto  = tipoProducto;
	}

	public Producto() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getCantExistente() {
		return cantExistente;
	}

	public void setCantExistente(int cantExistente) {
		this.cantExistente = cantExistente;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", descripcion=" + descripcion + ", valorUnitario="
				+ valorUnitario + ", cantExistente=" + cantExistente + ", tipoProducto=" + tipoProducto + "]";
	}


//--------------------- METODOS PRODUCTO -----------------------------------------------

	public void disminuirCantidad(int cantidad) {
        if (cantidad > 0 && cantidad <= this.cantExistente) {
            this.cantExistente -= cantidad;
        } else {
            // Manejar el caso si la cantidad a disminuir es inválida
            mostrarAlerta("Cantidad inválida", "La cantidad a disminuir es inválida.");
        }
    }
	
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

	
}
