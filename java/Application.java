import java.sql.*;


public class Application {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDaoImpl();
        employeeDAO.getEmployeeById(11);
        employeeDAO.getAllEmployees();
    }
}

