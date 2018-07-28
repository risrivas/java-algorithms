package com.leetcode.top100;

import java.util.*;

public class CombinationSum {

   public static List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> result = new ArrayList<>();
      if (candidates == null || candidates.length < 1) return result;

      int n = candidates.length;
      if (n == 1) {
         if (candidates[0] == target) {
            result.add(Arrays.asList(target));
         } else if (candidates[0] < target && (target % candidates[0] == 0)) {
            List<Integer> oneResult = new ArrayList<>();
            for (int i = 0; i < target / candidates[0]; i++) {
               oneResult.add(candidates[0]);
            }
            result.add(oneResult);
         }
         return result;
      }

      Map<Integer, List<List<Integer>>> map = new HashMap<>();
      for (int j = 0; j < n; j++) {
         if (candidates[j] == target) {
            result.add(Arrays.asList(target));
         } else if (candidates[j] < target) {
            int cdd = candidates[j];
            int count = 0;
            while (cdd <= target) {
               count++;
               int complement = target - cdd;
               if (map.containsKey(candidates[j])) {
                  List<List<Integer>> valueList = map.remove(cdd);
                  for (List<Integer> list : valueList) {
                     list.add(cdd);
                     result.add(list);
                  }
               } else {
                  if (map.containsKey(complement)) {
                     List<List<Integer>> valueList = map.get(complement);
                     List<Integer> oneR1 = new ArrayList<>();
                        // valueList.remove(valueList.size() - 1);
                     oneR1.add(candidates[j]);
                     valueList.add(oneR1);
                     map.put(complement, valueList);
                  } else {
                     List<List<Integer>> valueList = new ArrayList<>();
                     List<Integer> oneR = new ArrayList<>();
                     for (int o = 0; o < count; o++) {
                        oneR.add(candidates[j]);
                     }
                     valueList.add(oneR);
                     map.put(complement, valueList);
                  }
               }
               System.out.println(map);
               cdd += candidates[j];

            }
         }

      }


      return result;
   }

   public static void main(String[] args) {
      System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
   }
}
