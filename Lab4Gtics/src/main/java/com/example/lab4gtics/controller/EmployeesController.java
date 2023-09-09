package com.example.lab4gtics.controller;

import com.example.lab4gtics.entity.Employees;
import com.example.lab4gtics.repository.EmployeesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeesController {
    final EmployeesRepository employeesRepository;

    public EmployeesController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }


    @GetMapping(value = {"/list", ""})
    public String listarEmployees(Model model) {

        List<Employees> lista = employeesRepository.findAll();
        model.addAttribute("employeeList", lista);

        return "employees/employees";
    }



    @PostMapping("/buscarPorDepartamento")
    public String buscarPorDepartamento(@RequestParam("searchField") String searchField, Model model) {

        //List<Shipper> lista =  shipperRepository.findByCompanyName(searchField);
        List<Employees> lista = employeesRepository.buscarPorDepartamento(searchField);
        model.addAttribute("employeeList", lista);
        model.addAttribute("textoBuscado", searchField);

        return "employees/employees";
    }


}
