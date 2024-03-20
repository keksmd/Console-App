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
    public AddIfMax(){

    }
    public Response calling() {
        Response resp = super.calling();
        SpaceMarine spm = new SpaceMarine(
                (String) checkyRead("s","more length 0","Введите имя","sin"),
                new Coordinates(
                        (Long)checkyRead("l","less than 626","Введите целочисленную x-координату (x<=625)","sin") ,
                        //(Float)checkyRead("f","more than -353.0","Введите y-координату в формате деcятичной дроби (y>=-354.0)","sin")),
                        (Float)checkyRead("f","","Введите y-координату в формате деcятичной дроби (y>=-354.0)","sin")),
                (Long)checkyRead("l","more than 0","Введите здоровье","sin"),
                (Boolean) checkyRead("b","Введите булевое значение true/false преданности","sin"),
                (Float)checkyRead("f","Введите десятичное число,характеризующее длинну","sin"),
                Weapon.choose(
                        (String)checkyRead("s","is weapon","""
                                Введите одно из названия для оружия:
                                    BOLT_PISTOL,
                                    COMBI_PLASMA_GUN,
                                    GRENADE_LAUNCHER,
                                    INFERNO_PISTOL,
                                    MULTI_MELTA""","sin")),
                new Chapter(
                        (String)checkyRead("s","more length 0","Введите название главы","sin"),
                        (String)checkyRead("s","more length 0","Введите название мира","sin")));

        if(spm.compareTo(CollectionManager.collection.stream().max(Comparator.naturalOrder()).get())>0)
            new Add().calling(spm);
        else{
            resp.setSuccess(false);
        }
        return resp;
    }
}
