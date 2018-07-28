package com.hacker.rank.ctci;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class CountInversions {

   private static int conversions = 0;

   static void mergeSort(int[] arr) {
      int[] tmp = new int[arr.length];
      mergeSort(arr, tmp, 0, arr.length - 1);
   }

   static void mergeSort(int[] arr, int[] tmp, int leftStart, int rightEnd) {
      if (leftStart >= rightEnd) {
         return;
      }

      int mid = (leftStart + rightEnd) / 2;
      mergeSort(arr, tmp, leftStart, mid);
      mergeSort(arr, tmp, mid + 1, rightEnd);
      mergeHalves(arr, tmp, leftStart, rightEnd);
   }

   static void mergeHalves(int[] arr, int[] tmp, int leftStart, int rightEnd) {
      int leftEnd = (leftStart + rightEnd) / 2;
      int rightStart = leftEnd + 1;
      int size = rightEnd - leftStart + 1;

      int left = leftStart;
      int right = rightStart;
      int index = leftStart;

      while (left <= leftEnd && right <= rightEnd) {
         if (arr[left] <= arr[right]) {
            tmp[index] = arr[left];
            left++;
         } else {
            tmp[index] = arr[right];
            right++;
            //conversions++;
            conversions+=leftEnd+1-left;
         }

         index++;
      }

      System.arraycopy(arr, left, tmp, index, leftEnd - left + 1);
      System.arraycopy(arr, right, tmp, index, rightEnd - right + 1);
      System.arraycopy(tmp, leftStart, arr, leftStart, size);
   }

   // brute force
   static long countInversionsBF(int[] arr) {
      // Complete this function
      long result = 0L;
      for (int i = 0; i < arr.length; i++) {
         for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] > arr[j]) {
               result += 1L;
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
            }
         }
      }

      return result;
   }

   static long countInversions(int[] arr) {
      mergeSort(arr);
      return conversions;
   }


   static long countInversionsBF1(int[] arr) {
      int[] temp = Arrays.copyOf(arr, arr.length);
      Arrays.sort(temp);
      if (Arrays.equals(arr, temp)) {
         return 0;
      }

      return countInversionsBF(arr);

   }


   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int t = in.nextInt();
      for (int a0 = 0; a0 < t; a0++) {
         int n = in.nextInt();
         int[] arr = new int[n];
         for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
         }
         long result = countInversions(arr);
         System.out.println(result);
      }
      in.close();
   }
}
