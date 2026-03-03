import java.util.ArrayList;

public class EnrollmentManager {
    private ArrayList<Enrollment> enrollments = new ArrayList<>();
    private int nextId = 1;

    private String nextEnrollmentId() {
        return String.format("E%03d", nextId++);
    }

    public void enrollStudent(String studentId, String courseCode, String semester) {
        enrollments.add(new Enrollment(nextEnrollmentId(), studentId, courseCode, semester));
    }

    public boolean dropEnrollment(String enrollmentId) {
        Enrollment e = findEnrollment(enrollmentId);
        if (e == null) return false;
        return enrollments.remove(e);
    }

    public Enrollment findEnrollment(String enrollmentId) {
        for (Enrollment e : enrollments) if (e.getEnrollmentId().equals(enrollmentId)) return e;
        return null;
    }

    public ArrayList<Enrollment> getEnrollmentsByStudent(String studentId) {
        ArrayList<Enrollment> out = new ArrayList<>();
        for (Enrollment e : enrollments) if (e.getStudentId().equals(studentId)) out.add(e);
        return out;
    }

    public ArrayList<Enrollment> getEnrollmentsByCourse(String courseCode) {
        ArrayList<Enrollment> out = new ArrayList<>();
        for (Enrollment e : enrollments) if (e.getCourseCode().equalsIgnoreCase(courseCode)) out.add(e);
        return out;
    }

    public void assignGrade(String enrollmentId, String grade) {
        Enrollment e = findEnrollment(enrollmentId);
        if (e != null) e.setGrade(grade);
    }

    public double calculateStudentGpa(String studentId) {
        ArrayList<Enrollment> es = getEnrollmentsByStudent(studentId);
        double sum = 0;
        int count = 0;
        for (Enrollment e : es) {
            if (e.getGrade() != null) {
                sum += e.getGradePoints();
                count++;
            }
        }
        return count == 0 ? 0.0 : sum / count;
    }

    public ArrayList<String> getStudentsInCourse(String courseCode) {
        ArrayList<String> out = new ArrayList<>();
        for (Enrollment e : getEnrollmentsByCourse(courseCode)) if (!out.contains(e.getStudentId())) out.add(e.getStudentId());
        return out;
    }

    public int getEnrollmentCount(String courseCode) {
        return getEnrollmentsByCourse(courseCode).size();
    }

    public void printAllEnrollments() {
        for (Enrollment e : enrollments) System.out.println(e);
    }

    public ArrayList<Enrollment> getAllEnrollments() {
        return new ArrayList<>(enrollments);
    }
}