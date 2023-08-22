package almacen.model;

public class ProductoEnvasado extends Producto {
	
	public String fechaEnvasado;
	public float pesoEnvase;
	public PaisOrigen paisOrigen;
	
	public ProductoEnvasado(String nombre, String codigo, String descripcion, float valorUnitario, int cantExistente,
			TipoProducto tipoProducto, String fechaEnvasado, float pesoEnvase, PaisOrigen paisOrigen) {
		super(nombre, codigo, descripcion, valorUnitario, cantExistente, tipoProducto);
		this.fechaEnvasado = fechaEnvasado;
		this.pesoEnvase = pesoEnvase;
		this.paisOrigen = paisOrigen;
	}
	
	public ProductoEnvasado(String nombre, String codigo, String descripcion, float valorUnitario, int cantExistente,
			TipoProducto tipoProducto, String fechaEnvasado, float pesoEnvase, String paisOrigen) {
		super(nombre, codigo, descripcion, valorUnitario, cantExistente, tipoProducto);
		this.fechaEnvasado = fechaEnvasado;
		this.pesoEnvase = pesoEnvase;
		this.paisOrigen = PaisOrigen.valueOf(paisOrigen);
	}

	public ProductoEnvasado(String nombre, String codigo, String descripcion, float valorUnitario, int cantExistente,
			TipoProducto tipoProducto) {
		super(nombre, codigo, descripcion, valorUnitario, cantExistente, tipoProducto);
	}
	
	
	public String getFechaEnvasado() {
		return fechaEnvasado;
	}

	public void setFechaEnvasado(String fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}

	public float getPesoEnvase() {
		return pesoEnvase;
	}

	public void setPesoEnvase(float pesoEnvase) {
		this.pesoEnvase = pesoEnvase;
	}

	public PaisOrigen getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(PaisOrigen paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	@Override
	public String toString() {
		return super.toString() +"ProductoEnvasado [fechaEnvasado=" + fechaEnvasado + ", pesoEnvase=" + pesoEnvase + ", paisOrigen="
				+ paisOrigen + "]";
	}
	
//---------------------------------------------------------------------
	
	
}
