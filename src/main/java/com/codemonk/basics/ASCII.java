package com.codemonk.basics;

import java.util.Scanner;

public class ASCII {

   public static void main(String[] args) {
      try (Scanner scanner = new Scanner(System.in)) {
         String string = scanner.next();
         System.out.printf("%d%n", Character.codePointAt(string.toCharArray(), 0));
      }
   }
}
