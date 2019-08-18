package collections.collections;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class will test the support class Collections from the collection framework
 *
 */
public class CollectionsTesting {

    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();

        li.add(5);
        li.add(6);
        li.add(7);
        li.add(4);

        System.out.println(li.toString());

        //EMPTY COLLECTIONS
        //An empty list is a nice object to be returned from services when there are no elements
        //instead of null!
        //an empty stays empty! if an element is attempted to be added a unsupported operation exception is thrown
        List li2 = Collections.EMPTY_LIST;
        //or...
        li2 = Collections.emptyList();

//        li2.add(5); //unsupported operation exception
//        li2.add(15);
//        li2.remove((Integer)5); //////////////////DANGER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        System.out.println(li2);

        //UNMODIFIABLE COLLECTIONS
        // Let's see the unmodifiable list
        List<Integer>li3 = Collections.unmodifiableList(li);
        System.out.println("unmodifiable list " + li3);
        //li3.add(6); //UnsupportedOperationException
        //li3.remove((Integer) 7); //UnsupportedOperationException

        //return to the client an empty unmodifiable list!
        System.out.println("empty unmodifiable list for naughty clients! " + Collections.unmodifiableList(Collections.EMPTY_LIST));

        //SET!
        //min works with all collections
        System.out.println("min " + Collections.min(li));
        System.out.println("max " + Collections.max(li));

        System.out.println("set");
        Set<Integer> set = new HashSet<>(li);
        System.out.println(set);

        //Collections.shuffle(set); //nononono!!!!
        System.out.println("min " + Collections.min(set));
        System.out.println("max " + Collections.max(set));

        Set<Integer> set2 = Collections.EMPTY_SET;
        set2 = Collections.emptySet();
        // This is how you get an empty set of Integer
        // public static final <T> Set<T> emptySet() {
        //        return (Set<T>) EMPTY_SET;
        // }

        Set<Integer> uset = Collections.unmodifiableSet(set);
        //uset.add(5); // UnsupportedOperationException

        Collections.unmodifiableCollection(uset);


        Map<Integer,Boolean> m = new HashMap<>();
        Collections.unmodifiableMap(m);
        //Collections.unmodifiableCollection(m); //as expected map cannot generalize into a collection, however...
        //the following are valid
        Collections.unmodifiableCollection(m.entrySet());
        Collections.unmodifiableCollection(m.keySet());
        Collections.unmodifiableCollection(m.values());

        //li.add((Integer) new Object()); //ClassCastException... li is obviously a typesafe list from compile time
        //we used type erasure here!
        List unchecked = new LinkedList<>();
        unchecked.add((Integer) 5);
        unchecked.add(new Object());
        unchecked.add("hello!");
        unchecked.add((Integer) 20);
        // luckily it didn't blow up up to this point!
        System.out.println((Integer) unchecked.get(0));
        // System.out.println((Integer) unchecked.get(1)); //boom... ClassCastException...
        // we are obviously walking into a landmine...

        List<Integer> notSoSafe = unchecked;
        //notSoSafe.add("hello!"); //caught at compile time!
        // but what if...
        //Integer i = notSoSafe.get(2); //runtime ClassCastException!!!!
        //our poor list still has adaptation problems and compile time can't defend it...

        //let's try and use checkedList
        List stillUnsafe = Collections.checkedList(unchecked, Integer.class);
        stillUnsafe.add(25);
        //safe.add("hi!"); //ClassCastException... prevents us from adding an element other than Integer.class at runtime
        //Integer i = (Integer) safe.get(2); //runtime ClassCastException!!!!
        System.out.println("still unsafe " + stillUnsafe); //however the checked list does not drop off all the non Integer elements!!!!!
        System.out.println("still unsafe size " + stillUnsafe.size());

        //do it again properly this time eliminate different class elements, check and assign!!!
        unchecked = (List) unchecked.stream().filter(e -> e instanceof Integer).collect(Collectors.toList());
        stillUnsafe = Collections.checkedList(unchecked, Integer.class);
        System.out.println("still unsafe " + stillUnsafe);
        System.out.println("still unsafe size " + stillUnsafe.size());
        // Now our checked list is truly safe,
        // as it has filtered out all non integer elements!!!

        //alas we can rest by assigning the list to a typesafe list
        //from now on the list will have a compile time check and
        //whoever tries to get the list with its old reference will still get a ClassCastException at runtime!
        List<Integer> safer = stillUnsafe;
        safer.add(1);
        //safer.add("hello");
        stillUnsafe.add(55);
        //safe.add("hello!"); //ClassCastException
        System.out.println(safer);
    }

}
