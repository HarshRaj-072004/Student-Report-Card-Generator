import java.util.*;
import java.io.*;

public class ReportCardApp {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Report Cards");
            System.out.println("3. Save to File");
            System.out.println("4. Load from File");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayStudents();
                case 3 -> saveToFile();
                case 4 -> loadFromFile();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
        students.add(new Student(name, roll, marks));
        System.out.println("Student added successfully.");
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    static void saveToFile() {
        try (PrintWriter pw = new PrintWriter("reportcards.txt")) {
            for (Student s : students) {
                pw.println(s);
            }
            System.out.println("Saved to reportcards.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    static void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("reportcards.txt"))) {
            String line;
            System.out.println("\nReport Cards from File:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
    }
}
