package com.example.lab4gtics.repository;

import com.example.lab4gtics.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {


    @Query(nativeQuery = true, value = "SELECT * FROM employees where department_id = ?1")
    List<Employees> buscarPorDepartamento(String textoIngreso);

}
