package com.hacker.rank.statistics;

import java.io.*;
import java.util.*;

public class Quartiles {
   public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int x[] = new int[n];
      for (int i=0; i<n; i++){
         x[i] = scan.nextInt();
      }
      scan.close();

      Arrays.sort(x);

      int q1=0, q2=0, q3=0, idx = n/2;

      q2 = calculateMedian(x);

      int lowArr[], highArr[];

      if(n%2==0) {
         lowArr = Arrays.copyOfRange(x, 0, idx);
         highArr = Arrays.copyOfRange(x, idx, n);
      } else {
         lowArr = Arrays.copyOfRange(x, 0, idx);
         highArr = Arrays.copyOfRange(x, idx+1, n);
      }

      q1 = calculateMedian(lowArr);
      q3 = calculateMedian(highArr);

      System.out.printf("%d%n%d%n%d%n", q1, q2, q3);
   }

   private static int calculateMedian(int[] y) {
      // Arrays.sort(y);
      int size = y.length;

      int mid = size/2;
      if(isEven(size)) {
         return (y[mid] + y[mid-1]) / 2;
      } else {
         return y[mid];
      }
   }

   private static boolean isEven(int num) {
      return (num%2 == 0);
   }


}
