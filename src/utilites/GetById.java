package utilites;

import Main.App;
import Submarines.SpaceMarine;

public class GetById {

    public static SpaceMarine getById(int id){
        SpaceMarine spm  = null;
        if(App.collection.stream().anyMatch(w->w.getId() == id)){
            spm = App.collection.stream().filter(w->w.getId()==id).findFirst().get();
        }
        return spm;
    }
}
