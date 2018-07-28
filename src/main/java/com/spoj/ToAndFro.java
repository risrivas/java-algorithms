package com.spoj;

import java.util.Scanner;

public class ToAndFro {

   public static void main(String[] args) {
      try (Scanner scan = new Scanner(System.in)) {
         int N = scan.nextInt();
         while (N != 0) {
            String s = scan.next();
            decode(s, N);
            N = scan.nextInt();
         }
      }
   }

   private static void decode(String s, int n) {
      StringBuilder result = new StringBuilder();
      boolean[] isCharUsed = new boolean[s.length() + 1];

      for (int i = 0; i < n; i++) {
         boolean toAndFro = true;
         for (int j = i; j < s.length(); ) {
            if (!isCharUsed[j]) {
               result.append(s.charAt(j));
            }
            if (toAndFro) {
               j += (2 * (n - i)) - 1;
            } else {
               j += (2 * i) + 1;
            }
            toAndFro = !toAndFro;
         }
      }

      System.out.println(result);
   }

}
