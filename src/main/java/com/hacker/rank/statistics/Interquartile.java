package com.hacker.rank.statistics;

import java.util.Arrays;
import java.util.Scanner;

public class Interquartile {
   public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int[] x = new int[n];
      int[] f = new int[n];

      for(int i=0; i<n; i++) {
         x[i] = scan.nextInt();
      }

      for(int i=0; i<n; i++) {
         f[i] = scan.nextInt();
      }

      scan.close();

      int fSize = Arrays.stream(f).sum();
      int[] s = new int[fSize];
      int count = 0;
      for(int i=0; i<n; i++) {
         for(int j=0; j<f[i]; j++) {
            s[count++] = x[i];
         }
      }

      Arrays.sort(s);

      int lowArr[], highArr[];

      int idx=fSize/2;
      if (fSize%2==0) {
         lowArr = Arrays.copyOfRange(s, 0, idx);
         highArr = Arrays.copyOfRange(s, idx, fSize);
      }
      else {
         lowArr = Arrays.copyOfRange(s, 0, idx);
         highArr = Arrays.copyOfRange(s, idx+1, fSize);
      }

      double q1 = calculateMedian(lowArr);
      double q3 = calculateMedian(highArr);

      System.out.printf("%.1f%n", (q3-q1) );

   }


   private static double calculateMedian(int[] y) {
      int size = y.length;
      int mid = size/2;

      if(size%2 == 0) {
         return (y[mid] + y[mid-1]) / 2.0;
      } else {
         return y[mid];
      }
   }


}
