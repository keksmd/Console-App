/**
 * Класс управляющий основной коллекцией
 */
package main;

import spacemarines.SpaceMarine;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.PriorityQueue;

public class CollectionManager<C extends Collection<T>, T>  {

    /**
     * Основная коллекция
     */

    public static PriorityQueue<SpaceMarine> collection =new PriorityQueue<>();
    private static final HashSet<String> wasExecuted = new HashSet<>();
    public static Date lastUpdated;


    public static HashSet<String> getWasExecuted(){
        return wasExecuted;
    }



}
