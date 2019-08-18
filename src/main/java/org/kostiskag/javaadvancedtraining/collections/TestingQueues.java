package org.kostiskag.javaadvancedtraining.collections;

import org.kostiskag.javaadvancedtraining.collections.element.Element;

import java.util.*;

public class TestingQueues {


    public static void main(String[] args) {

        //queue
        System.out.println("queue");

        Queue<Element> queue = new PriorityQueue<>();

        queue.offer(new Element(10,"hello"));
        queue.offer(new Element(11,"hello"));
        queue.offer(new Element(12,"hello"));

        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }

        //linked list deque as stack
        System.out.println("deque");

        Deque<Element> de = new LinkedList<>();

        de.push(new Element(10,"hello"));
        de.push(new Element(11,"hello"));
        de.push(new Element(12,"hello"));

        while(de.size() != 0) {
            System.out.println(de.pop());
        }


        //array deque as stack
        System.out.println("array deque as deque");

        Deque<Element> de2 = new ArrayDeque<>();

        de2.push(new Element(10,"hello"));
        de2.push(new Element(11,"hello"));
        de2.push(new Element(12,"hello"));

        while(de2.size() != 0) {
            System.out.println(de2.pop());
        }

        Deque<Integer> deq = new ArrayDeque();
        deq.add(1);
        deq.add(2);
        deq.add(3);

        deq.addLast(1);
        deq.addLast(2);
        deq.addLast(3);

        deq.offer(4);
        deq.offer(5);
        deq.offer(6);

        deq.offerLast(4);
        deq.offerLast(5);
        deq.offerLast(6);

        System.out.println(deq.peek() +" "+ deq.peekFirst());

        System.out.println("deq "+deq);
        System.out.println(deq.pop());
        System.out.println(deq.pop());
        System.out.println(deq.element());


    }

}
