package com.example.employee.service;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    public EmployeeService(EmployeeRepository repository) { this.repository = repository; }

    public List<Employee> getAll() { return repository.findAll(); }

    public Employee getById(Long id) {
        return repository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }

    public Employee create(Employee employee) {
        if (repository.existsByEmail(employee.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }
        return repository.save(employee);
    }

    public Employee update(Long id, Employee input) {
        Employee existing = getById(id);
        existing.setFirstName(input.getFirstName());
        existing.setLastName(input.getLastName());
        existing.setEmail(input.getEmail());
        existing.setDepartment(input.getDepartment());
        existing.setSalary(input.getSalary());
        return repository.save(existing);
    }

    public void delete(Long id) { repository.delete(getById(id)); }
}
