package com.dbs.springmvcapp.repository;

import com.dbs.springmvcapp.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Optional<Employee> findByName(String name);
    Optional<Employee> findById(Long id);
    List<Employee> findAll();
}