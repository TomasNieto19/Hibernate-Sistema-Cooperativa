package negocio;

import dao.StockDao;
import datos.NotaPedido;
import datos.Pedido;
import datos.Producto;

public class PedidoABM {
	private static PedidoABM instancia = null; // PATRON DE DISEÑO SINGLETON.

	protected PedidoABM() {
	}

	public static PedidoABM getInstance() {
		if (instancia == null)
			instancia = new PedidoABM();
		return instancia;
	}

	public int calcularCantidadAPedir(Producto producto) {

		Pedido pedido = StockDao.getInstance().traerPedido(producto);

		int total = 0;

		for (NotaPedido notaPedido : pedido.getNotasPedidos()) {

			if (!notaPedido.isEntregado())
				total += notaPedido.getCantidad();
		}

		return total;

	}

}
