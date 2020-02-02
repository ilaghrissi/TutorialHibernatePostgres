package com.tutorial.training.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorial.training.entity.EmployeeEntity;
import com.tutorial.training.repository.EmployeeCustomRepository;

@Repository
public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {

	@Autowired
	EntityManager em;

	public List<EmployeeEntity> getEmployees() {
		Session currentSession = em.unwrap(Session.class);
		Query<EmployeeEntity> query = currentSession.createQuery("from EmployeeEntity", EmployeeEntity.class);
		return query.getResultList();
	}

	public EmployeeEntity getEmployeeById(Long id) {
		Session currentSession = em.unwrap(Session.class);
		return currentSession.get(EmployeeEntity.class, id);
	}

	public EmployeeEntity saveEmployee(EmployeeEntity emp) {
		Session currentSession = em.unwrap(Session.class);
		currentSession.save(emp);
		return null;
	}

	public void deleteEmployee(Long id) {
		Session currentSession = em.unwrap(Session.class);
		EmployeeEntity emp = currentSession.get(EmployeeEntity.class, id);
		currentSession.delete(emp);
		currentSession.flush();
	}

	@Override
	public void updateEmployee(EmployeeEntity emp) {
		Session currentSession = em.unwrap(Session.class);
		currentSession.saveOrUpdate(emp);
	}

	public List<EmployeeEntity> get() {
		CriteriaBuilder criteriabuilder = em.getCriteriaBuilder();
		CriteriaQuery<EmployeeEntity> criteria = criteriabuilder.createQuery(EmployeeEntity.class);
		Root<EmployeeEntity> root = criteria.from(EmployeeEntity.class);
		criteria.where(criteriabuilder.equal(root.get("firstName"), "imad"));
		criteria.where(criteriabuilder.gt(root.get("employeeId"), 2));
		return em.createQuery(criteria).getResultList();
	}

}
