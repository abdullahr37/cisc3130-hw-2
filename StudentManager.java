import java.util.ArrayList;
import java.util.HashSet;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (findStudent(student.getStudentId()) != null) return;
        students.add(student);
    }

    public boolean removeStudent(String studentId) {
        Student s = findStudent(studentId);
        if (s == null) return false;
        return students.remove(s);
    }

    public Student findStudent(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) return s;
        }
        return null;
    }

    public ArrayList<Student> getStudentsByMajor(String major) {
        ArrayList<Student> out = new ArrayList<>();
        for (Student s : students) if (s.getMajor().equalsIgnoreCase(major)) out.add(s);
        return out;
    }

    public ArrayList<Student> getStudentsByYear(int year) {
        ArrayList<Student> out = new ArrayList<>();
        for (Student s : students) if (s.getYear() == year) out.add(s);
        return out;
    }

    public ArrayList<Student> getHonorStudents(double minGpa) {
        ArrayList<Student> out = new ArrayList<>();
        for (Student s : students) if (s.getGpa() >= minGpa) out.add(s);
        return out;
    }

    public double getAverageGpa() {
        if (students.isEmpty()) return 0.0;
        double sum = 0;
        for (Student s : students) sum += s.getGpa();
        return sum / students.size();
    }

    public double getAverageGpaByMajor(String major) {
        ArrayList<Student> ms = getStudentsByMajor(major);
        if (ms.isEmpty()) return 0.0;
        double sum = 0;
        for (Student s : ms) sum += s.getGpa();
        return sum / ms.size();
    }

    public void printAllStudents() {
        for (Student s : students) System.out.println(s);
    }

    public int getTotalStudents() {
        return students.size();
    }

    public ArrayList<String> getAllMajors() {
        HashSet<String> set = new HashSet<>();
        for (Student s : students) set.add(s.getMajor());
        return new ArrayList<>(set);
    }

    public ArrayList<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}