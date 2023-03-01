package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional 
public class PersonaRepoImpl implements IPersonaRepository{
	
	@PersistenceContext 
	private EntityManager entityManager;

	@Override
	public List<Persona> consultarTodos() {
		TypedQuery<Persona> myQuery = this.entityManager.createQuery(
				"SELECT p FROM Persona p", Persona.class);
	
		List<Persona> lista = myQuery.getResultList();
//		for(Hotel h: lista) {
//			h.getHabitaciones().size();
//		}
		return lista;
	}

	@Override
	public Persona buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Persona per = this.buscarPorId(id);
		this.entityManager.remove(per);
	}

	@Override
	public void insertar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.persist(persona);
	}

}
