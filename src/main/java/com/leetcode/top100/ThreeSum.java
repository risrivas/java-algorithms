package com.leetcode.top100;

import java.util.*;

public class ThreeSum {
   private static List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      Set<String> set = new HashSet<>();
      Arrays.sort(nums);
      int n = nums.length;
      for(int i=0; i<n; i++) {
         for(int j=i+1; j<n; j++) {
            int c = (-1)*nums[i] - nums[j];
            int rank = rank(c, nums);
//            int rank = Arrays.binarySearch(nums, c);
            if(rank > j) {
               String key = ""+nums[i]+"~"+nums[j]+"~"+nums[rank];
               if(!set.contains(key)) {
                  result.add(Arrays.asList(nums[i], nums[j], nums[rank]));
                  set.add(key);
               }
            }
         }
      }


      return result;
   }

   private static int rank(int key, int[] a) {
      int lo= 0;
      int hi = a.length-1;
      while(lo<=hi) {
         int mid = lo + (hi-lo)/2;
         if(key==a[mid]) return mid;
         else if(key<a[mid]) hi = mid-1;
         else lo = mid+1;
      }
      return -1;
   }

   public static void main(String[] args) {
      System.out.println(threeSum(new int[]{0, 0, 0}));
   }

}
