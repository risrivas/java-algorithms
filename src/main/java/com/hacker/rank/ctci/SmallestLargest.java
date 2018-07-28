package com.hacker.rank.ctci;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class SmallestLargest {

   public static String getSmallestAndLargest(String s, int k) {
      String smallest = "";
      String largest = "";

      // Complete the function
      // 'smallest' must be the lexicographically smallest substring of length 'k'
      // 'largest' must be the lexicographically largest substring of length 'k'
      SortedSet<String> set = new TreeSet<>();
      int n = s.length();
      int end = k;
      for (int i=0; end<=n; i++) {
         set.add(s.substring(i, end++));
      }

      smallest = set.first();
      largest = set.last();

      return smallest + "\n" + largest;
   }

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      String s = scan.next();
      int k = scan.nextInt();
      scan.close();

      System.out.println(getSmallestAndLargest(s, k));
   }


}
