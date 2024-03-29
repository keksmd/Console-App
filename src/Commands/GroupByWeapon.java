package Commands;

import Main.App;
import Main.Command;
import Submarines.Weapon;
import utilites.interfaces.methods;

public class GroupByWeapon extends Command implements methods{
    public boolean calling(){
        for (Weapon gun:Weapon.values()) {
            System.out.printf("%s : %d%n",gun.name(),App.collection.stream().filter(w->w.getWeaponType() == gun).count());

        }
        return true;
    }
}
