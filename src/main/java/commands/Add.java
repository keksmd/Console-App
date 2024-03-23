package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import spacemarines.Chapter;
import spacemarines.Coordinates;
import spacemarines.SpaceMarine;
import spacemarines.Weapon;
import utilites.interfaces.methods;

import java.util.PriorityQueue;
import java.util.stream.Collectors;

import static utilites.CheckingReader.checkyRead;

public class Add extends Command implements methods{
    public Add(String[] a){
        args =  a;
    }
    String[] args;

    SpaceMarine spm;
    public Response calling(){
        Response resp = super.calling();


        CollectionManager.collection.add(
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
            CollectionManager.collection = CollectionManager.collection.stream().sorted().collect(Collectors.toCollection(PriorityQueue::new));

        return resp ;

    }

}
