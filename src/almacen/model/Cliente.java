package almacen.model;

import java.util.Objects;

public class Cliente {
	
	public String nombre;
	public String apellidos;
	public int identificacion;
	public String direccion;
	public int telefono;
	public TipoCliente tipoCliente;
	
	public Cliente(String nombre, String apellidos, int identificacion, String direccion, int telefono, TipoCliente tipoCliente) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.identificacion = identificacion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipoCliente = tipoCliente;

	}

	public Cliente() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return identificacion == other.identificacion;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos + ", identificacion=" + identificacion
				+ ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}
	

//--------------------------- METODOS DE CLIENTE ---------------------------
	
	public Cliente aniadirCliente (String nombre, String apellidos, String identificacion, String direccion, 
			String telefono, String tipoCliente) 
	{
		if (tipoCliente =="JURIDICO") {

		}
		if (tipoCliente =="NATURAL") {
			
		}
		
		return null;
	}
	
	
	
}
