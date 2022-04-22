package datos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Almacen extends Stock {
	private int cantDeseable;
	private int cantMinima;
	private Set<Lote> lotes = new HashSet<Lote>();

	public Almacen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Almacen(Producto producto, int cantDeseable, int cantMinima) {
		super(producto);
		this.cantDeseable = cantDeseable;
		this.cantMinima = cantMinima;
	}

	public int cantProductosExistentes() {

		int total = 0;

		for (Lote lote : lotes) {
			total += lote.getCantExistente();
		}

		return total;
	}

	public int getCantDeseable() {
		return cantDeseable;
	}

	public void setCantDeseable(int cantDeseable) {
		this.cantDeseable = cantDeseable;
	}

	public int getCantMinima() {
		return cantMinima;
	}

	public void setCantMinima(int cantMinima) {
		this.cantMinima = cantMinima;
	}

	public Set<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(Set<Lote> lotes) {
		this.lotes = lotes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cantDeseable, cantMinima, lotes);
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
		Almacen other = (Almacen) obj;
		return cantDeseable == other.cantDeseable && cantMinima == other.cantMinima
				&& Objects.equals(lotes, other.lotes);
	}

	@Override
	public String toString() {
		return "Almacen [cantDeseable=" + cantDeseable + ", cantMinima=" + cantMinima + ", toString()="
				+ super.toString() + "]";
	}

}
