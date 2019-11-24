package com.bazzoli.company.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<com.bazzoli.company.company.model.Employee, Long>{

}