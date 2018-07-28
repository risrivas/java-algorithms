package com.codemonk.basics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagrams {

   public static void main(String[] args) {
      try (Scanner scanner = new Scanner(System.in)) {
         int T = scanner.nextInt();
         for (int i = 0; i < T; i++) {
            String a = scanner.next();
            String b = scanner.next();
            System.out.println(deletionsRequired(a, b));
         }
      }
   }

   private static int deletionsRequired(String a, String b) {
      if ((a == null || a.isEmpty()) && b != null) return b.length();
      if ((b == null || b.isEmpty()) && a != null) return a.length();

      int count = 0;

      if (a.length() < b.length()) {
         String tmp = a;
         a = b;
         b = tmp;
      }

      Map<Character, Integer> map = new HashMap<>();

      for (char c : a.toCharArray()) {
         if (map.containsKey(c)) {
            int cnt = map.get(c);
            map.replace(c, cnt + 1);
         } else {
            map.put(c, 1);
         }
      }

      for (char c : b.toCharArray()) {
         if (map.containsKey(c)) {
            int cnt = map.get(c);
            map.replace(c, cnt - 1);
         } else {
            map.put(c, 1);
         }
      }

      for (int i : map.values()) {
         count += Math.abs(i);
      }

      return count;
   }

   private static String sortString(String a) {
      char[] aChars = a.toCharArray();
      Arrays.sort(aChars);
      return new String(aChars);
   }


}
