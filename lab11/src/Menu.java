import java.util.Scanner;

public class Menu {
    Scanner scnr = new Scanner(System.in);
    StudentRecord records = new StudentRecord();

    public void displayMenu() {

        while (true) {
            System.out.println("**********Menu*********");
            System.out.println("Please make a selection:");
            System.out.println("1) Add new Student");
            System.out.println("2) Remove a Student");
            System.out.println("3) Display Student info");
            System.out.println("4) Display all Student info");
            System.out.println("5) Exit");
            System.out.println(">>");
            int input = Integer.parseInt(scnr.nextLine());
            if (input == 1) {
                createStudent();
            } else if (input == 2) {
                deleteStudent();
            } else if (input == 3) {
                displayStudent();
            } else if (input == 4) {
                displayAllStudents();
            } else if (input == 5){
                break;
            } else {
                System.out.println("Invalid entry.");
            }
        }
    }

    private void createStudent() {
        System.out.println("Enter Student Name: ");
        String name = scnr.nextLine();
        System.out.println("Enter Student ID: ");
        int id = Integer.parseInt(scnr.nextLine());
        System.out.println("Enter Student GPA: ");
        double gpa = Double.parseDouble(scnr.nextLine());
        Student student = new Student(name, id, gpa);
        records.addStudent(student);

        while (true) {
            System.out.println("Enter the name of a course (or press 'q' to quit)");
            String course = scnr.nextLine();
            int credits;
            if (course.equals("q")) {
                break;
            } else {
                System.out.println("Enter course credits:");
                credits = Integer.parseInt(scnr.nextLine());
            }
            Course courseInstance = new Course(course, credits);
            student.addCourse(courseInstance);
        }
        System.out.println("Student added to Student Records.");
    }

    private void deleteStudent() {
        System.out.println("Enter the name of the Student you would like to remove.");
        String name = scnr.nextLine();
        Student student = records.getStudent(name);
        if (student == null) {
            System.out.println("Student not found");
        } else {
            records.removeStudent(student);
            System.out.println("Student removed from records.");
        }
    }

    private void displayStudent() {
        System.out.println("Enter Student to display:");
        String name = scnr.nextLine();
        Student student = records.getStudent(name);
        if (student == null) {
            System.out.println("Student not found");
        } else {
            System.out.print(records.getStudentInfo(name));
        }
    }

    private void displayAllStudents() {
        String studentInfo = records.getStudentArrayList();
        System.out.println(studentInfo);
    }
}
