package com.dbs.emp_mgmt.dao;

import com.dbs.emp_mgmt.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hibernateDAO")
public class HibernateDAOImpl implements EmployeeDAO {

    @Autowired(required = false)
    private SessionFactory sessionFactory;

    @Override
    public Employee save(Employee employee) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(employee);
        return employee;
    }

    @Override
    public Employee update(long empId, Employee employee) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Employee").list();
    }

    @Override
    public Employee findById(long id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(long id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.byId(Employee.class).load(id);
        session.delete(employee);
    }

	@Override
	public List<Employee> findAllMysql() {
		// TODO Auto-generated method stub
		return null;
	}
}