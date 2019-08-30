package com.dbs.emp_mgmt.dao;

import com.dbs.emp_mgmt.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository("h2Dao")
public class H2EmployeeDAOImpl implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public H2EmployeeDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Employee save(Employee employee) {
        this.jdbcTemplate.execute("insert into employee (id) values ("+employee.getId()+" )");
        return employee;
    }

    @Override
    public Employee update(long empId, Employee employee) {
        return null;
    }

    @Override
    public List<Employee> findAll() {

        String fetchAllQuery = "select * from employee";
        List<Employee> employees = this.jdbcTemplate.query(fetchAllQuery,
                (resultSet,rowNum) ->
                new Employee(resultSet.getString("emp_name"),resultSet.getDate("date_of_birth").toLocalDate(),resultSet.getString("department_name")));

        return employees;
    }

    @Override
    public Employee findById(long id) {
        String query = "select * from employee where id="+id;
        Employee employee = this.jdbcTemplate.queryForObject(query, ((resultSet, i) ->
                new Employee(  resultSet.getString("emp_name"),
                               resultSet.getDate("dob").toLocalDate(),
                               resultSet.getString("dep_name"))));
        return employee;
    }

    @Override
    public void deleteEmployee(long id) {
        this.jdbcTemplate.update("delete from employee where id="+id);
    }
}