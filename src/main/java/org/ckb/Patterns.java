package org.ckb;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Patterns {
    public static void main(String[] args) {
        //Square Hallow Pattern // 5*5
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                if (i == 0 || j == 0 || i == 4 || j == 4) System.out.print("*  ");
//                else System.out.print("   ");
//            }
//            System.out.println();
//        }

        //Number Triangular
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j <= 3 - i ; j++) {
//                System.out.print(" ");
//            }
//            for (int j = 0; j <= i; j++) {
//                System.out.print((i + 1) + " ");
//            }
//            System.out.println();
//        }

//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j <= i; j++) {
//                System.out.print((j + 1) + " ");
//            }
//            System.out.println();
//        }

//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4 - i; j++) {
//                System.out.print((j + 1) + " ");
//            }
//            System.out.println();
//        }

//        int x = 1;
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j <= i; j++) {
//                System.out.print((x++) + " ");
//            }
//            System.out.println();
//        }

//        

        int[] arr = {1,2,3,4};
        int[] res = Arrays.stream(arr).map(e -> e * e).sorted().toArray();
        int max = 4;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= ((i == 3) ? i - 1: i); j++) {
                if ((i + j) % 2 == 0) System.out.print(" * ");
                else System.out.print("   ");
            }

            for (int j = 0; j <= max; j++) {
                System.out.print("   ");
            }
            max = max - 2;

            for (int j = 0; j <= ((i == 3) ? i - 1: i); j++) {
                if (j % 2 == 0) System.out.print(" * ");
                else System.out.print("   ");
            }
            System.out.println();
        }

        max = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= 2- i; j++) {
                if ((i + j) % 2 == 0) System.out.print(" * ");
                else System.out.print("   ");
            }

            for (int j = 0; j <= max; j++) {
                System.out.print("   ");
            }
            max = max + 2;

            for (int j = 0; j <= (2 - i); j++) {
                if (j % 2 == 0) System.out.print(" * ");
                else System.out.print("   ");
            }
            System.out.println();

        }

    }

}
