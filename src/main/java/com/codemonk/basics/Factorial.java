package com.codemonk.basics;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {

   public static void main(String[] args) {
      try (Scanner scanner = new Scanner(System.in)) {
         int N = scanner.nextInt();
         System.out.println(factorial(N));
      }
   }

   private static BigInteger factorial(int n) {
      BigInteger result = BigInteger.ONE;
      for (int i = 1; i <= n; i++) {
         result = result.multiply(new BigInteger(String.valueOf(i)));
      }

      return result;
   }

}
