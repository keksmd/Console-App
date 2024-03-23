package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import spacemarines.Chapter;
import spacemarines.Coordinates;
import spacemarines.SpaceMarine;
import spacemarines.Weapon;
import utilites.interfaces.methods;

import java.util.Comparator;

import static utilites.CheckingReader.checkyRead;

public class AddIfMax extends Command implements methods{
    public AddIfMax(String[] a){
        args =a;

    }
    String[] args;
    public Response calling() {
        Response resp = super.calling();
        SpaceMarine spm = (
                new SpaceMarine(
                        (String) checkyRead("s",args[0]),
                        new Coordinates(
                                (Long)checkyRead("l",args[1]) ,
                                (Float)checkyRead("f",args[2])),
                        (Long)checkyRead("l",args[3]),
                        (Boolean) checkyRead("b",args[4]),
                        (Float)checkyRead("f",args[5]),
                        Weapon.choose(
                                (String)checkyRead("s",args[6])),
                        new Chapter(
                                (String)checkyRead("s",args[7]),
                                (String)checkyRead("s",args[8]))));
        if(spm.compareTo(CollectionManager.collection.stream().max(Comparator.naturalOrder()).get())>0)
            new Add(args).calling();
        else{
            resp.setSuccess(false);
        }
        return resp;
    }
}
