package Hibernate;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    void createEmployee(Employee entity) throws SQLException;

    Employee getEmployeeById(int id);
    List <Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
