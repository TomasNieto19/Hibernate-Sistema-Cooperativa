package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Almacen;
import datos.Pedido;
import datos.Producto;

public class StockDao {
	private static Session session;
	private Transaction tx;
	private static StockDao instancia = null; // PATRON DE DISEÑO SINGLETON.

	protected StockDao() {
	}

	public static StockDao getInstance() {
		if (instancia == null)
			instancia = new StockDao();
		return instancia;
	}

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public Almacen traerAlmacen(Producto p) {

		Almacen objeto = null;

		try {

			this.iniciaOperacion();

			String hql = "from Stock s inner join fetch s.producto p where p.idProducto = " + p.getIdProducto();

			objeto = (Almacen) session.createQuery(hql).uniqueResult();

			Hibernate.initialize(objeto.getLotes());

		} finally {

			session.close();

		}

		return objeto;
	}

	public Pedido traerPedido(Producto producto) {

		Pedido objeto = null;

		try {

			this.iniciaOperacion();

			String hql = "from Pedido s inner join fetch s.producto p where p.idProducto = " + producto.getIdProducto();

			objeto = (Pedido) session.createQuery(hql).uniqueResult();

			Hibernate.initialize(objeto.getNotasPedidos());

		} finally {

			session.close();

		}

		return objeto;

	}

	@SuppressWarnings("unchecked")
	public List<Pedido> traerPedido() {

		List<Pedido> objeto = null;

		try {

			this.iniciaOperacion();

			String hql = "from Pedido";

			objeto = (List<Pedido>) session.createQuery(hql).list();

			for (Pedido pedido : objeto) {
				Hibernate.initialize(pedido.getNotasPedidos());
			}

		} finally {

			session.close();

		}

		return objeto;

	}

}