import java.util.ArrayList;
import java.util.Random;

public class ArrayListVsArrayDemo {
    public static void run() {
        int n = 10000;

        long t1 = System.currentTimeMillis();
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new Student("S" + i, "F", "L", "e@u.edu", 3.0, "CS", 2));
        long t2 = System.currentTimeMillis();

        Student[] arr = new Student[n];
        long t3 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) arr[i] = new Student("S" + i, "F", "L", "e@u.edu", 3.0, "CS", 2);
        long t4 = System.currentTimeMillis();

        Random r = new Random();
        long t5 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) list.get(r.nextInt(n));
        long t6 = System.currentTimeMillis();

        long t7 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) arr[r.nextInt(n)];
        long t8 = System.currentTimeMillis();

        System.out.println("Add 10,000: ArrayList " + (t2 - t1) + "ms, Array " + (t4 - t3) + "ms");
        System.out.println("Access 1,000 random: ArrayList " + (t6 - t5) + "ms, Array " + (t8 - t7) + "ms");
        System.out.println("ArrayList resizes easily; arrays are fixed-size.");
    }
}