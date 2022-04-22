package test;

import dao.StockDao;
import datos.Almacen;
import datos.Pedido;
import negocio.PedidoABM;
import negocio.ProductoABM;
import negocio.StockABM;

public class TestOO2 {

	public static void main(String[] args) {

		
		System.out.println("\n*********************************1)*********************************");
		System.out.println("\n1) Traer producto codigo = 001");
		try {
			
			System.out.println( ProductoABM.getInstance().traerProducto("001") );
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		
		System.out.println("\n*********************************2)*********************************");
		System.out.println("\n2) Traer Almacen para el producto codigo=001");
		try {
			
			Almacen almacen = StockDao.getInstance().traerAlmacen( ProductoABM.getInstance().traerProducto("001"));
			
			System.out.println( almacen );
			
			System.out.println( almacen.getLotes() );
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		
		System.out.println("\n*********************************3)*********************************");
		System.out.println("\n3) Calcular los productos existentes en el Almacen para el producto codigo=001");
		try {
			
			int proExistentes = StockDao.getInstance().traerAlmacen( ProductoABM.getInstance().traerProducto("001")).cantProductosExistentes();
			
			System.out.println("los productos existentes en el Almacen son: " + proExistentes);
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		
		System.out.println("\n*********************************4)*********************************");
		System.out.println("\n4) Traer Pedido para el producto codigo=001");
		try {
			
			Pedido pedido = StockABM.getInstance().traerPedido( ProductoABM.getInstance().traerProducto("001") );
			
			System.out.println( pedido );
			
			System.out.println( pedido.getNotasPedidos() );
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		
		System.out.println("\n*********************************5)*********************************");
		System.out.println("\n5) Calcular cantidad pendiente de entrega del producto codigo=001");
		try {
			
			System.out.println( "TOTAL: " + PedidoABM.getInstance().calcularCantidadAPedir(ProductoABM.getInstance().traerProducto("001"))  );
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}

		
	}
}
