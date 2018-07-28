package com.spoj;

import java.math.BigInteger;
import java.util.Scanner;

public class CandyIII {
   public static void main(String[] args) {
      try (Scanner scanner = new Scanner(System.in)) {
         int T = scanner.nextInt();
         for (int i = 0; i < T; i++) {
            scanner.nextLine();
            int N = scanner.nextInt();
            BigInteger sum = BigInteger.ZERO;
            for (int j = 0; j < N; j++) {
               BigInteger candy = scanner.nextBigInteger();
               sum = sum.add(candy);
            }
            if ((sum.mod(new BigInteger(String.valueOf(N)))).compareTo(BigInteger.ZERO) == 0)
               System.out.println("YES");
            else
               System.out.println("NO");
         }
      }
   }


   /*
        try (Scanner scanner = new Scanner(System.in)) {
         int T = scanner.nextInt();
         for (int i = 0; i < T; i++) {
            scanner.nextLine();
            int N = scanner.nextInt();
            long sum = 0L;
            for (int j = 0; j < N; j++) {
               int candy = scanner.nextInt();
               sum += candy;
            }
            if ((sum % N) == 0)
               System.out.println("YES");
            else
               System.out.println("NO");
         }
      }
    */
}
