package com.code.forces;

import java.util.Scanner;

public class Watermelon {

   public static void main(String[] args) {
      try (Scanner scanner = new Scanner(System.in)) {
         int w = scanner.nextInt();
         if ((w == 2) || (w & 1) == 1)
            System.out.println("NO");
         else
            System.out.println("YES");
      }
   }
}
