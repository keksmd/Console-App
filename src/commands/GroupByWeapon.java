package commands;

import main.CollectionManager;
import spacemarines.Weapon;
import utilites.interfaces.methods;

public class GroupByWeapon extends CollectionManager implements methods{
    public boolean calling(){
        for (Weapon gun:Weapon.values()) {
            System.out.printf("%s : %d%n",gun.name(), CollectionManager.collection.stream().filter(w->w.getWeaponType() == gun).count());

        }
        return true;
    }
}
