package datos;

import java.util.Objects;

public abstract class Stock {
	private int idStock;
	private Producto producto;

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(Producto producto) {
		super();
		this.producto = producto;
	}

	public int getIdStock() {
		return idStock;
	}

	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idStock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return idStock == other.idStock;
	}

	@Override
	public String toString() {
		return "\nStock [idStock=" + idStock + ", producto=" + producto + "]";
	}

}
