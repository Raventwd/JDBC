import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDaoImpl();
        employeeDAO.createEmployee();//Task 1.1
        employeeDAO.getEmployeeById();//Task 1.2
        employeeDAO.getAllEmployees();//Task 1.3
        employeeDAO.updateEmployee();//Task 1.4
        employeeDAO.deleteEmployee();//Task 1.5
    }
}

