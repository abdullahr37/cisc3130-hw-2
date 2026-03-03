import java.util.ArrayList;

public class GenericQueue<T> {
    private ArrayList<T> items = new ArrayList<>();

    public void enqueue(T x) { items.add(x); }
    public T dequeue() { return items.isEmpty() ? null : items.remove(0); }
    public T peek() { return items.isEmpty() ? null : items.get(0); }
    public boolean isEmpty() { return items.isEmpty(); }
    public int size() { return items.size(); }
    public void clear() { items.clear(); }
}