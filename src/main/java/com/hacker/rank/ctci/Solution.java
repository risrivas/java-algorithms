package com.hacker.rank.ctci;

import java.util.*;

class MyStack {
   private int top;
   private final List<Character> stackList;

   public MyStack() {
      top = -1;
      stackList = new ArrayList<>();
   }

   public void push(char item) {
      stackList.add(++top, item);
   }

   // private boolean isEmpty() {
   //   return (top == -1);
   // }

   public char pop() {
      if(stackList.isEmpty()) {
         throw new RuntimeException("stack is empty");
      }

      return stackList.remove(top--);
   }
}

class TQueue {
   private int rear;
   private final List<Character> queueList;

   public TQueue() {
      rear=-1;
      queueList = new ArrayList<>();
   }

   public void enqueue(char c) {
      queueList.add(++rear, c);
   }

   public char dequeue() {
      if (queueList.isEmpty()) {
         throw new RuntimeException("queue is empty");
      }

      return queueList.remove(0);
   }

}


public class Solution {
   // Write your code here.
   MyStack stack = new MyStack();
   TQueue queue = new TQueue();

   public void pushCharacter(char c) {
      stack.push(c);
   }

   public void enqueueCharacter(char c) {
      queue.enqueue(c);
   }

   public char popCharacter() {
      return stack.pop();
   }

   public char dequeueCharacter() {
      return queue.dequeue();
   }

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      String input = scan.nextLine();
      scan.close();

      // Convert input String to an array of characters:
      char[] s = input.toCharArray();

      // Create a Solution object:
      Solution p = new Solution();

      // Enqueue/Push all chars to their respective data structures:
      for (char c : s) {
         p.pushCharacter(c);
         p.enqueueCharacter(c);
      }

      // Pop/Dequeue the chars at the head of both data structures and compare them:
      boolean isPalindrome = true;
      for (int i = 0; i < s.length/2; i++) {
         if (p.popCharacter() != p.dequeueCharacter()) {
            isPalindrome = false;
            break;
         }
      }

      //Finally, print whether string s is palindrome or not.
      System.out.println( "The word, " + input + ", is "
         + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
   }
}
