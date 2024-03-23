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
    /*private final T type;
    private final Collection<T> collection1;

     */

    public static PriorityQueue<SpaceMarine> collection =new PriorityQueue<>();
    private static final HashSet<String> wasExecuted = new HashSet<>();
    public static Date lastUpdated;

   /* public CollectionManager(Collection<T> collection1,T type,C  typeOfCollection) {
        this.collection1 = collection1;

    }

    */


    public static HashSet<String> getWasExecuted(){
        return wasExecuted;
    }



}
