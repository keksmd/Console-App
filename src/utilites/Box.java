package utilites;

public class Box<T>{
    public Box(T o){
        obj = o;
    }
    final T obj;

    public T getObj() {
        return obj;
    }
}
