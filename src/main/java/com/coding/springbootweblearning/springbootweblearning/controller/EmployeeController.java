package com.coding.springbootweblearning.springbootweblearning.controller;

import com.coding.springbootweblearning.springbootweblearning.dto.EmployeeDTO;
import com.coding.springbootweblearning.springbootweblearning.entities.EmployeeEntity;
import com.coding.springbootweblearning.springbootweblearning.repositories.EmployeeRepository;
import com.coding.springbootweblearning.springbootweblearning.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author gaura
 * @date 18-07-2024
 */
@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

//    @GetMapping(path = "/getmessage")
//    public String getMessage(){
//        return "hcieu;hcenvcfd";
//    }
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId){
        Optional<EmployeeDTO> employeeDTO =  employeeService.getEmployeeById(employeeId);
        return employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping()
    public List<EmployeeDTO> getAllEmployees(@PathVariable(required = false) Integer age,
                                                @PathVariable(required = false) String sortBy){
        return employeeService.getAllEmployees(age);
    }
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping(path = "/{employeeId}")
    public EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){
        return employeeService.updateEmployeeById(employeeDTO, employeeId);
    }

    @DeleteMapping(path = "/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable Long employeeId){
        return employeeService.deleteEmployeeById(employeeId);
    }

    @PatchMapping(path = "/{employeeId}")
    public EmployeeDTO updatePartialEmployeeById(@RequestBody Map<String,Object> updates,@PathVariable Long employeeId){
        return employeeService.updatePartialEmployeeById(updates,employeeId);
    }
}
