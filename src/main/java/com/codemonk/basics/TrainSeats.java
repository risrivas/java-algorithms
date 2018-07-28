package com.codemonk.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TrainSeats {

   public static void main(String[] args) {
      try (Scanner scanner = new Scanner(System.in)) {

         Map<Integer, Integer> AS = new HashMap<>();
         Map<Integer, Integer> MS = new HashMap<>();
         Map<Integer, Integer> WS = new HashMap<>();

         createSeatMaps(AS, MS, WS);

         int T = scanner.nextInt();
         for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            checkSeatTypeAndOpposite(AS, MS, WS, n);
         }

      }
   }

   private static void checkSeatTypeAndOpposite(Map<Integer, Integer> AS, Map<Integer, Integer> MS, Map<Integer, Integer> WS, int n) {
      if (AS.containsKey(n)) {
         System.out.printf("%d AS%n", AS.get(n));
      } else if (MS.containsKey(n)) {
         System.out.printf("%d MS%n", MS.get(n));
      } else if (WS.containsKey(n)) {
         System.out.printf("%d WS%n", WS.get(n));
      }
   }

   private static void createSeatMaps(Map<Integer, Integer> AS, Map<Integer, Integer> MS, Map<Integer, Integer> WS) {
      boolean toggle = false;
      for (int i = 0; i < 9; i++) {
         for (int j = (i * 12 + 1), k = (i * 12 + 12); j <= (i * 12 + 6) && k >= (i * 12 + 7); j += 3, k -= 3) {
            if (toggle) {
               AS.put(j, k);
               AS.put(k, j);
               MS.put(j + 1, k - 1);
               MS.put(k - 1, j + 1);
               WS.put(j + 2, k - 2);
               WS.put(k - 2, j + 2);
            } else {
               WS.put(j, k);
               WS.put(k, j);
               MS.put(j + 1, k - 1);
               MS.put(k - 1, j + 1);
               AS.put(j + 2, k - 2);
               AS.put(k - 2, j + 2);
            }

            toggle = !toggle;
         }
      }
   }

}
