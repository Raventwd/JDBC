import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    void createEmployee();
    Employee getEmployeeById() throws SQLException;
    List<Employee> getAllEmployees();
    void updateEmployee();
    void deleteEmployee();
}
