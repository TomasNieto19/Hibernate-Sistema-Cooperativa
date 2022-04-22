package datos;

import java.time.LocalDate;
import java.util.Objects;

public class NotaPedido {
	private int idNotaPedido;
	private LocalDate fecha;
	private int cantidad;
	private Cliente cliente;
	private boolean entregado;

	public NotaPedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotaPedido(LocalDate fecha, int cantidad, Cliente cliente, boolean entregado) {
		super();
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.cliente = cliente;
		this.entregado = entregado;
	}

	public int getIdNotaPedido() {
		return idNotaPedido;
	}

	public void setIdNotaPedido(int idNotaPedido) {
		this.idNotaPedido = idNotaPedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idNotaPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaPedido other = (NotaPedido) obj;
		return idNotaPedido == other.idNotaPedido;
	}

	@Override
	public String toString() {
		return "NotaPedido [idNotaPedido=" + idNotaPedido + ", fecha=" + fecha + ", cantidad=" + cantidad
				+ ", entregado=" + entregado + "]";
	}

}
