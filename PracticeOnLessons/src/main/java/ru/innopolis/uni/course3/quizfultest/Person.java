package ru.innopolis.uni.course3.quizfultest;

/**
 * Created by Olga on 24.01.2017.
 */
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    public boolean equals(Person p) {
        return p.name.equals(this.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
