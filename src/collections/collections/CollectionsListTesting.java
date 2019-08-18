package collections.collections;

import java.util.*;

public class CollectionsListTesting {

    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();

        li.add(5);
        li.add(6);
        li.add(7);
        li.add(4);

        System.out.println(li.toString());

        //shuffle
        //shuffle only works with lists!!!!!!!!!!
        Collections.shuffle(li);
        System.out.println(li);

        //addall
        //li.addAll(2,4,4,5); //what you can't with a list
        Collections.addAll(li, 1,2,3,4,5,6); //you can do with the Collections onto a List!
        System.out.println(li);

        //swap
        Collections.swap(li, 0,1);
        System.out.println("after swap "+li);

        //binsearch
        //you should use the following with a sorted list
        System.out.println(Collections.binarySearch(li, 20));
        System.out.println(Collections.binarySearch(li, 4)); // 4 is found on indexes 1 and 7

        //sort
        li.sort((a,b) -> a.compareTo(b));
        System.out.println(li);
        //so far so good!
        Collections.sort(li, (a,b)-> -a.compareTo(b));
        System.out.println(li);

        //freq
        System.out.println("freq of 5 is " + Collections.frequency(li,(Integer)5));

        //obviously assigning it won't copy the list
        var li2 = li;
        li2.sort((a,b) -> a.compareTo(b));
        System.out.println("after copy "+li);

        //real copy
        li2 = new ArrayList<>(li);
        li2.sort((a,b) -> -a.compareTo(b));
        System.out.println("after copy li1 "+li);
        System.out.println("after copy li2 "+li2);
        //now we have 2 lists

        Collections.copy(li2,li); //copy replaces!!!!!
        System.out.println(li2);

        Collections.reverseOrder();
//        Collections.reverseOrder(new Comparator<Object>() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return 0;
//            }
//        });

        Comparator<Integer> rev = Collections.reverseOrder((a,b) -> ((Comparable<Integer>)a).compareTo(((Integer) b)));
        li2.sort(rev);
        System.out.println(li2);

        //disjoint
        var li3 = li2.subList(5,10);
        var li4 = li2.subList(0,5);
        System.out.println("wiiii disjoint!!!! " + Collections.disjoint(li3,li4)); //should get a true... (it is disjoint!)
        System.out.println("wiiii disjoint!!!! " + Collections.disjoint(li2,li3)); //should get a false... (it is not disjoint!)





    }
}
