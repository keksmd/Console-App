package Commands;

import Main.App;
import Main.Command;
import Submarines.Chapter;
import Submarines.Coordinates;
import Submarines.SpaceMarine;
import Submarines.Weapon;
import utilites.interfaces.methods;

import static utilites.CheckingReader.checkyRead;

public class Add extends Command implements methods{
    public void calling(){
        App.que.add(
                new SpaceMarine(
                        (String) checkyRead("s","more length 0","Введите имя"),
                new Coordinates(
                                (Long)checkyRead("l","less than 626","Введите целочисленную x-координату(x<=625") ,
                                (Float) checkyRead("f","more than -353.0","Введите y-координату в формате деcятичной дроби(y>=-354.0") ),
                (Long)checkyRead("l","Введите health"),
                (Boolean) checkyRead("b","Введите loyal (true/false)"),
                (Float)checkyRead("f","Введите height"),
                Weapon.choose(
                        (String)checkyRead("s","Введите одно из названия для оружия:\n BOLT_PISTOL,\n" +
                                "    COMBI_PLASMA_GUN,\n" +
                                "    GRENADE_LAUNCHER,\n" +
                                "    INFERNO_PISTOL,\n" +
                                "    MULTI_MELTA")),
                new Chapter(
                        (String)checkyRead("s","Введите название главы"),
                        (String)checkyRead("s","Введите название мира") )));

    }
}
