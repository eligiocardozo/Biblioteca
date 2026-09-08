package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import modelo.LibroModelo;

public class LibroDao extends GenericDAO<LibroModelo> {

	public LibroDao() {
		super(LibroModelo.class);
	}

	public List<LibroModelo> buscarPorFiltro(String filtro) {
		try (Session session = getSession()) {
			String hql = "FROM Libro WHERE titulo_li ILIKE :filtro OR autor_li ILIKE :filtro OR isbn ILIKE :filtro"
					+ " ORDER BY idLibro";
			Query<LibroModelo> query = session.createQuery(hql, LibroModelo.class);
			query.setParameter("filtro", "%" + filtro + "%");
			return query.getResultList();
		}
	}

}