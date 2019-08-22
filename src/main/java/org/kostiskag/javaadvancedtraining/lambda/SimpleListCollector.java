package org.kostiskag.javaadvancedtraining.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class SimpleListCollector implements Collector<SimpleListCollector.Doggie, ArrayList<SimpleListCollector.Doggie>, List<SimpleListCollector.Doggie>> {

    public static class Doggie {
        String name;
        int age;

        public Doggie(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    ArrayList<Doggie> list = new ArrayList<>();

    //here you gather
    @Override
    public Supplier<ArrayList<Doggie>> supplier() {
        return () -> list;
    }

    //this is what adds up elements
    @Override
    public BiConsumer<ArrayList<Doggie>, Doggie> accumulator() {
        return (a,b) -> a.add(b);
    }

    //this combines containers so that parallel may be applied
    @Override
    public BinaryOperator<ArrayList<Doggie>> combiner() {
        return (a, b) -> {a.addAll(b); return a;};
    }

    //this gets the final full container and transforms it to its final form!
    @Override
    public Function<ArrayList<Doggie>, List<Doggie>> finisher() {
        return (a) -> (List<Doggie>) a;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}
