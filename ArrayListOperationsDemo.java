import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListOperationsDemo {
    public static void run() {
        Student[] arr = {
                new Student("S001", "Alice", "Smith", "alice@u.edu", 3.8, "CS", 2),
                new Student("S002", "Bob", "Jones", "bob@u.edu", 3.5, "Math", 3)
        };

        ArrayList<Student> list = new ArrayList<>(java.util.Arrays.asList(arr));
        list.add(new Student("S003", "Charlie", "Brown", "c@u.edu", 3.9, "CS", 2));
        list.remove(0);

        Student[] backToArray = list.toArray(new Student[0]);
        System.out.println("ArrayList:");
        for (Student s : list) System.out.println(s);
        System.out.println("Array:");
        for (Student s : backToArray) System.out.println(s);

        ArrayList<Student> students = new ArrayList<>(list);
        if (students.size() >= 2) {
            java.util.List<Student> sub = students.subList(0, 2);
            sub.remove(0);
            System.out.println("After subList remove, original size: " + students.size());
        }

        Collections.sort(students);
        Collections.sort(students, new Comparator<Student>() {
            @Override public int compare(Student a, Student b) {
                return a.getLastName().compareToIgnoreCase(b.getLastName());
            }
        });

        if (!students.isEmpty()) {
            System.out.println("contains first? " + students.contains(students.get(0)));
            System.out.println("indexOf first: " + students.indexOf(students.get(0)));
        }
    }
}