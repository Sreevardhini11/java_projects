
    import java.io.*;
import java.util.*;

class Student {
    private String id;
    private String name;
    private int age;
    private String grade;

    public Student(String id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

public class qwerty {
    private static final String FILE_NAME = "students.txt";
    private static Map<String, Student> studentDatabase = new HashMap<>();

    public static void main(String[] args) {
        loadStudentsFromFile();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save and Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addStudent(scanner);
                case 2 -> editStudent(scanner);
                case 3 -> searchStudent(scanner);
                case 4 -> displayAllStudents();
                case 5 -> saveStudentsToFile();
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        System.out.println("Exiting the system. Goodbye!");
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        if (studentDatabase.containsKey(id)) {
            System.out.println("Student with this ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(id, name, age, grade);
        studentDatabase.put(id, student);
        System.out.println("Student added successfully!");
    }

    private static void editStudent(Scanner scanner) {
        System.out.print("Enter Student ID to edit: ");
        String id = scanner.nextLine();

        if (!studentDatabase.containsKey(id)) {
            System.out.println("Student not found!");
            return;
        }

        Student student = studentDatabase.get(id);

        System.out.print("Enter New Name (Leave blank to keep current): ");
        String name = scanner.nextLine();
        if (!name.isBlank()) student.setName(name);

        System.out.print("Enter New Age (Enter 0 to keep current): ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (age > 0) student.setAge(age);

        System.out.print("Enter New Grade (Leave blank to keep current): ");
        String grade = scanner.nextLine();
        if (!grade.isBlank()) student.setGrade(grade);

        System.out.println("Student information updated successfully!");
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();

        if (studentDatabase.containsKey(id)) {
            System.out.println("Student Found: ");
            System.out.println(studentDatabase.get(id));
        } else {
            System.out.println("Student not found!");
        }
    }

    private static void displayAllStudents() {
        if (studentDatabase.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("All Students:");
        for (Student student : studentDatabase.values()) {
            System.out.println(student);
        }
    }

    private static void saveStudentsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student student : studentDatabase.values()) {
                writer.println(student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getGrade());
            }
            System.out.println("Students saved to file successfully!");
        } catch (IOException e) {
            System.out.println("Error saving students to file: " + e.getMessage());
        }
    }

    private static void loadStudentsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String grade = parts[3];
                    studentDatabase.put(id, new Student(id, name, age, grade));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing data found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error loading students from file: " + e.getMessage());
        }
    }
}

