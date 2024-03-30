/**
 * Класс управляющий основной коллекцией
 */
package main;

import spacemarines.SpaceMarine;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class CollectionManager<C extends Collection<T>, T>  {
    public static void add(SpaceMarine spm){
        collection.add(spm);
    }
    public static Stream<SpaceMarine> getCollectionStream(){
        return collection.stream();
    }
    public static void clear(){
        collection.clear();
    }

    /**
     * Основная коллекция
     */

    private static PriorityQueue<SpaceMarine> collection =new PriorityQueue<>();

    public static PriorityQueue<SpaceMarine> getCollection() {
        return collection;
    }
    public static int getCollectionSize(){
        return collection.size();
    }

    public static void setCollection(PriorityQueue<SpaceMarine> collection) {
        CollectionManager.collection = collection;
    }

    private static final HashSet<String> wasExecuted = new HashSet<>();
    public static Date lastUpdated;


    public static HashSet<String> getWasExecuted(){
        return wasExecuted;
    }



}
