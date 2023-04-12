import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    void createEmployee(String name, String surname, String gender, int age, int cityId) throws SQLException;
    void getEmployeeById(int id);
    void getAllEmployees();
    void updateEmployee(String name, String surname, String gender, int age, int cityId, int id);
    void deleteEmployee(int id);
}
