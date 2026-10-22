package org.example;

import HashMap.MyMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MyMap<Integer,String> map =new MyMap<>();
        map.put(1,"Pooja");
        map.put(2,"Kush");
        map.put(3,"Om");
        map.put(4,"Khushi");
        map.put(5,"Ganesh");
        map.put(6,"Payal");

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(4));
        map.remove(4);
        System.out.println(map.get(4));


    }
}
