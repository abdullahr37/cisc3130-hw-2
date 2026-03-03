import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        if (findCourse(course.getCourseCode()) != null) return;
        courses.add(course);
    }

    public Course findCourse(String courseCode) {
        for (Course c : courses) if (c.getCourseCode().equalsIgnoreCase(courseCode)) return c;
        return null;
    }

    public ArrayList<Course> getCoursesByInstructor(String instructor) {
        ArrayList<Course> out = new ArrayList<>();
        for (Course c : courses) if (c.getInstructor().equalsIgnoreCase(instructor)) out.add(c);
        return out;
    }

    public ArrayList<Course> getAvailableCourses(String studentId, StudentManager sm, EnrollmentManager em) {
        ArrayList<Course> out = new ArrayList<>();
        ArrayList<Enrollment> es = em.getEnrollmentsByStudent(studentId);

        for (Course c : courses) {
            if (em.getEnrollmentCount(c.getCourseCode()) >= c.getMaxEnrollment()) continue;

            boolean already = false;
            for (Enrollment e : es) if (e.getCourseCode().equalsIgnoreCase(c.getCourseCode())) already = true;
            if (already) continue;

            boolean prereqOk = true;
            for (String prereq : c.getPrerequisites()) {
                boolean passed = false;
                for (Enrollment e : es) {
                    if (e.getCourseCode().equalsIgnoreCase(prereq) && e.isPassing()) passed = true;
                }
                if (!passed) prereqOk = false;
            }
            if (!prereqOk) continue;

            out.add(c);
        }

        return out;
    }

    public void printAllCourses() {
        for (Course c : courses) System.out.println(c);
    }

    public int getTotalCourses() {
        return courses.size();
    }

    public ArrayList<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }
}