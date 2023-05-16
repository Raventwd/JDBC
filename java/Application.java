import Service.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();




        String jpqlQuery = "SELECT s FROM Employee s";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
        List<Employee> employees = query.getResultList();

        entityManager.getTransaction().commit();


        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Employee name: " + employee.getFirst_name() + " " + employee.getLast_name());
            System.out.println("Employee gender: " + employee.getGender());
            System.out.println("Employee age: " + employee.getAge());
            System.out.println("-----------------");
        }

        entityManager.close();
        entityManagerFactory.close();

    }
}