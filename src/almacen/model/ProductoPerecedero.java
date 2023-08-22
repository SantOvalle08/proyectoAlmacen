package almacen.model;

public class ProductoPerecedero extends Producto{
	
	public String fechaVencimiento;

	public ProductoPerecedero(String nombre, String codigo, String descripcion, float valorUnitario, int cantExistente,
			TipoProducto tipoProducto, String fechaVencimiento) {
		super(nombre, codigo, descripcion, valorUnitario, cantExistente, tipoProducto);
		this.fechaVencimiento = fechaVencimiento;
	}

	public ProductoPerecedero(String nombre, String codigo,String descripcion, float valorUnitario, int cantExistente,
			TipoProducto tipoProducto) {
		super(nombre, codigo, descripcion, valorUnitario, cantExistente, tipoProducto);
	}


	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	@Override
	public String toString() {
		return super.toString() +"ProductoPerecedero [fechaVencimiento=" + fechaVencimiento + "]";
	}
	
	
}
