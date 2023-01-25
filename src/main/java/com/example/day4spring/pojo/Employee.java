package com.example.day4spring.pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Employee {
    @NotNull (message = "id Can not be empty")
    @Size(min = 3,message = "id must be than more 2")
    private String id;
    @NotNull (message = "name Can not be empty")
    @Size(min = 5,message = "name must be more than 4")
    private String name;
    @NotNull (message = "age Can not be empty")
    @Size(min = 26,message = "sorry age must be more than 25")
    private int age;
    @NotNull(message = "role Cannot be null")
    @Pattern(regexp = "\\b(supervisor|coordinator)\\b",message = "role must be supervisor or coordinator only")
    private String role;
    @AssertFalse(message ="Employee can not be onLeave at start ")
    private boolean onLeave;
    @NotNull(message ="employmentYear Cannot be null")
    @Size(min = 2010,message ="employmentYear must be a valid year" )
    @Size(max = 2023,message ="employmentYear must be a valid year")
    private int employmentYear;
    @NotNull(message = "annualLeave Cannot be null")
    private int annualLeave;

}
