package com.kiet.sample2;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private Map<Integer, Employee> employees = new HashMap<>();

    // POST - Add Employee
    @PostMapping
    public ResponseEntity<Employee> addEmployee(
            @RequestBody Employee employee) {

        employees.put(employee.getId(), employee);

        return ResponseEntity.status(201).body(employee);
    }

    // GET - All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    // GET - Employee By ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {

        Employee emp = employees.get(id);

        if (emp == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(emp);
    }

    // PUT - Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable int id,
            @RequestBody Employee employee) {

        if (!employees.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        employee.setId(id);
        employees.put(id, employee);

        return ResponseEntity.ok(employee);
    }

    // DELETE - Delete Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {

        if (!employees.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        employees.remove(id);

        return ResponseEntity.ok("Employee deleted successfully");
    }
}