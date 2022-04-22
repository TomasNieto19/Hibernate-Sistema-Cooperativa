package test;

import org.hibernate.*;
import dao.*;

public class TestHBM {

	public static void main(String[] args) {

		System.out.println("OK");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
		System.out.println("OK");
	}
}
