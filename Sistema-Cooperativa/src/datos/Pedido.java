package datos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Pedido extends Stock {
	private Set<NotaPedido> notasPedidos = new HashSet<NotaPedido>();

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(Producto producto) {
		super(producto);
		// TODO Auto-generated constructor stub
	}

	public Set<NotaPedido> getNotasPedidos() {
		return notasPedidos;
	}

	public void setNotasPedidos(Set<NotaPedido> notasPedidos) {
		this.notasPedidos = notasPedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(notasPedidos);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(notasPedidos, other.notasPedidos);
	}

	@Override
	public String toString() {
		return "" + super.toString() + "Pedido [notasPedidos=" + notasPedidos;
	}

}
