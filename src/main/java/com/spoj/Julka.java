package com.spoj;

import java.math.BigInteger;
import java.util.Scanner;

public class Julka {

   public static void main(String[] args) {
      try (Scanner scanner = new Scanner(System.in)) {
         final BigInteger TWO = new BigInteger("2");
         for (int i = 0; i < 10; i++) {
            BigInteger totalApples = new BigInteger(scanner.next());
            BigInteger diff = new BigInteger(scanner.next());

            BigInteger natalie = totalApples.subtract(diff).divide(TWO);
            BigInteger klaudia = totalApples.subtract(natalie);
            System.out.printf("%s%n%s%n", klaudia, natalie);
         }
      }
   }

}
