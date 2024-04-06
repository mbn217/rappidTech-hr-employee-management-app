package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.entity.Employees;
import org.example.model.response.BaseResponse;
import org.example.model.response.ResponseHandler;
import org.example.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Tag(name = "Employees")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/employees")
public class EmployeesController {


    @Autowired
    private EmployeesService employeeService;

     @Operation(summary = "Get List of all Employees in the Database",
            description = "This endpoint returns a list of all employees in the database.")
    @GetMapping("/list-all")
    public ResponseEntity<BaseResponse<List<Employees>>> getEmployeesList() {
        return ResponseHandler.generateDefaultOkResponse(employeeService.getAllEmployees());

    }

}
