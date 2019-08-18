package inheritance;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashSet;
import java.util.Set;

/**
 * This class describes how method which throws an exception can be
 * overridden in a subclass!
 *
 */
public class Exceptions {

    static class A {
        int soCallMeMaybe() {
            return 6;
        }

        int soCallMeMaybe(int x) throws IOException {
            if (x < 5)
                throw new IOException();
            return 5;
        }

        int soCallMeMaybe(double x) throws ArrayIndexOutOfBoundsException {
            return 8;
        }

    }

    static class B extends A {

// FOR Checked exceptions (non runtime) the following rules apply:
        // THEY have similar behaviour with covariant return types, their main difference is that we may omit throwing
        // an exception in the subclass!

    //A. PARENT DECLARES A CHECKED EXCEPTION - int soCallMeMaybe(int x) throws IOException
        // If the superclass method declares an exception, the overridden method in subclass can omit the exception,
        // declare the same exception or declare a subclass of the parent exception.
        // But in no case it may declare a parent or a different kind of exception!

        //case 1: DANGER!!!!!! omit the exception is allowed!!!!!!!!!!!!!!!!!!!!
//        @Override
//        int soCallMeMaybe(int x) {
//            return 10;
//        }

        //case 2: declare a parent exception is not allowed
        //the parent throws IOException therefore Exception is a superclass and may produce compile error!
//        @Override
//        int soCallMeMaybe(int x) throws Exception {
//            return 10;
//        }

        //case 3: declare the same exception is allowed
        //no prob!
//        @Override
//        int soCallMeMaybe(int x) throws IOException {
//            return 10;
//        }

        //case 4: declare a child exception is allowed
        //no prob!
//        @Override
//        int soCallMeMaybe(int x) throws FileNotFoundException {
//            return 10;
//        }

        //case 5: declare a different kind of checked exception is not allowed
        //error
//        @Override
//        int soCallMeMaybe(int x) throws GeneralSecurityException {
//            return 10;
//        }


    //B. PARENT DOES NOT DECLARE AN EXCEPTION
        // If the superclass method does not declare an exception, the subclass overridden method
        // may not declare any checked exception.
        // comp error the parent does not throw exception
//        @Override
//        int soCallMeMaybe() throws Exception{
//            return 9;
//        }

        //YOU CAN'T ALSO THROW THROWABLE it is considered checked
//        @Override
//        int soCallMeMaybe() throws Throwable {
//            return 11;
//        }

        //In all cases the exception is not part of the method's signature
        //and therefore you may not create two methods of the same parent with different
        //throwables!


//FOR RUNTIME Exceptions there are no rules they may be placed anywhere replace checked and completely change their type!!!

    // A. clearly you may throw runtime exceptions and error in methods where there is no exception at all!
//        @Override
//        int soCallMeMaybe() throws Error {
//            return 11;
//        }

          //Remember? you can't do the following!
//        @Override
//        int soCallMeMaybe() throws Exception {
//            return 11;
//        }

          //But you can do this!
        @Override
        int soCallMeMaybe() throws RuntimeException {
            throw new RuntimeException("wiii!!!");
            //return 11;
        }

    // B. In the case that the superclass throws a Runtime exception you may omit
//        @Override
//        int soCallMeMaybe(double x) {
//            return 12;
//        }

          //Superclass!!! 0.0
//        @Override
//        int soCallMeMaybe(double x) throws RuntimeException {
//            return 12;
//        }

          //change completely to another!!! 0.0
//        @Override
//        int soCallMeMaybe(double x) throws IllegalArgumentException {
//            return 12;
//        }

    // C. In the case that the superclass throws a Checked exception can you replace it with a Runtime?????
        //YES YOU CAN!!!!!!!!!!!!!!!!!!
//        int soCallMeMaybe(int x) throws ArrayIndexOutOfBoundsException {
//            if (x < 5)
//                throw new ArrayIndexOutOfBoundsException();
//            return 5;
//        }

    }


    //You may not fool a checked in a hierarchy!
    static class parent {
        int soCallMeMaybe(int x) throws IOException {
            if (x < 5)
                throw new IOException();
            return 5;
        }
    }

    static class child extends  parent {
        @Override
        int soCallMeMaybe(int x) throws ArrayIndexOutOfBoundsException {
            return 5;
        }
    }

    static class grandchild extends child {
        // error: soCallMeMaybe(int) in inheritance.Exceptions.grandchild cannot override soCallMeMaybe(int) in inheritance.Exceptions.child
        // overridden method does not throw java.security.GeneralSecurityException
//        @Override
//        int soCallMeMaybe(int x) throws GeneralSecurityException {
//            return 5;
//        }
    }

    //omitting an exception permanently loses it
    static class parentB {
        int soCallMeMaybe(int x) throws IOException {
            if (x < 5)
                throw new IOException();
            return 5;
        }
    }

    static class childB extends  parentB {
        @Override
        int soCallMeMaybe(int x)  {
            return 5;
        }
    }

    static class grandchildB extends childB {
//        @Override
//        int soCallMeMaybe(int x) throws IOException {
//            return 5;
//        }
    }

    public static void main(String[] args) throws IOException {
        B b = new B();

        try {
            b.soCallMeMaybe();
        }catch (RuntimeException e) {
            //you can catch a runtime although it is not enforced!
            System.out.println(e.getMessage());
        }

        b.soCallMeMaybe(5);
        b.soCallMeMaybe(5d);
    }
}
