import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class easy6 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Ketan", 28, 50000),
                new Employee("Penia", 34, 70000),
                new Employee("Bob", 22, 40000),
                new Employee("Walter", 30, 60000)
        );

        employees.sort((e1, e2) -> Integer.compare(e1.age, e2.age));
        System.out.println("Employees sorted by age:");
        employees.forEach(System.out::println);
    }
}
