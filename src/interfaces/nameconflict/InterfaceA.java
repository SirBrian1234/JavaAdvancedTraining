package interfaces.nameconflict;

public interface InterfaceA {
    default void helloWorld() {
        System.out.println("hi");
    }
}
