package com.dbs.emp_mgmt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dbs.emp_mgmt.model.Employee;

@Repository
public class MysqlEmployeeDAOImpl {
	private JdbcTemplate jdbcTemplate;

    @Autowired
    public MysqlEmployeeDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Employee saveMysql(Employee employee) {
        this.jdbcTemplate.execute("insert into employee (id,emp_name, date_of_birth, department_name) values ("+employee.getId()+",'"+employee.getName()+"','"+employee.getDateOfBirth() + "','" + employee.getDepartmentName()+"');");
        return employee;
    }

    public Employee update(long empId, Employee employee) {
        return null;
    }

    public List<Employee> findAllMysql() {

        String fetchAllQuery = "select * from employee";
        List<Employee> employees = this.jdbcTemplate.query(fetchAllQuery,
                (resultSet,rowNum) ->
                new Employee(resultSet.getString("emp_name"),resultSet.getDate("date_of_birth").toLocalDate(),resultSet.getString("department_name")));

        return employees;
    }

    public Employee findByIdMysql(long id) {
        String query = "select * from employee where id="+id;
        Employee employee = this.jdbcTemplate.queryForObject(query, ((resultSet, i) ->
                new Employee(  resultSet.getString("emp_name"),
                               resultSet.getDate("dob").toLocalDate(),
                               resultSet.getString("dep_name"))));
        return employee;
    }

    public void deleteEmployeeMysql(long id) {
        this.jdbcTemplate.update("delete from employee where id="+id);
    }
}
