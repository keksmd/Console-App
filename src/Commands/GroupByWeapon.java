package Commands;

import Main.App;
import Main.Command;
import Submarines.Weapon;
import utilites.interfaces.methods;

public class GroupByWeapon extends Command implements methods{
    public void calling(){
        for (Weapon gun:Weapon.values()) {
            System.out.printf("%s : %d%n",gun.name(),App.que.stream().filter(w->w.getWeaponType() == gun).count());

        }

    }
}
