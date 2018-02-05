package com.saleh.SpringMvcJpaJBoss.model;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPT", uniqueConstraints = @UniqueConstraint(columnNames = "dname"))
public class Dept implements java.io.Serializable {

    @Id
    @GeneratedValue
	private Long deptId;
    
    @NotNull
	private String dname;
    
	private String location;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "dept") // whithout mappedBy (tells which side is the relationship owner) delete emp will not work! 
	@JsonIgnore 
	private List<Emp> emps = new ArrayList<Emp>(0);

	public Dept() {
	}

	public Dept(Long deptId) {
		this.deptId = deptId;
	}

	public Dept(Long deptId, String dname, String location, List<Emp> emps) {
		this.deptId = deptId;
		this.dname = dname;
		this.location = location;
		this.emps = emps;
	}

	public Long getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

}
