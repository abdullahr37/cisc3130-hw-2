import java.util.ArrayList;

public class ArrayListUtils {
    public static <T> void swap(ArrayList<T> list, int i, int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    public static <T extends Comparable<T>> T findMax(ArrayList<T> list) {
        if (list.isEmpty()) return null;
        T max = list.get(0);
        for (T x : list) if (x != null && x.compareTo(max) > 0) max = x;
        return max;
    }

    public interface Predicate<T> {
        boolean test(T x);
    }

    public static <T> ArrayList<T> filter(ArrayList<T> list, Predicate<T> p) {
        ArrayList<T> out = new ArrayList<>();
        for (T x : list) if (p.test(x)) out.add(x);
        return out;
    }

    public static <T> void reverse(ArrayList<T> list) {
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) swap(list, i, j);
    }

    public static <T> ArrayList<T> merge(ArrayList<T> a, ArrayList<T> b) {
        ArrayList<T> out = new ArrayList<>();
        out.addAll(a);
        out.addAll(b);
        return out;
    }

    public static <T extends Number> double sum(ArrayList<T> nums) {
        double s = 0;
        for (T n : nums) if (n != null) s += n.doubleValue();
        return s;
    }

    public static <T extends Number> double average(ArrayList<T> nums) {
        if (nums.isEmpty()) return 0;
        return sum(nums) / nums.size();
    }

    public static <T extends Number & Comparable<T>> ArrayList<T> filterAbove(ArrayList<T> nums, T t) {
        ArrayList<T> out = new ArrayList<>();
        for (T n : nums) if (n != null && n.compareTo(t) > 0) out.add(n);
        return out;
    }

    public static double sumNumbers(ArrayList<? extends Number> nums) {
        double s = 0;
        for (Number n : nums) if (n != null) s += n.doubleValue();
        return s;
    }

    public static void addNumbers(ArrayList<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    public static void printList(ArrayList<?> list) {
        for (Object o : list) System.out.println(o);
    }
}