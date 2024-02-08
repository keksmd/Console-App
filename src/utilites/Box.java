package utilites;

public class Box<T>{
    public Box(T o){
        obj = o;
    }
    T obj;

    public T getObj() {
        return obj;
    }
}
