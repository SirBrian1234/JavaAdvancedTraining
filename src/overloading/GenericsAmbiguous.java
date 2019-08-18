package overloading;

public class GenericsAmbiguous<K,V> {
    K o1;
    V o2;

//    public void set(K o1) {
//        this.o1 = o1;
//    }

    public void set(V o2) {
        this.o2 = o2;
    }

    public static void main(String[] args) {
        GenericsAmbiguous<Integer,Integer> g = new GenericsAmbiguous();


    }
}
