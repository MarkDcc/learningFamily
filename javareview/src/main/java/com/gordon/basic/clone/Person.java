package com.gordon.basic.clone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person implements Cloneable{

    private Address address;
    @Override
    protected Person clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        person.setAddress(person.getAddress().clone());
        return person;
    }


    public Person(Address address) {
        this.address = address;
    }
}
