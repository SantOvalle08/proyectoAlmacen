package almacen.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Venta {
	
	public int codigo;
	public Date fecha;
	public float total;	
	public float iva;
	public Cliente clienteCompra;
	private List<DetalleVenta> listaDetallesVenta = new ArrayList<DetalleVenta>();
	
	public Venta(int codigo, Date fecha, float total, float iva) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.total = total;
		this.iva = iva;
	}
	
    public Venta(Cliente clienteCompra, DetalleVenta listaDetallesVenta) {
        this.clienteCompra = clienteCompra;
        this.getListaDetallesVenta().add(listaDetallesVenta);
        calcularTotales();
        
    }

	private void calcularTotales() {
        float subtotal = 0;

        for (DetalleVenta detalle : getListaDetallesVenta()) {
            subtotal += detalle.getSubtotal();
        }

        this.total = subtotal;
        this.iva = subtotal * 0.19f; // Supongamos un IVA fijo del 19% (Colombia)
	}

	public Venta() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public List<DetalleVenta> getDetallesVenta() {
		return getListaDetallesVenta();
	}

	public void setDetallesVenta(List<DetalleVenta> listaDetallesVenta) {
		this.setListaDetallesVenta(listaDetallesVenta);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		return codigo == other.codigo;
	}

	public List<DetalleVenta> getListaDetallesVenta() {
		return listaDetallesVenta;
	}

	public void setListaDetallesVenta(List<DetalleVenta> listaDetallesVenta) {
		this.listaDetallesVenta = listaDetallesVenta;
	}
	

	public ObservableList<DetalleVenta> getObservableDetalleVentaList() {
		return FXCollections.observableArrayList(listaDetallesVenta);
	}

	
//----------------------------- METODOS DE VENTA ----------------------------------------
	
}
