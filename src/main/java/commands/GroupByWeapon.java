package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import spacemarines.SpaceMarine;
import spacemarines.Weapon;
import utilites.interfaces.methods;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupByWeapon extends Command implements methods{
    public Response calling(String[] a){
        Response resp = super.calling(a);
        StringBuilder s = new StringBuilder();
        Arrays.stream(Weapon.values()).forEach(gun -> s.append(String.format("%s : %d%n", gun.name(), CollectionManager.collection.stream().filter(w -> w.getWeaponType() == gun).count())));
        resp.addMessage(s.toString());
        return resp;
    }

    private final String name = "group_counting_by_weapon_type";

}
