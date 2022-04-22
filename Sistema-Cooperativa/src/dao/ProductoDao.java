package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Producto;

public class ProductoDao {
	private static Session session;
	private Transaction tx;
	private static ProductoDao instancia = null; // PATRON DE DISEÑO SINGLETON.

	protected ProductoDao() {
	}

	public static ProductoDao getInstance() {
		if (instancia == null)
			instancia = new ProductoDao();
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

	public Producto traerProducto(String codigo) {

		Producto objeto = null;

		try {

			this.iniciaOperacion();

			String hql = "from Producto p where p.codigo = :codigo";

			objeto = (Producto) session.createQuery(hql).setParameter("codigo", codigo).uniqueResult();

		} finally {

			session.close();

		}

		return objeto;
	}

}