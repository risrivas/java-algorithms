package com.spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Candy {

   public static void main(String[] args) {
      try (Scanner scan = new Scanner(System.in)) {
         int N = scan.nextInt();
         List<Integer> candies = new ArrayList<>();
         while (N != -1) {
            candies.clear();
            for (int i = 0; i < N; i++) {
               candies.add(scan.nextInt());
            }
            System.out.println(equalizeCandiesPackets(candies, N));
            N = scan.nextInt();
         }
      }
   }

   private static int equalizeCandiesPackets(List<Integer> candies, int n) {
      int count = 0, moves = 0;
      int sum = candies.stream().reduce(Integer::sum).get();
      int ave = sum / n;

      for (int candy : candies) {
         if (candy < ave) {
            count += ave - candy;
            moves += ave - candy;
         } else if (candy > ave) {
            count -= candy - ave;
         }
      }

      if (count == 0) return moves;

      return -1;
   }

}
