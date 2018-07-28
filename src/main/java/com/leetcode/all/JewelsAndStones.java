package com.leetcode.all;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
   public int numJewelsInStones(String J, String S) {
      int cnt = 0;
      if (!(J == null || J.isEmpty())) {
         Set<Character> setj = new HashSet<>();
         for (char j : J.toCharArray()) setj.add(j);
         for (char s : S.toCharArray()) {
            if (setj.contains(s)) {
               cnt++;
            }
         }
      }
      return cnt;
   }

}
