package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import modelo.PersonaModelo;

public class PersonaDao extends GenericDAO<PersonaModelo>{

	public PersonaDao() {
		super(PersonaModelo.class);
	}
	public List<PersonaModelo> buscarPorFiltro(String filtro){
		try(Session session = getSession()){
			String hql = "FROM Persona WHERE nombre_persona ILIKE :filtro OR apellido_persona ILIKE :filtro" 
		+ " OR ci_persona ILIKE :filtro ORDER BY idPersona";
			Query<PersonaModelo> query = session.createQuery(hql, PersonaModelo.class);
			query.setParameter("filtro", "%" + filtro + "%");
			return query.getResultList();
		}
	}

	public PersonaModelo buscarPorCi(String ci) {
		try (Session session = getSession()) {
			String hql = "FROM Persona WHERE ci_persona = :ci";
			Query<PersonaModelo> query = session.createQuery(hql, PersonaModelo.class);
			query.setParameter("ci", ci);
			List<PersonaModelo> resultado = query.getResultList();
			return resultado.isEmpty() ? null : resultado.get(0);
		}
	}

}