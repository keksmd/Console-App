package commands;

import main.App;
import main.Command;
import submarines.Chapter;
import submarines.Coordinates;
import submarines.SpaceMarine;
import submarines.Weapon;
import utilites.interfaces.methods;

import java.time.LocalDate;

import static utilites.CheckingReader.checkyRead;

public class Add extends Command implements methods{
    final String[] args;
    public Add(String[] args){
        this.args = args;
    }
    public boolean calling(){
        String[] inputs = args;
        App.collection.add(
                new SpaceMarine(
                        (String) checkyRead("s","more length 0","",inputs[1]),
                        new Coordinates(
                                (Long)checkyRead("l","less than 626","Введите целочисленную x-координату (x<=625)","sin") ,
                                //(Float) checkyRead("f","more than -353.0","Введите y-координату в формате деcятичной дроби (y>=-354.0)","3.3")),
                                6.6f),
//3.3f),
                        (Long)checkyRead("l",inputs[2]),
                (Boolean) checkyRead("b",inputs[3]),
                //(Float)checkyRead("f","4.4"),
                        5.5f,
                        //4.4f,
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
                        (String)checkyRead("s","more length 0","Введите название мира","sin"))));

        App.lastUpdated = LocalDate.now();
        return true;

    }
}
