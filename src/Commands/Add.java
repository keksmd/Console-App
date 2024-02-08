package Commands;

import Main.App;
import Main.Command;
import Submarines.Chapter;
import Submarines.Coordinates;
import Submarines.SpaceMarine;
import Submarines.Weapon;
import utilites.interfaces.methods;

import java.util.Scanner;

import static utilites.CheckingReader.checkyRead;

public class Add extends Command implements methods{
    public void calling(String[] inputs){
        App.que.add(
                new SpaceMarine(
                        (String) checkyRead("s","more length 0",inputs[0]),

                        new Coordinates(
                                (Long)checkyRead("l","less than 626","Введите целочисленную x-координату(x<=625",String.valueOf(new Scanner(System.in).nextLong())) ,
                                (Float) checkyRead("f","more than -353.0","Введите y-координату в формате деcятичной дроби(y>=-354.0)", String.valueOf( new Scanner(System.in).nextFloat()))),

                        (Long)checkyRead("l",inputs[1]),
                (Boolean) checkyRead("b",inputs[2]),
                (Float)checkyRead("f",inputs[3]),

                        Weapon.choose(
                        (String)checkyRead("s", """
                                Введите одно из названия для оружия:
                                 BOLT_PISTOL,
                                    COMBI_PLASMA_GUN,
                                    GRENADE_LAUNCHER,
                                    INFERNO_PISTOL,
                                    MULTI_MELTA""",String.valueOf( new Scanner(System.in).nextLine()))),
                new Chapter(
                        (String)checkyRead("s","Введите название главы",String.valueOf( new Scanner(System.in).nextLine())),
                        (String)checkyRead("s","Введите название мира",String.valueOf( new Scanner(System.in).nextLine())) )));

    }
}
