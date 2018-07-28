package com.codemonk.basics;

import java.util.Scanner;

public class Cipher {

   public static void main(String[] args) {
      try (Scanner scanner = new Scanner(System.in)) {
         String S = scanner.next();
         int N = scanner.nextInt();

         System.out.println(encrypt(S, N));
      }
   }

   private static String encrypt(String s, int n) {
      if (n == 0) {
         return s;
      }

      StringBuilder result = new StringBuilder();
      int a = 'a', z = 'z', A = 'A', Z = 'Z';
      for (char c : s.toCharArray()) {
         if (Character.isLetterOrDigit(c)) {
            if (Character.isDigit(c)) {
               int digit = Character.getNumericValue(c);
               result.append((digit + n) % 10);
            } else {
               int forwardChar = c + n;
               if (((Character.isLowerCase(c)) && (forwardChar > z))) {
                  result.append((char) ((forwardChar % z) + a - 1));
               } else if (((Character.isUpperCase(c)) && (forwardChar > Z))) {
                  result.append((char) ((forwardChar % Z) + A - 1));
               } else result.append((char) forwardChar);
            }
         } else result.append(c);
      }

      return result.toString();
   }

}
