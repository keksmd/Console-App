package utilites;

import main.CollectionManager;
import spacemarines.SpaceMarine;

import java.util.HashMap;

public class GetById {
    static final HashMap<Integer,SpaceMarine> map = new HashMap<>();
    static {CollectionManager.getCollection().forEach(w->map.put(w.getId(),w));}

    public static SpaceMarine getById(int id){
        return map.get(id);
    }
}
