package com.hacker.rank.ctci;

import java.util.Arrays;
import java.util.Scanner;

public class CountSteps {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int s = in.nextInt();
      int[] memo = new int[37];
      Arrays.fill(memo, -1);
      for(int a0 = 0; a0 < s; a0++){
         int n = in.nextInt();
         System.out.println(printWays(n, memo));
      }

      in.close();
   }

   private static int printWays(int n, int[] memo) {
      // if(n<1) return 0;
      if(n==1) return 1;
      if(n==2) return 2;
      if(n==3) return 4;
      if(memo[n] > -1) return memo[n];
      else {
         memo[n] = printWays(n-1, memo) + printWays(n-2, memo) + printWays(n-3, memo);
      }
      return memo[n];
   }

}
