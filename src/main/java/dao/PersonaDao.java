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
			String hql = "FROM PersonaModelo WHERE nombre_persona LIKE :filtro OR apellido_persona ILIKE :filtro" 
		+ " OR ci_persona LIKE :filtro ORDER BY idPersona";
			Query<PersonaModelo> query = session.createQuery(hql, PersonaModelo.class);
			query.setParameter("filtro", "%" + filtro + "%");
			return query.getResultList();
		}
	}

}
