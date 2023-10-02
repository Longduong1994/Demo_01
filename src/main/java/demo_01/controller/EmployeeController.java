package demo_01.controller;

import demo_01.model.Employee;
import demo_01.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<Employee>> getEmploy(){
        return new  ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> save(@RequestBody Employee employee){
        employeeService.save(employee);
        return new ResponseEntity<>("OK",HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<String> update(@RequestBody Employee employee){
        employeeService.save(employee);
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        employeeService.delete(id);
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }

}
