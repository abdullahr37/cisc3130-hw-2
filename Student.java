import java.util.Objects;

public class Student implements Comparable<Student> {
    private String studentId, firstName, lastName, email, major;
    private double gpa;
    private int year;

    public Student(String studentId, String firstName, String lastName, String email, double gpa, String major, int year) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gpa = gpa;
        this.major = major;
        this.year = year;
    }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getFullName() { return firstName + " " + lastName; }

    @Override
    public String toString() {
        return studentId + " | " + getFullName() + " | " + email + " | " + gpa + " | " + major + " | " + year;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return Objects.equals(studentId, other.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(o.gpa, this.gpa);
    }
}