package com.codemonk.basics;

import java.util.Scanner;

public class ToggleString {
   public static void main(String[] args) {
      try (Scanner scan = new Scanner(System.in)) {
         String s = scan.next();
         StringBuilder result = new StringBuilder();
         for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
               if (Character.isLowerCase(c)) {
                  result.append(Character.toUpperCase(c));
               } else if (Character.isUpperCase(c)) {
                  result.append(Character.toLowerCase(c));
               }
            } else result.append(c);
         }

         System.out.println(result);
      }

   }

}
