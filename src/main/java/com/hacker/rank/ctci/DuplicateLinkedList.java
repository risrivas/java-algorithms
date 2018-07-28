package com.hacker.rank.ctci;

import java.util.Scanner;

public class DuplicateLinkedList {
   public static LLNode removeDuplicates(LLNode head) {
      //Write your code here
      if (head == null || head.next == null) {
         return head;
      }

      LLNode current = head;
      while (current.next != null) {
         if (current.data == current.next.data) {
            current.next = current.next.next;
         } else {
            current = current.next;
         }
      }

      return current;
   }


   public static LLNode insert(LLNode head, int data) {
      LLNode p = new LLNode(data);
      if (head == null)
         head = p;
      else if (head.next == null)
         head.next = p;
      else {
         LLNode start = head;
         while (start.next != null)
            start = start.next;
         start.next = p;

      }
      return head;
   }

   public static void display(LLNode head) {
      LLNode start = head;
      while (start != null) {
         System.out.print(start.data + " ");
         start = start.next;
      }
   }

   public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      LLNode head = null;
      int T = sc.nextInt();
      while (T-- > 0) {
         int ele = sc.nextInt();
         head = insert(head, ele);
      }
      head = removeDuplicates(head);
      display(head);

   }


}

class LLNode {
   int data;
   LLNode next;

   LLNode(int d) {
      data = d;
      next = null;
   }

}
