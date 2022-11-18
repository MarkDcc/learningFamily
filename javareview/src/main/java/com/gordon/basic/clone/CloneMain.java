package com.gordon.basic.clone;

public class CloneMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(new Address("shanghai"));
        Person personCopy = person.clone();
        System.out.println("person.equals(personCopy) = " + person.equals(personCopy));
        System.out.println("person.getAddress().equals(personCopy.getAddress()) = " + person.getAddress().equals(personCopy.getAddress()));


    }
}
