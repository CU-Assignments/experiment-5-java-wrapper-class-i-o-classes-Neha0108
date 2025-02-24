import java.util.*;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + "}";
    }
}

public class easy62 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Neha", 80.5),
                new Student("Arin", 60.2),
                new Student("Ayush", 90.0),
                new Student("Nikita", 78.4),
                new Student("Nitin", 65.5)
        );

        // Filter students scoring above 75% and sort by marks in descending order
        students.stream()
                .filter(s -> s.marks > 75)
                .sorted((s1, s2) -> Double.compare(s2.marks, s1.marks)) // Sort in descending order
                .map(s -> s.name) // Extracting student names
                .forEach(System.out::println); // Printing names
    }
}
