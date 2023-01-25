package com.example.day4spring.controller;

import com.example.day4spring.ApiResponse;
import com.example.day4spring.pojo.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/employee")
public class controllerEmployee {
    //    static Scanner s= new Scanner(System.in);
    ArrayList<Employee> Employees = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Employee> getEmployees() {
        return Employees;
    }

    @PostMapping("/add")
    public ApiResponse addEmployee(@RequestBody Employee Employee) {
        Employees.add(Employee);
        return new ApiResponse("Employee has been added");
    }

    @PutMapping("/update/{index}")
    ApiResponse updateEmployee(@PathVariable int index, @RequestBody Employee Employee) {
        Employees.set(index, Employee);
        return new ApiResponse("Employee has been updated");
    }

    @DeleteMapping("/delete/{index}")
    ApiResponse deleteEmployee(@PathVariable int index) {
        Employees.remove(index);
        return new ApiResponse("Employee has been Deleted");
    }

    @PutMapping("/apply/{id}")
    ResponseEntity applyForLeave(@PathVariable int id) {
        for (Employee employee : Employees) {
            if (employee.getId().equals(id)) {
                if (!employee.isOnLeave()) {
                    if (employee.getAnnualLeave() > 0) {
                        employee.setAnnualLeave(employee.getAnnualLeave() - 1);
                        employee.setOnLeave(true);
                        return ResponseEntity.status(200).body(new ApiResponse("Employee is allowed to leave "));
                    } else
                        return ResponseEntity.status(400).body((new ApiResponse("Employee has not enough annualLeave")));

                } else return ResponseEntity.status(400).body((new ApiResponse("Employee is already on leave")));

            } else return ResponseEntity.status(400).body((new ApiResponse("Employee not found ")));


        }

        return null;
    }

}
