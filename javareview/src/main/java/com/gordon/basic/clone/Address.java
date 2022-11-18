package com.gordon.basic.clone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address implements Cloneable{
    private String name;

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

    public Address(String name) {
        this.name = name;
    }
}
