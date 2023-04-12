import java.sql.*;
import java.util.*;


public class EmployeeDaoImpl implements EmployeeDAO {

    final String user = "postgres";
    final String password = "12345678";
    final String url = "jdbc:postgresql://localhost:5432/skypro";
    List<Employee> employees = new ArrayList<>();

    @Override
    public void createEmployee(String name, String surname, String gender, int age, int cityId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO employee(first_name, last_name, gender, age, city_id) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, gender);
            preparedStatement.setInt(4, age);
            preparedStatement.setInt(5, cityId);


            int rows = preparedStatement.executeUpdate();
            System.out.printf("%d row(s) added", rows);

        } catch (SQLException e) {
            System.out.println("PostgreSQL connection error!");
            e.printStackTrace();
        }
    }


    @Override
    public void getEmployeeById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "Select * from employee where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            System.out.println("Successful connection!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                System.out.println("Employee id: " + idOfEmployee);

                String employeeName = resultSet.getString("first_name");
                String employeeLastName = resultSet.getString("last_name");
                String employeeGender = resultSet.getString("gender");
                int employeeAge = resultSet.getInt("age");
                int employeeCityId = resultSet.getInt("city_id");


                System.out.println("Name: " + employeeName);
                System.out.println("Surname: " + employeeLastName);
                System.out.println("Gender: " + employeeGender);
                System.out.println("Age: " + employeeAge);
                System.out.println("CityId: " + employeeCityId);
            }
        } catch (SQLException e) {
            System.out.println("PostgreSQL connection error!");
            e.printStackTrace();
        }
    }


    @Override
    public void getAllEmployees() {

        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee")) {
            System.out.println("Successful connection!");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                System.out.println("Employee id: " + idOfEmployee);

                String employeeName = resultSet.getString("first_name");
                String employeeLastName = resultSet.getString("last_name");
                String employeeGender = resultSet.getString("gender");
                int employeeAge = resultSet.getInt("age");
                int employeeCityId = resultSet.getInt("city_id");


                System.out.println("Name: " + employeeName);
                System.out.println("Surname: " + employeeLastName);
                System.out.println("Gender: " + employeeGender);
                System.out.println("Age: " + employeeAge);
                System.out.println("CityId: " + employeeCityId);
                System.out.println(" ");
            }
        } catch (SQLException e) {
            System.out.println("PostgreSQL connection error!");
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(String name, String surname, String gender, int age, int cityId, int id) {

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "UPDATE employee SET first_name = ?, last_name = ? , gender = ?  , age = ?,  city_id = ?  WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, gender);
            preparedStatement.setInt(4, age);
            preparedStatement.setInt(5, cityId);
            preparedStatement.setInt(6, id);

            int rows = preparedStatement.executeUpdate();
            System.out.printf("%d row(s) updated", rows);

        } catch (SQLException e) {
            System.out.println("PostgreSQL connection error!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "DELETE FROM employee where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);


            int rows = preparedStatement.executeUpdate();
            System.out.printf("%d row(s) deleted", rows);
        } catch (SQLException e) {
            System.out.println("PostgreSQL connection error!");
            e.printStackTrace();
        }
    }
}

