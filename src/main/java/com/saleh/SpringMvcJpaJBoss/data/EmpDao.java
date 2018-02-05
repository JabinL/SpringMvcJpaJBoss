package com.saleh.SpringMvcJpaJBoss.data;

import java.util.List;

import com.saleh.SpringMvcJpaJBoss.model.Emp;

public interface EmpDao {
	
    public Emp findById(Long id);
    
    public void deleteById(Long id);

    public List<Emp> findAllOrderedByName();

    public void register(Emp emp);
}

