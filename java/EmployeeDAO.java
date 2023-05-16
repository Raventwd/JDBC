import Service.Employee;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    Integer add(Employee employee);

    Employee getByID(int id) throws SQLException;

    List<Employee> getAllEmployee();

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(Employee employee);
}