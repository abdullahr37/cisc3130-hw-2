import java.util.ArrayList;

public class Course {
    private String courseCode, courseName, instructor;
    private int credits, maxEnrollment;
    private ArrayList<String> prerequisites;

    public Course(String courseCode, String courseName, int credits, String instructor, int maxEnrollment) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.instructor = instructor;
        this.maxEnrollment = maxEnrollment;
        this.prerequisites = new ArrayList<>();
    }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public int getMaxEnrollment() { return maxEnrollment; }
    public void setMaxEnrollment(int maxEnrollment) { this.maxEnrollment = maxEnrollment; }

    public void addPrerequisite(String courseCode) {
        if (!prerequisites.contains(courseCode)) prerequisites.add(courseCode);
    }

    public boolean hasPrerequisite(String courseCode) {
        return prerequisites.contains(courseCode);
    }

    public ArrayList<String> getPrerequisites() {
        return new ArrayList<>(prerequisites);
    }

    @Override
    public String toString() {
        return courseCode + " | " + courseName + " | " + credits + " | " + instructor + " | " + maxEnrollment + " | " + prerequisites;
    }
}