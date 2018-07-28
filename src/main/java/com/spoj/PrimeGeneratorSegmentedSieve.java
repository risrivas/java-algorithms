package com.spoj;

import java.util.*;

public class PrimeGeneratorSegmentedSieve {

   public static void segmentedSieve(boolean[] sieves) {
      int N = sieves.length;
      int sqrt = (int) Math.ceil(Math.sqrt(N));

      for (int i = 2; i * i <= sqrt; i++) {
         int k = i * i;
         while (k <= sqrt) {
            if (sieves[k]) sieves[k] = false;
            k += i;
         }
      }

      List<Integer> primes = new ArrayList<>();
      for (int j = 2; j <= sqrt; j++) {
         if (sieves[j]) {
            primes.add(j);
         }
      }


      int lo = sqrt + 1;
      int hi = lo + sqrt;
      while (lo < N) {
         if (hi >= N) hi = N - 1;

         for (int prime : primes) {

            int lonum = ( (int) Math.floor(lo/prime) ) * prime;

            while (lonum <= hi) {
               if (sieves[lonum] && (lonum % prime == 0)) {
                  sieves[lonum] = false;
               }
               lonum += prime;
            }
         }

         lo=hi+1;
         hi = lo+sqrt;
      }
   }

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int t = scan.nextInt();
      int max = 0;
      Map<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < t; i++) {
         int lo = scan.nextInt();
         int hi = scan.nextInt();
         max = Math.max(hi, max);
         map.put(lo, hi);
      }

      scan.close();

      boolean[] sieves = new boolean[max + 1];
      Arrays.fill(sieves, true);
      sieves[0] = false;
      sieves[1] = false;
      segmentedSieve(sieves);

      for (int lo : map.keySet()) {
         for (int j = lo; j <= map.get(lo); j++) {
            if (sieves[j])
               System.out.println(j);
         }
         System.out.println();
      }
   }

}
