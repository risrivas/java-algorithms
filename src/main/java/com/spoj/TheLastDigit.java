package com.spoj;

import java.math.BigInteger;
import java.util.Scanner;

public class TheLastDigit {

   public static void main(String[] args) {
      try (Scanner scanner = new Scanner(System.in)) {
         int t = scanner.nextInt();
         for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (a == 0 || a == 1 || a == 5 || a == 6) {
               System.out.println(a);
               continue;
            }

            if (b == 0) {
               System.out.println(1);
               continue;
            }
//
//            BigInteger aBig = new BigInteger(String.valueOf(a));
//            BigInteger bBig = new BigInteger(String.valueOf(b));
//            BigInteger ten = new BigInteger(String.valueOf(10));
            System.out.printf("%d%n", (int) Math.pow(a, b) % 10);

//            System.out.println(aBig.modPow(bBig, ten));
         }
      }
   }

}
