package negocio;

import java.util.List;
import dao.StockDao;
import datos.Almacen;
import datos.Pedido;
import datos.Producto;

public class StockABM {
	private static StockABM instancia = null; // PATRON DE DISEÑO SINGLETON.

	protected StockABM() {
	}

	public static StockABM getInstance() {
		if (instancia == null)
			instancia = new StockABM();
		return instancia;
	}

	public Almacen traerAlmacen(Producto p) {

		return StockDao.getInstance().traerAlmacen(p);

	}

	public Pedido traerPedido(Producto producto) {

		return StockDao.getInstance().traerPedido(producto);

	}

	public List<Pedido> traerPedido() {

		return StockDao.getInstance().traerPedido();

	}

}
