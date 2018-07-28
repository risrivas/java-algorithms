package com.codemonk.basics;

import java.util.Arrays;
import java.util.Scanner;

public class PlayWithNumbers {

   public static void main(String[] args) {
      try (Scanner scanner = new Scanner(System.in)) {
         int N = scanner.nextInt();
         int Q = scanner.nextInt();

         int[] array = new int[N];
         long[] sumArr = new long[N];
         long sum = 0L;
         for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
            sum += array[i];
            sumArr[i] = sum;
         }

         for (int i = 0; i < Q; i++) {
            int L = scanner.nextInt();
            int R = scanner.nextInt();
            if (L < 2) L = 2;
            int mean = (int) (Math.floor((sumArr[R - 1] - sumArr[L - 2]) / (R - L + 1)));
            System.out.println(mean);
         }
      }
   }

   private static int getMeanUsingStreams(int[] array, int l, int r) {
      return (int) (Math.floor(
         Arrays.stream(array, l - 1, r)
            .average()
            .getAsDouble()
      )
      );
   }

   private static int calculateMean(int[] subArray) {
      return (int) (Math.floor(
         Arrays.stream(subArray)
            .average()
            .getAsDouble()
      )
      );
   }

}
