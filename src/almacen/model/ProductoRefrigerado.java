package almacen.model;

public class ProductoRefrigerado extends Producto{
	
	public String codigoAprobado;
	public float tempRefrigerado;
	
	public ProductoRefrigerado(String nombre, String codigo, String descripcion, float valorUnitario, int cantExistente,
			TipoProducto tipoProducto, String codigoAprobado, float tempRefrigerado) {
		super(nombre, codigo, descripcion, valorUnitario, cantExistente, tipoProducto);
		this.codigoAprobado = codigoAprobado;
		this.tempRefrigerado = tempRefrigerado;
	}

	public ProductoRefrigerado(String nombre, String codigo, String descripcion, float valorUnitario, int cantExistente,
			TipoProducto tipoProducto) {
		super(nombre, codigo, descripcion, valorUnitario, cantExistente, tipoProducto);
	}

	public String getCodigoAprovado() {
		return codigoAprobado;
	}

	public void setCodigoAprovado(String codigoAprovado) {
		codigoAprobado = codigoAprovado;
	}

	public float getTempRefrigerado() {
		return tempRefrigerado;
	}

	public void setTempRefrigerado(float tempRefrigerado) {
		this.tempRefrigerado = tempRefrigerado;
	}
	
	public String getCodigoAprobado() {
		return codigoAprobado;
	}

	public void setCodigoAprobado(String codigoAprobado) {
		this.codigoAprobado = codigoAprobado;
	}

	@Override
	public String toString() {
		return super.toString() + "ProductoRefrigerado [CodigoAprovado=" + codigoAprobado + ", tempRefrigerado=" + tempRefrigerado + "]";
	}
	
	
	
}
