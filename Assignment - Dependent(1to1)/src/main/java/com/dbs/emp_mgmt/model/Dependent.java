package com.dbs.emp_mgmt.model;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table
public class Dependent {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int age;
	
	
	@ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
	private Employee employee;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dependent that = (Dependent) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
	
	
}
