package ru.innopolis.uni.course3.generic;

import ru.innopolis.uni.course3.generic.simplearray.SimpleArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for testing will.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 21.12.2016
 */
public class StudyWild {

    /**
     * Class for testing will.
     *
     * @author Olga Fedorova
     * @version 1.0
     * @since 21.12.2016
     */
    private static class A {
    }

    /**
     * Class for testing will.
     *
     * @author Olga Fedorova
     * @version 1.0
     * @since 21.12.2016
     */
    private static class B extends A {
    }

    /**
     * Class for testing will.
     *
     * @author Olga Fedorova
     * @version 1.0
     * @since 21.12.2016
     */
    private static class C extends B {
    }

    /**
     * Method for studing wild.
     */
    public void whenWildTest() {
        SimpleArray<A> list1 = new SimpleArray<>(3);
        this.printAll(list1);
        //this.printUpper(list1); exception
        this.printLowwer(list1);

        SimpleArray<B> list2 = new SimpleArray<>(3);
        this.printAll(list2);
        this.printUpper(list2);
        this.printLowwer(list2);


        SimpleArray<C> list3 = new SimpleArray<>(3);
        this.printAll(list3);
        this.printUpper(list3);
        //this.printLowwer(list3); exception


        SimpleArray<? super B> list4 = new SimpleArray<>(3);
        //list4.add(new A()); exception
        list4.add(new B());
        list4.add(new C());
        this.printAll(list4);
        //this.printUpper(list4);
        this.printLowwer(list4);

        SimpleArray<? extends B> list5 = new SimpleArray<>(3);
        //list5.add(new A()); //exception
        //list5.add(new B());//exception
        //list5.add(new C());//exception
        this.printAll(list5);
        this.printUpper(list5);
        //this.printLowwer(list5); //exception

        List<? extends B> list6 = new ArrayList<>();
        //list6.add(new A()); //Exception
    }

    /**
     * Study wild.
     *
     * @param list value for test.
     */
    public void printAll(SimpleArray<?> list) {
    }

    /**
     * Study upper wild.
     *
     * @param list value for test.
     */
    public void printUpper(SimpleArray<? extends B> list) {
    }

    /**
     * Study lowwer wild.
     *
     * @param list value for test.
     */
    public void printLowwer(SimpleArray<? super B> list) {
    }


}
