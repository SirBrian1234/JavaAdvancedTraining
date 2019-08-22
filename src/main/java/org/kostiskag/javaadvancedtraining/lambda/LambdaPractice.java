package org.kostiskag.javaadvancedtraining.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaPractice {

    private enum DogType {
        GOLDEN_RETRIEVER,
        CRETAN_RETRIEVER,
        SHEPHERD
    }

    private static class Dog {
        String name;
        DogType race;
        double weight;
        double height;

        public Dog(String name, DogType race, double weight, double height) {
            this.name = name;
            this.race = race;
            this.weight = weight;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public DogType getRace() {
            return race;
        }

        public double getWeight() {
            return weight;
        }

        public double getHeight() {
            return height;
        }

        @Override
        public String toString() {
            return "Dog" +
                    "name='" + name + '\'' +
                    ", race=" + race +
                    ", weight=" + weight +
                    ", height=" + height;

        }
    }

    public static void main(String[] args) {
        List<Integer> li = IntStream.range(0,100).boxed().collect(Collectors.toList());
        Collections.shuffle(li);

        int[] arr = li.stream().mapToInt(i -> (int) i).toArray();

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.stream(arr).count());

        System.out.println("count is "+li.stream().count()); //long
        System.out.println("max is "+li.stream().max((a,b) -> Integer.compare(a, b)).get()); //max returns an Optional
        System.out.println("min is "+li.stream().min((a,b) -> Integer.compare(a, b)).get()); //min returns an Optional

        //Reduce!!!
        System.out.println("reduce is "+li.stream().reduce((total, el) -> total += el).get()); //reduce returns an Optional
        // WARNING IF you use identity is not an Optional but a value instead

        //allMatch anyMatch return a boolean
        System.out.println("any match "+li.stream().anyMatch(a -> a > 60));
        System.out.println("all match "+li.stream().allMatch(a -> a > 60));
        System.out.println("all match "+li.stream().allMatch(a -> a >= 0));

        System.out.println(IntStream.range(0,10).boxed().map( e -> "Bob").collect(Collectors.joining()));

        int[] b = Arrays.copyOf(arr, arr.length);
        Arrays.sort(b);
        Arrays.parallelSort(b);
        Arrays.parallelPrefix(b, (a,c) -> a+c);
        System.out.println(Arrays.toString(b));


        List<Dog> listOfDogs = new ArrayList<>();
        listOfDogs.add(new Dog("Pakis", DogType.GOLDEN_RETRIEVER, 20.5, 0.88));
        listOfDogs.add(new Dog("Chloe", DogType.CRETAN_RETRIEVER, 8.5, 0.22));
        listOfDogs.add(new Dog("Takis", DogType.SHEPHERD, 8.5, 0.22));
        listOfDogs.add(new Dog("Trixie", DogType.CRETAN_RETRIEVER, 8.5, 0.22));

        var m = listOfDogs.stream().collect(Collectors.groupingBy(Dog::getRace)); //makes a map which contains lists!!!
        // aaaa map of lists whose key is the dog race!
        m.get(DogType.CRETAN_RETRIEVER).stream().forEach(System.out::println);
    }
}
