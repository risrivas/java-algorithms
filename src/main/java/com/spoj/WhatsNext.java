package com.spoj;

import java.util.Scanner;

public class WhatsNext {

   public static void main(String[] args) {
      try (Scanner scan = new Scanner(System.in)) {
         int a = scan.nextInt();
         int b = scan.nextInt();
         int c = scan.nextInt();
         String AP = "AP", GP = "GP";
         while (!(a == 0 && b == 0 && c == 0)) {
            int x = b - a;
            if (x == c - b) {
               System.out.printf("%s %d%n", AP, (c + x));
            } else if (b / a == c / b) {
               int y = b / a;
               System.out.printf("%s %d%n", GP, (c * y));
            }

            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();

         }
      }
   }

}
