import java.util.ArrayList;

public class ReportGenerator {
    public void generateStudentReport(String studentId, StudentManager sm, EnrollmentManager em) {
        Student s = sm.findStudent(studentId);
        if (s == null) { System.out.println("Student not found"); return; }
        System.out.println(s);
        ArrayList<Enrollment> es = em.getEnrollmentsByStudent(studentId);
        for (Enrollment e : es) System.out.println(e);
        System.out.println("GPA: " + em.calculateStudentGpa(studentId));
    }

    public void generateCourseReport(String courseCode, CourseManager cm, EnrollmentManager em) {
        Course c = cm.findCourse(courseCode);
        if (c == null) { System.out.println("Course not found"); return; }
        System.out.println(c);
        ArrayList<Enrollment> es = em.getEnrollmentsByCourse(courseCode);
        for (Enrollment e : es) System.out.println(e);
        System.out.println("Enrollment count: " + es.size());
    }

    public void generateMajorReport(String major, StudentManager sm) {
        ArrayList<Student> ms = sm.getStudentsByMajor(major);
        for (Student s : ms) System.out.println(s);
        System.out.println("Average GPA: " + sm.getAverageGpaByMajor(major));
    }

    public void generateHonorRollReport(StudentManager sm, double minGpa) {
        ArrayList<Student> hs = sm.getHonorStudents(minGpa);
        for (Student s : hs) System.out.println(s);
    }
}