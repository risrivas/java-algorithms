package com.codemonk.basics;

import java.util.Scanner;

public class CountDivisors {

   public static void main(String[] args) {
      try (Scanner scanner = new Scanner(System.in)) {
         int l = scanner.nextInt();
         int r = scanner.nextInt();
         int k = scanner.nextInt();

         int count = 0;
         // boolean[] isDivisible = new boolean[r - l + 1];
         for (int i = l; i <= r; i++) {
            if (i % k == 0) {
               count++;
            }
         }

         System.out.println(count);
      }
   }

}
