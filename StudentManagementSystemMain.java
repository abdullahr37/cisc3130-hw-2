import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystemMain {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        CourseManager cm = new CourseManager();
        EnrollmentManager em = new EnrollmentManager();
        ReportGenerator rg = new ReportGenerator();

        sm.addStudent(new Student("S001", "Alice", "Smith", "alice@university.edu", 3.8, "Computer Science", 2));
        sm.addStudent(new Student("S002", "Bob", "Jones", "bob@university.edu", 3.5, "Mathematics", 3));
        sm.addStudent(new Student("S003", "Charlie", "Brown", "charlie@university.edu", 3.9, "Computer Science", 2));

        cm.addCourse(new Course("CISC3130", "Data Structures", 3, "Dr. Smith", 30));
        cm.addCourse(new Course("MATH101", "Calculus I", 4, "Dr. Johnson", 25));

        em.enrollStudent("S001", "CISC3130", "Fall 2024");
        em.assignGrade("E001", "A");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1 Add Student");
            System.out.println("2 Remove Student");
            System.out.println("3 Find Student");
            System.out.println("4 List Students");
            System.out.println("5 Add Course");
            System.out.println("6 Enroll Student");
            System.out.println("7 Assign Grade");
            System.out.println("8 Calculate Student GPA");
            System.out.println("9 Reports");
            System.out.println("10 Exit");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                System.out.print("ID: "); String id = sc.nextLine();
                System.out.print("First: "); String fn = sc.nextLine();
                System.out.print("Last: "); String ln = sc.nextLine();
                System.out.print("Email: "); String eml = sc.nextLine();
                System.out.print("GPA: "); double gpa = Double.parseDouble(sc.nextLine());
                System.out.print("Major: "); String major = sc.nextLine();
                System.out.print("Year: "); int year = Integer.parseInt(sc.nextLine());
                sm.addStudent(new Student(id, fn, ln, eml, gpa, major, year));
            } else if (choice.equals("2")) {
                System.out.print("ID: "); System.out.println(sm.removeStudent(sc.nextLine()));
            } else if (choice.equals("3")) {
                System.out.print("ID: "); System.out.println(sm.findStudent(sc.nextLine()));
            } else if (choice.equals("4")) {
                sm.printAllStudents();
            } else if (choice.equals("5")) {
                System.out.print("Code: "); String code = sc.nextLine();
                System.out.print("Name: "); String name = sc.nextLine();
                System.out.print("Credits: "); int cr = Integer.parseInt(sc.nextLine());
                System.out.print("Instructor: "); String ins = sc.nextLine();
                System.out.print("Max: "); int max = Integer.parseInt(sc.nextLine());
                cm.addCourse(new Course(code, name, cr, ins, max));
            } else if (choice.equals("6")) {
                System.out.print("Student ID: "); String sid = sc.nextLine();
                System.out.print("Course Code: "); String cc = sc.nextLine();
                System.out.print("Semester: "); String sem = sc.nextLine();
                em.enrollStudent(sid, cc, sem);
            } else if (choice.equals("7")) {
                System.out.print("Enrollment ID: "); String eid = sc.nextLine();
                System.out.print("Grade: "); String g = sc.nextLine();
                em.assignGrade(eid, g);
            } else if (choice.equals("8")) {
                System.out.print("Student ID: "); String sid = sc.nextLine();
                System.out.println(em.calculateStudentGpa(sid));
            } else if (choice.equals("9")) {
                System.out.println("1 Student report");
                System.out.println("2 Course report");
                System.out.println("3 Major report");
                System.out.println("4 Honor roll");
                String r = sc.nextLine();
                if (r.equals("1")) { System.out.print("Student ID: "); rg.generateStudentReport(sc.nextLine(), sm, em); }
                else if (r.equals("2")) { System.out.print("Course Code: "); rg.generateCourseReport(sc.nextLine(), cm, em); }
                else if (r.equals("3")) { System.out.print("Major: "); rg.generateMajorReport(sc.nextLine(), sm); }
                else if (r.equals("4")) { System.out.print("Min GPA: "); rg.generateHonorRollReport(sm, Double.parseDouble(sc.nextLine())); }
            } else if (choice.equals("10")) {
                break;
            }
        }
    }
}