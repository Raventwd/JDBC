import Service.City;
import Service.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDaoImpl();
        CityDAO cityDAO = new CityDaoImpl();


        employeeDAO.getByID(2);
        cityDAO.add(new City(1, "Moscow", null));
        employeeDAO.add(new Employee(1, "1", "1", "m", 1, cityDAO.getByID(1)));
        employeeDAO.add(new Employee(1, "2", "2", "f", 2, cityDAO.getByID(2)));

        cityDAO.updateCity(cityDAO.getByID(1));

        employeeDAO.getAllEmployee();

        Employee test = employeeDAO.getByID(11);
        test.setCity(cityDAO.getByID(2));
        employeeDAO.updateEmployee(7, test);

        System.out.println(cityDAO.getAllCities());

        cityDAO.getByID(2).setCity_name("Istanbul");
        cityDAO.updateCity(new City(2, "Istanbul", null));

    }
}