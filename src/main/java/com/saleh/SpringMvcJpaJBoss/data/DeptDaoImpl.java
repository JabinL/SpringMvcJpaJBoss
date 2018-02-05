package com.saleh.SpringMvcJpaJBoss.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saleh.SpringMvcJpaJBoss.model.Dept;

@Repository
@Transactional
public class DeptDaoImpl implements DeptDao {
	
    @Autowired
    private EntityManager em;
    
	@Override
	public Dept findById(Long id) {
		 return em.find(Dept.class, id);
	}

	@Override
	public List<Dept> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Dept> criteria = cb.createQuery(Dept.class);
        Root<Dept> dept = criteria.from(Dept.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(dept).orderBy(cb.asc(dept.get(Dept_.dname)));
         */

        criteria.select(dept).orderBy(cb.asc(dept.get("dname")));
        return em.createQuery(criteria).getResultList();
	}

	@Override
	public void register(Dept dept) {
        em.persist(dept);
        return;

	}

	@Override
	public void update(Dept dept) {
		
        em.merge(dept);
        return;
		
	}

}
