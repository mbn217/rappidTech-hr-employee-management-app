package org.example.controller.internal;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.entity.Employees;
import org.example.model.response.BaseResponse;
import org.example.model.response.ResponseHandler;
import org.example.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Profile("!prod")
@Tag(name = "ZZZ - Internal Delivery")
@Tag(name = "Employees")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/internal/employees")
public class InternalEmployeesController {


    @Autowired
    EmployeesService employeeService;

    @Operation(summary = "Get List of all Employees in the Database",
            description = "This endpoint returns a list of all employees in the database.")
    @GetMapping("/list-all")
    public ResponseEntity<BaseResponse<List<Employees>>> getEmployeesList() {
        List<Employees> employees = employeeService.getAllEmployees();
        return ResponseHandler.generateDefaultOkResponse(employees);

    }


    @Operation(summary = "Get Employee by ID",
            description = "This endpoint returns an employee by their ID.")
    @GetMapping("/get-by-id")
    public ResponseEntity<BaseResponse<Employees>> getEmployeeById(@RequestParam Long id) {
        return ResponseHandler.generateDefaultOkResponse(employeeService.getEmployeeById(id));
    }

    @Operation(summary = "Delete Employee by ID",
            description = "This endpoint deletes an employee by their ID.")
    @GetMapping("/delete-by-id")
    public ResponseEntity<BaseResponse<String>> deleteEmployeeById(@RequestParam Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseHandler.generateDefaultOkResponse("Employee deleted successfully");
    }

}
