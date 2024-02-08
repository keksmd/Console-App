package Commands;

import Main.App;
import Main.Command;
import Submarines.Chapter;
import Submarines.Coordinates;
import Submarines.SpaceMarine;
import Submarines.Weapon;
import utilites.interfaces.methods;

import static utilites.CheckingReader.checkyRead;

public class AddIfMax extends Command implements methods{
    public void calling() {
        String name =(String) checkyRead("s", "more length 0", "Введите имя");
                Coordinates coords = new Coordinates(
                        (Long) checkyRead("l", "less than 626", "Введите целочисленную x-координату(x<=625"),
                        (Float) checkyRead("f", "more than -353.0", "Введите y-координату в формате деcятичной дроби(y>=-354.0"));
                Long health = (Long) checkyRead("l", "Введите health");
                boolean loyal = (Boolean) checkyRead("b", "Введите loyal (true/false)");
                Float height = (Float) checkyRead("f", "Введите height");
                Weapon gun = Weapon.choose(
                        (String) checkyRead("s", "Введите одно из названия для оружия:\n BOLT_PISTOL,\n" +
                                "    COMBI_PLASMA_GUN,\n" +
                                "    GRENADE_LAUNCHER,\n" +
                                "    INFERNO_PISTOL,\n" +
                                "    MULTI_MELTA"));
                Chapter chap = new Chapter(
                        (String) checkyRead("s", "Введите название главы"),
                        (String) checkyRead("s", "Введите название мира"));

        if(new SpaceMarine(name,coords,health,loyal,height,gun,chap).compareTo(App.que.peek())>0){
            App.que.add(
                    new SpaceMarine(name,coords,health,loyal,height,gun,chap));
        }
    }
}
