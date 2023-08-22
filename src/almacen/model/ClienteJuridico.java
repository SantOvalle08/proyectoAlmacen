package almacen.model;

public class ClienteJuridico extends Cliente{
	
	public String nit;

	public ClienteJuridico(String nombre, String apellidos, int identificacion, String direccion, int telefono,
			String nit) {
		super(nombre, apellidos, identificacion, direccion, telefono, TipoCliente.JURIDICO);
		this.nit = nit;
	}

	public ClienteJuridico(String nombre, String apellidos, int identificacion, String direccion, int telefono) {
		super(nombre, apellidos, identificacion, direccion, telefono, TipoCliente.JURIDICO);
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	@Override
	public String toString() {
		return super.toString() + "ClienteJuridico [nit=" + nit + "]";
	}
	
	
}
