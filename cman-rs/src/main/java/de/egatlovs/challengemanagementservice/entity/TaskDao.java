package de.egatlovs.challengemanagementservice.entity;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@RequestScoped
public class TaskDao {

	@PersistenceContext
	private EntityManager em;

	public void create(Task task) {
		em.persist(task);
	}

	public void update(Task task) {
		em.merge(task);
	}

	public List<Task> findAll() {
		TypedQuery<Task> q = em.createQuery("Select t from Task t", Task.class);
		return q.getResultList();
	}

	public Task find(long id) {
		return em.find(Task.class, id);
	}

	public void remove(Task task) {
		em.remove(task);
	}

}
