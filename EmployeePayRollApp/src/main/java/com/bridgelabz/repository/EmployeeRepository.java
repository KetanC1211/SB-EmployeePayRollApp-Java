package com.bridgelabz.repository;

import com.bridgelabz.model.Employee;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {

    @Query(value = "SELECT * FROM Employee e,employee_department d where d.department =:dept and e.id=employee_id",nativeQuery = true)
    public List<Employee> findByDepartment(String dept);

}
