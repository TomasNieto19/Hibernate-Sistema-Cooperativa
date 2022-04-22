package negocio;

import dao.ProductoDao;
import datos.Producto;

public class ProductoABM {
	private static ProductoABM instancia = null; // PATRON DE DISEÑO SINGLETON.

	protected ProductoABM() {
	}

	public static ProductoABM getInstance() {
		if (instancia == null)
			instancia = new ProductoABM();
		return instancia;
	}

	public Producto traerProducto(String codigo) {

		return ProductoDao.getInstance().traerProducto(codigo);

	}

}
