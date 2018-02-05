package com.saleh.SpringMvcJpaJBoss.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saleh.SpringMvcJpaJBoss.model.Emp;



@Repository
@Transactional
public class EmpDaoImpl implements EmpDao {

    @Autowired
    private EntityManager em;
    
	@Override
	public Emp findById(Long id) {
		return em.find(Emp.class, id);
	}

	@Override
	public List<Emp> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Emp> criteria = cb.createQuery(Emp.class);
        Root<Emp> emp = criteria.from(Emp.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(emp).orderBy(cb.asc(emp.get(Emp_.name)));
         */

        criteria.select(emp).orderBy(cb.asc(emp.get("name")));
        return em.createQuery(criteria).getResultList();
	}

	@Override
	public void register(Emp emp) {
        em.persist(emp);
        return;

	}

	@Override
	public void deleteById(Long id) {
		Emp emp = em.getReference(Emp.class, id);
		em.remove(emp);
	}

}
