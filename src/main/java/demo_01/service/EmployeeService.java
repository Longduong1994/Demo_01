package demo_01.service;

import demo_01.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService<Employee,Integer>{
    private List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public void save(Employee employee) throws ClassCastException {
        if (existsByEmail(employee.getEmail())){
            throw new ClassCastException("Email already exists");
        }
        if (!checkRoles(employee.getRoles())){
            throw new ClassCastException("Role not found");
        }
       if(employee.getId()==0){
           employee.setId(newId());

           employees.add(employee);
       }else{
           employees.set(employees.indexOf(findById(employee.getId())), employee);
       }
    }


    @Override
    public Employee findById(Integer id) throws ClassCastException {
        for (Employee employee: employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new ClassCastException("Id not found");
    }

    @Override
    public void delete(Integer id) {
        employees.remove(findById(id));
    }

    @Override
    public int newId() {
        int max = 0;
        for (Employee employee: employees) {
            if (employee.getId() > max) {
                max = employee.getId();
            }
        }
        return max+1;
    }

    @Override
    public boolean existsByEmail(String email) {
        for (Employee employee: employees) {
            if (employee.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkRoles(List<String> role) {
        for (String r: role) {
            if(role.size() == 1) {
                if (r.equals("ROLE_ADMIN") || r.equals("ROLE_USER")) {
                    return true;
                }
            }else if (role.size()==2){
                if (role.contains("ROLE_ADMIN") && role.contains("ROLE_USER")) {
                    return true;
                }
            }
        }
        return false;
    }


}
