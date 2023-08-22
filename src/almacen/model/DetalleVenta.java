package almacen.model;

public class DetalleVenta {
	
	private String nombreProducto; 
	public int cantProductos;
	public float subtotal;
    private float iva; // Nuevo campo para el valor del IVA
	public Producto productoAsociado;
	
	public DetalleVenta(int cantProductos, float subtotal, float iva, Producto productoAsociado) {
		super();
		this.cantProductos = cantProductos;
		this.subtotal = subtotal;
		this.iva = iva;
		this.productoAsociado = productoAsociado;
		
	}
	
	public DetalleVenta(int cantProductos, float subtotal, Producto productoAsociado) {
		super();
		this.cantProductos = cantProductos;
		this.subtotal = subtotal;
		this.productoAsociado = productoAsociado;
	}
	
	public DetalleVenta() {
		super();
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public int getCantProductos() {
		return cantProductos;
	}

	public void setCantProductos(int cantProductos) {
		this.cantProductos = cantProductos;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	
	
	public Producto getProductoAsociado() {
		return productoAsociado;
	}

	public void setProductoAsociado(Producto productoAsociado) {
		this.productoAsociado = productoAsociado;
	}
	
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
	@Override
	public String toString() {
		return "DetalleVenta [cantProductos=" + cantProductos + ", subtotal=" + subtotal + ", productoAsociado="
				+ productoAsociado + "]";
	}

	
//----------------------- DETALLE VENTA ------------------------------
	
}
