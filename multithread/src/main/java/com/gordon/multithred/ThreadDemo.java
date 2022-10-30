package com.gordon.multithred;

import java.util.HashMap;

/**
 * @author dongchen
 * @Data 2022/10/10
 * @Time 20:59
 */
public class ThreadDemo {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(3,3);
        
        if(map.containsKey(3)){
            System.out.println("map.get(3) = " + map.get(3));
        }
    }
}
