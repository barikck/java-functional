//package org.ckb;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class MissingPrisoners {
//    public static void main(String[] args) {
//        List<List<Integer>> coordinates = new ArrayList<>();
//        coordinates.add(Arrays.asList(6,4));
//        coordinates.add(Arrays.asList(2,2));
//        coordinates.add(Arrays.asList(3,2));
//        coordinates.add(Arrays.asList(6,6));
//        coordinates.add(Arrays.asList(9,4));
//        coordinates.add(Arrays.asList(2,3));
//        coordinates.add(Arrays.asList(3,3)); //9,6
//
//        List<Integer> missingPrisoner = findMissingPrisoner(coordinates);
//        System.out.println("Missing Prisoner: (" + missingPrisoner.get(0) + ", " + missingPrisoner.get(1) + ")");
//    }
////
////    public static List<Integer> findMissingPrisoner(List<List<Integer>> coordinates) {
////        coordinates.sort(Comparator.comparing(l -> l.get(0)));
////
////    }
//}
//
