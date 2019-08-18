package collections;

import collections.element.Element;
import collections.element.Fruit;

import java.util.*;

public class TestingMaps {

    public static void main(String[] args) {
        /*
            Hash map
         */
        HashMap<Integer, Boolean> h = new HashMap<>();
        h.put(44, true);
        h.put(15, false);
        h.put(30, true);
        h.put(22, false);
        h.put(22, true); //duplicate key, different value - it results in updating the value for the given key

        System.out.println(h.size());
        System.out.println(h.toString());

        System.out.println(h.containsKey(30));
        System.out.println(h.containsKey(31)); //31 is not there - false
        System.out.println(h.containsValue(true));
        System.out.println(h.containsValue(false));

        System.out.println("I got: "+h.get(15)); // get does not remove!!!!
        System.out.println(h.size());
        System.out.println(h.toString());

        System.out.println("I got: "+h.remove(15)); // does a removal!!!!
        System.out.println("I got: "+h.remove(30, false)); // does not remove bc the value in key is not the given
        System.out.println(h.size());
        System.out.println(h.toString());

        //values() does not return a SET as
        //different keys may have the same value!!!
        //therefore duplicate values may be found!
        //and it returns a collection
        Collection<Boolean> vals = h.values();
        System.out.println("values() "+vals);
        //let's see if we can eliminate duplicates with a set
        HashSet<Boolean> hs = new HashSet<>(vals);
        System.out.println("hashedset "+hs);

        //keys are returned as a set because they are unique
        Set<Integer> keys = h.keySet();
        System.out.println(keys); //we get them in the order they appear on the map

        //entry set returns a set view of the map
        //it is a set because the unique keys guarantee
        //that each entry may be unique as well
        Set<Map.Entry<Integer, Boolean>> entries = h.entrySet();
        System.out.println("entries "+entries);

        //static map
        Map map = Map.of(1,2,11,1,12,1,2,1); //if duplicate key it may throw a runtime
        System.out.println("map "+map);

        //TreeMap
        TreeMap<Element, Fruit> treeMap = new TreeMap<>((e1,e2) -> e1.compareTo(e2));
        treeMap.put(new Element(15,"Pakis"), Fruit.PINEAPPLE);
        treeMap.put(new Element(17,"Takis"), Fruit.STRAWBERRY);
        treeMap.put(new Element(16,"Lakis"), Fruit.STRAWBERRY);


        System.out.println(treeMap);
        System.out.println("elem " + treeMap.get(new Element(15,"Ouiou")));
        // it will retrieve Pakis value which is PINEAPPLE!
        // as strange as it may seem
        // as Element's internal compareTo does not include the name variable!

        //Linked Hash Map
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put(1,"Hello!");
        linkedMap.put(3,"Hi!");
        linkedMap.put(4,"Hi there!");
        linkedMap.put(2,"Wiiii!");

        System.out.println(linkedMap);

        //you can place another map in the constructor
        TreeMap<Integer,String> treeTheReturn = new TreeMap<>(linkedMap);
        System.out.println("treeTheReturn " + treeTheReturn);
        treeTheReturn.clear();
        System.out.println("treeTheReturn " + treeTheReturn);
        //or use putAll as long as the two maps use the same data types!
        treeTheReturn.putAll(linkedMap);
        System.out.println("treeTheReturn " + treeTheReturn);
    }
}
