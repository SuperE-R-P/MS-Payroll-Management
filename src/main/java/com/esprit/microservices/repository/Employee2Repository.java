package com.esprit.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.microservices.entity.Employee;
import com.esprit.microservices.entity.Employee2;

@Repository
public interface Employee2Repository  extends JpaRepository<Employee2, Long>{

}
