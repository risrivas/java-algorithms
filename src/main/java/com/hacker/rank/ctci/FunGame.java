package com.hacker.rank.ctci;

import java.util.*;

public class FunGame {

   public static void main(String[] args) {
      /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner scan = new Scanner(System.in);
      int T = scan.nextInt();
      for(int i=0; i<T; i++) {
         int n = scan.nextInt();
//         int[] A = new int[n];
//         int[] B = new int[n];
//         for(int i1=0; i1<n; i1++) {
//            A[i1] = scan.nextInt();
//         }
//         for(int i2=0; i2<n; i2++) {
//            B[i2] = scan.nextInt();
//         }
//         printWinner(A, B, n);

         Map<Integer, Integer> aMap = new HashMap<>();
         Map<Integer, Integer> bMap = new HashMap<>();
         for(int i1=0; i1<n; i1++) {
            aMap.put(scan.nextInt(), i1);
         }
         for(int i2=0; i2<n; i2++) {
            bMap.put(scan.nextInt(), i2);
         }
         printWinner(aMap, bMap, n);
      }

      scan.close();
   }

   private static void printWinner(Map<Integer, Integer> aMap, Map<Integer, Integer> bMap, int n) {
      boolean[] usedIdx = new boolean[n];
      boolean isPlayerA = true;

      int count=0, atotal=0, btotal=0;

      while(count<n) {
         if (isPlayerA) {
            if(!aMap.isEmpty()) {
               int aMax = aMap.keySet().stream().max(Comparator.naturalOrder()).get();
               if (!usedIdx[aMap.get(aMax)]) {
                  atotal += aMax;
                  count++;
                  usedIdx[aMap.get(aMax)] = true;
                  isPlayerA = false;
                  aMap.remove(aMax);
               }
            }
         } else {
            if(!bMap.isEmpty()) {
               int bMax = bMap.keySet().stream().max(Comparator.naturalOrder()).get();
               if (!usedIdx[bMap.get(bMax)]) {
                  btotal += bMax;
                  count++;
                  usedIdx[bMap.get(bMax)] = true;
                  isPlayerA = true;
                  bMap.remove(bMax);
               }
            }

         }
      }

      if (atotal == btotal) {
         System.out.println("Tied");
      } else if(atotal>btotal) {
         System.out.println("First");
      } else {
         System.out.println("Second");
      }

   }

   /*
   private static void printWinner(int[] A, int[] B, int n) {
      int[] sortedA = Arrays.copyOf(A, n);
      Arrays.sort(sortedA);

      int[] sortedB = Arrays.copyOf(B, n);
      Arrays.sort(sortedB);

      boolean isPlayerA = true;



   }
*/
   /*
   private static void printWinner(TreeMap<Integer, Integer> aMap, TreeMap<Integer, Integer> bMap) {
      boolean[] usedIdx = new boolean[n];
      boolean isPlayerA = true;

   }
   */

}
