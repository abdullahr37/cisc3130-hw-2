import java.util.ArrayList;
import java.util.Collections;

public class GenericList<T> {
    private ArrayList<T> items = new ArrayList<>();

    public void add(T x) { items.add(x); }
    public T get(int i) { return items.get(i); }
    public boolean remove(T x) { return items.remove(x); }
    public int size() { return items.size(); }
    public boolean isEmpty() { return items.isEmpty(); }
    public void clear() { items.clear(); }
    public boolean contains(T x) { return items.contains(x); }
    public ArrayList<T> getAll() { return new ArrayList<>(items); }
    public void addAll(ArrayList<T> other) { items.addAll(other); }
    public <U extends T> void addAllFrom(GenericList<U> other) { items.addAll(other.getAll()); }

    @SuppressWarnings({"rawtypes","unchecked"})
    public void sort() { Collections.sort((ArrayList) items); }

    @SuppressWarnings({"rawtypes","unchecked"})
    public T findMax() { return (T) ArrayListUtils.findMax((ArrayList) items); }
}