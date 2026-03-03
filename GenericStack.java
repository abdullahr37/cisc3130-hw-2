import java.util.ArrayList;

public class GenericStack<T> {
    private ArrayList<T> items = new ArrayList<>();

    public void push(T x) { items.add(x); }
    public T pop() { return items.isEmpty() ? null : items.remove(items.size() - 1); }
    public T peek() { return items.isEmpty() ? null : items.get(items.size() - 1); }
    public boolean isEmpty() { return items.isEmpty(); }
    public int size() { return items.size(); }
    public void clear() { items.clear(); }
}