package utilites;

import main.CollectionManager;
import spacemarines.SpaceMarine;

import java.util.HashMap;

public class GetById {
    static HashMap<Integer,SpaceMarine> map = new HashMap<>();

    public static SpaceMarine getById(int id){
        CollectionManager.collection.forEach(w->map.put(w.getId(),w));
        return map.get(id);
    }
}
