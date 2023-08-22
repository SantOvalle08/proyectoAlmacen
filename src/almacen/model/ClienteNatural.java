package almacen.model;

public class ClienteNatural extends Cliente{
	
	public String email;
	public String fechaNacimiento;
	
	public ClienteNatural(String nombre, String apellidos, int identificacion, String direccion, int telefono,
			String email, String fechaNacimiento) {
		super(nombre, apellidos, identificacion, direccion, telefono, TipoCliente.NATURAL);
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}

	public ClienteNatural(String nombre, String apellidos, int identificacion, String direccion, int telefono) {
		super(nombre, apellidos, identificacion, direccion, telefono, TipoCliente.NATURAL);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return super.toString() + "ClienteNatural [email=" + email + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
}
