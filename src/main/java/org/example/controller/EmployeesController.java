package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.entity.Employees;
import org.example.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Employees")
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("api/employees")
public class EmployeesController {


    @Autowired
    EmployeesService employeeService;
    @Operation(summary = "Get List of all Employees in the Database",
            description = "This endpoint returns a list of all employees in the database.")
    @GetMapping("/")
    public String getEmployees(Model model) {
        List<Employees> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);

        int totalEmployeeCount = employeeService.getEmployeeCount();
        model.addAttribute("totalEmployeeCount", totalEmployeeCount);

        return "employeeList";
    }

    @Operation(summary = "Get Employee by ID",
            description = "This endpoint returns an employee by their ID.")
    @GetMapping("/count")
    public String home(Model model) {
        int totalEmployeeCount = employeeService.getEmployeeCount();
        model.addAttribute("totalEmployeeCount", totalEmployeeCount);
        return "employeeList";
    }

    @Operation(summary = "Get Application About Us Page",
            description = "This endpoint returns the about us page.")
    @GetMapping("/aboutUs")
    public String aboutUsPage() {
        return "aboutUs";
    }

}
