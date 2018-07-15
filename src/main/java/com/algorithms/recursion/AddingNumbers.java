package com.algorithms.recursion;

public class AddingNumbers {

   public static void main(String[] args) {
      AddingNumbers addingNumbers = new AddingNumbers();
      System.out.println(addingNumbers.sumIterative(3));
      System.out.println(addingNumbers.sumRecursive(3));
   }

   public int sumIterative(int n) {
      int result = 0;
      for (int i = 1; i <= n; i++) {
         result += i;
      }
      return result;
   }

   public int sumRecursive(int n) {
      if (n==1) return 1;
      return n + sumRecursive(n-1);
   }

}
