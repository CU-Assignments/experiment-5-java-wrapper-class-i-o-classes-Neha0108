import java.io.*;

// Student class implementing Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L; // Ensuring version control during serialization

    private int id;
    private String name;
    private double gpa;

    // Constructor
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    // Method to display Student details
    public void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("GPA: " + gpa);
    }
}

public class StudentSerialization {
    
    // Method to serialize Student object
    public static void serializeStudent(Student student, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(student);
            System.out.println("Serialization successful! Student object saved.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    // Method to deserialize Student object
    public static Student deserializeStudent(String filename) {
        Student student = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            student = (Student) ois.readObject();
            System.out.println("Deserialization successful! Student object loaded.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
        return student;
    }

    public static void main(String[] args) {
        String filename = "student.ser";

        // Create a Student object
        Student student1 = new Student(101, "Alice", 3.8);

        // Serialize the student object
        serializeStudent(student1, filename);

        // Deserialize the student object
        Student deserializedStudent = deserializeStudent(filename);

        // Display the deserialized student details
        if (deserializedStudent != null) {
            deserializedStudent.display();
        }
    }
}
