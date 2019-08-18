package org.kostiskag.javaadvancedtraining.interfaces;

public class PermittedActionsClass implements PermittedActionsInteraface {

    public static void main(String[] args) {
        System.out.println("hello");
    }

    @Override
    public int addition(int x, int y) {
        return 0;
    }

    @Override
    public int substraction(int x, int y) {
        return 0;
    }
}
