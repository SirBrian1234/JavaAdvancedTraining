package inheritance.staticInh;

/**
 * it clearly inherits all static fields and is able to use them
 * in their usual static usage without creating a class instance
 */
public class ChildStaticInh extends StaticInh {
    public static void main(String[] args) {
        ChildStaticInh.helloMe();
        ChildStaticInh.helloYou();
    }
}
