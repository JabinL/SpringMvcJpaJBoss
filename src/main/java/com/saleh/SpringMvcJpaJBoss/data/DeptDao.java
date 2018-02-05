package com.saleh.SpringMvcJpaJBoss.data;

import java.util.List;

import com.saleh.SpringMvcJpaJBoss.model.Dept;

public interface DeptDao {
	
    public Dept findById(Long id);

    public List<Dept> findAllOrderedByName();

    public void register(Dept dept);
    
    public void update (Dept dept);
}
