package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import modelo.CategoriaModelo;

public class CategoriaDao extends GenericDAO<CategoriaModelo> {

	public CategoriaDao() {
		super(CategoriaModelo.class);
	}

	public List<CategoriaModelo> buscarPorFiltro(String filtro) {
		try (Session session = getSession()) {
			String hql = "FROM Categoria WHERE nombre_categoria ILIKE :filtro OR descripcion_categoria ILIKE :filtro"
					+ " ORDER BY idCategoria";
			Query<CategoriaModelo> query = session.createQuery(hql, CategoriaModelo.class);
			query.setParameter("filtro", "%" + filtro + "%");
			return query.getResultList();
		}
	}

}