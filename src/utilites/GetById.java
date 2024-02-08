package utilites;

import Main.App;
import Submarines.SpaceMarine;

public class GetById {

    public static SpaceMarine getById(int id){
        SpaceMarine spm  = null;
        if(App.que.stream().anyMatch(w->w.getId() == id)){
            spm = App.que.stream().filter(w->w.getId()==id).findFirst().get();
        }
        return spm;
    }
}
