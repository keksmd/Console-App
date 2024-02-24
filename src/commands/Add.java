package commands;

import main.CollectionManager;
import spacemarines.Chapter;
import spacemarines.Coordinates;
import spacemarines.SpaceMarine;
import spacemarines.Weapon;
import utilites.interfaces.methods;

import static utilites.CheckingReader.checkyRead;

public class Add extends CollectionManager implements methods{
    final String[] args;
    public Add(String[] args){
        this.args = args;
    }
    public boolean calling(){

        CollectionManager.collection.add(
                new SpaceMarine(
                        (String) checkyRead("s","more length 0","",args[0]),
                        new Coordinates(
                                (Long)checkyRead("l","less than 626","Введите целочисленную x-координату (x<=625)","sin") ,
                                //(Float)checkyRead("f","more than -353.0","Введите y-координату в формате деcятичной дроби (y>=-354.0)","sin")),
                                (Float)checkyRead("f","","Введите y-координату в формате деcятичной дроби (y>=-354.0)","sin")),
                        (Long)checkyRead("l","more than 0","",args[1]),
                        (Boolean) checkyRead("b",args[2]),
                        (Float)checkyRead("f",args[3]),
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

        return true;

    }
}
