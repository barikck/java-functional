package org.ckb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Emp {
    private String name;
    private int age;

    public static void main(String[] args) {
        ArrayList<Emp> l1 = new ArrayList<>();
        l1.add(new Emp("a", 10));
        l1.add(new Emp("b", 20));
        l1.add(new Emp("c", 15));
        l1.add(new Emp("d", 40));
        List<Emp> l2 = (List<Emp>) l1.clone();
        l1.get(0).setAge(90);
        l1.add(new Emp("e", 50));
        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);
//        Deque<Integer> q = new ArrayDeque<>();
    }
}
