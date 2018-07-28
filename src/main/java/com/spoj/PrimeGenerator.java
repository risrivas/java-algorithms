package com.spoj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrimeGenerator {

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();

      boolean[] sieve = new boolean[1000_000_000 + 1];
      Arrays.fill(sieve, true);
      sieve[0] = false;
      sieve[1] = false;

      sieveWithAllPrimes(sieve);

      for (int i = 0; i < n; i++) {
         int lo = scan.nextInt();
         int hi = scan.nextInt();
         for (int j = lo; j <= hi; j++) {
            if (sieve[j]) {
               System.out.println(j);
            }
         }
         System.out.println();
      }

      scan.close();
   }

   private static void sieveWithAllPrimes(boolean[] sieve) {
      int N = sieve.length;
      int sqrt = (int) Math.ceil(Math.sqrt(N));
      for (int i = 2; i <= sqrt; i++) {
         int k = i * i;
         while (k < N) {
            if (sieve[k]) {
               sieve[k] = false;
            }
            k += i;
         }
      }
   }
}
