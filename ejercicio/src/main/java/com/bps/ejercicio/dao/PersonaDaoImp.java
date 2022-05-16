package com.bps.ejercicio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bps.ejercicio.models.Persona;

@Repository
@Transactional
public class PersonaDaoImp implements PersonaDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Persona> getPersonas() {
        String query = "FROM Persona";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Persona persona) {
    	persona.setLocal("CCI");
        entityManager.merge(persona);
    }

    @Override
    public void editar(Persona persona) {

        Query query2 = entityManager.createQuery("UPDATE Persona p SET p.nombre = :nombre, p.email =:valor, p.telefono = :cantidad " +
        "  WHERE ID = :id")
                .setParameter("nombre", persona.getNombre())
                .setParameter("valor", persona.getEmail())
                .setParameter("cantidad", persona.getTelefono())
                .setParameter("id", persona.getId());

        int rowsUpdated = query2.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);

    }

    @Override
    public Persona obtenerPersonaPorID(Integer id) {
        String query = "FROM Persona WHERE ID = :id";
        List<Persona> lista = entityManager.createQuery(query)
                .setParameter("id", id)
                .getResultList();
        if (lista.isEmpty()) {
            return null;
        }

        return lista.get(0);
    }

	@Override
	public void deletePersonaId(Integer id) {
		// TODO Auto-generated method stub
		 Query query2 = entityManager.createQuery("DELETE Persona  WHERE ID = :id")
			                .setParameter("id", id);

			        int rowsUpdated = query2.executeUpdate();
			        System.out.println("entities Updated: " + rowsUpdated);
		
	}


}
