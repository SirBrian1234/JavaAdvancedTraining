package collections;

import collections.element.Element;
import collections.element.Fruit;

import java.util.*;

/**
 * This class tests all Set implementations
 * HashSet
 * LinkedHashSet
 * TreeSet
 * EnumSet
 */
public class TestingSets {
    public static void main(String[] args) {

        /*
            HASHED SET
         */
        System.out.println("hashed set");

        Set<Element> set1 = new HashSet<>();

        set1.add(new Element(10, "hello"));
        set1.add(new Element(10, "hello")); //equals with previous
        set1.add(new Element(11, "hello"));
        set1.add(new Element(11, "hello2"));
        set1.add(new Element(12, "hel2"));

        System.out.println(set1.size()); //expect to be 4!
        System.out.println("set contains " + set1.contains(new Element(10,"hello")));
        System.out.println(set1); //you will NOT see the elements in a particular order

        /*
            TREE SET
         */
        System.out.println("\ntree set");

        // Case 1
        // UncomparableElement does not implement comparable!
        // adding one element will result in a runtime exception!
//        Set<UncomparableElement> set2 = new TreeSet<>();
//        set2.add(new UncomparableElement(10, "hello"));

        // Case 2
        // here we have made a new tree set with a descending comparator
        // equals and the Element implements comparable
        Set<Element> set21 = new TreeSet<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return -o1.compareTo(o2); //did you see the minus sign?
            }
        });

        set21.add(new Element(10, "hello"));
        set21.add(new Element(10, "hello")); //this will be discarded
        set21.add(new Element(11, "hello"));
        set21.add(new Element(11, "hello3")); //this will be discarded even though name is different as
        //the internal compareTo method only takes into account the value!
        set21.add(new Element(12, "hello"));

        System.out.println(set21.size()); //expect to have two less, as Element compare to works only with value!!!!
        System.out.println(set21); //expect to see the elements in the reverse order

        //can you make a comparator a lambda???
        Comparator<Element> c = (e1, e2) -> e1.compareTo(e2);
        //Therefore...
        Set<Element> set22 = new TreeSet<>(c);
        //or
        Set<Element> set23 = new TreeSet<>((e1,e2) -> e1.compareTo(e2));

        /*
            LINKED HASH SET
         */
        System.out.println("\nlinked hash set");

        Set<Element> set3 = new LinkedHashSet<>();

        set3.add(new Element(10, "hello"));
        set3.add(new Element(10, "hello"));
        set3.add(new Element(11, "hello"));
        set3.add(new Element(11, "hello3"));
        set3.add(new Element(12, "hello"));


        System.out.println(set3.size()); //expect to have all of them except one
        System.out.println(set3); //expect to see the elements in the order they where placed

        /*
            ENUM SET
         */
        System.out.println("\nenum set");
        EnumSet<Fruit> set4 = EnumSet.of(Fruit.APPLE, Fruit.APPLE, Fruit.APPLE);
        System.out.println(set4.toString()); //ONLY APPLE after all it's a set!
        set4 = EnumSet.of(Fruit.APPLE, Fruit.PINEAPPLE, Fruit.BANANA);
        System.out.println(set4.toString());

    }
}
