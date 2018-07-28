package com.leetcode.all;

import java.util.HashSet;
import java.util.Set;

public class MorseCode {

   private static final String[] morseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

   public static void main(String[] args) {
      System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
   }

   private static int uniqueMorseRepresentations(String[] words) {
      Set<String> resultSet = new HashSet<>();
      for (String word : words) {
         StringBuilder builder = new StringBuilder();
         for (char c : word.toCharArray()) {
            int idx = c - 'a';
            builder.append(morseCodes[idx]);
         }
         resultSet.add(builder.toString());
         // System.out.println(builder);
      }
      return resultSet.size();
   }

}
