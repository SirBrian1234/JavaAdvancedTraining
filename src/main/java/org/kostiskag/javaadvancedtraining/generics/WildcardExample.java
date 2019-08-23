package org.kostiskag.javaadvancedtraining.generics;

public class WildcardExample<N extends Number>{

    N num;

    public WildcardExample(N num) {
        this.num = num;
    }

    //it's used to accept an external object!
    public int compareTo(WildcardExample<?> a) {
        return Integer.compare(this.num.intValue(), a.num.intValue());
    }

    public static void main(String[] args) {
        WildcardExample<Double> d = new WildcardExample<Double>(15.4);
        WildcardExample<Integer> c = new WildcardExample<Integer>(16);

        System.out.println(d.compareTo(c));
    }
}
