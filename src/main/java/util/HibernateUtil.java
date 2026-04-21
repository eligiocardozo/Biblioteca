package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory SESSION_FACTORY = buildSessionfactory();

	private static SessionFactory buildSessionfactory() {

		try {
			// Crea la SessionFactory a aprtr de lal archivo hibernate
			// .configure() busca automaticamente el archivo src/main/resources
			
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			// muestra un error si es que no consigue
			
			System.err.println("Error al inicializar la SessionFactory" + e);
			throw new ExceptionInInitializerError();
		}

	}

	// metodo para obtener la session en el Dao
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

	// metodo para cerrar sesion en la aplicacion
	public static void shutdow() {
		getSessionFactory().close();
	}

}
