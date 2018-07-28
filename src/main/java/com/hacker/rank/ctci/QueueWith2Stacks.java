package com.hacker.rank.ctci;

import java.util.*;

public class QueueWith2Stacks {
   public static void main(String[] args) {
      MyQueue<Integer> queue = new MyQueue<Integer>();

      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();

      for (int i = 0; i < n; i++) {
         int operation = scan.nextInt();
         if (operation == 1) { // enqueue
            queue.enqueue(scan.nextInt());
         } else if (operation == 2) { // dequeue
            queue.dequeue();
         } else if (operation == 3) { // print/peek
            System.out.println(queue.peek());
         }
      }
      scan.close();
   }
}

class QStack<E> {
   private static class Node<E> {
      private E data;
      private Node<E> next;
      public Node(E dt) {
         this.data = dt;
      }
   }

   private Node<E> top = null;
   // private int n = 0;

   public boolean isEmpty() {
      return top==null;
   }

   public void push(E item) {
      Node<E> node = new Node<>(item);
      node.next = top;
      top = node;
   }

   public E pop(){
      if(top==null) return null;
      E item = top.data;
      top = top.next;
      return item;
   }

   public E speek(){
      if(top==null) return null;
      return top.data;
   }

}

class MyQueue<T>{
   QStack<T> stack1 = new QStack<>();
   QStack<T> stack2 = new QStack<>();

   public void enqueue(T num) {
      stack1.push(num);
   }

   private void moveStack1ToStack2() {
      while(!stack1.isEmpty()) {
         stack2.push(stack1.pop());
      }
   }

   public T dequeue(){
      if(!stack2.isEmpty()) {
         return stack2.pop();
      }

      moveStack1ToStack2();

      if(stack2.isEmpty()) return null;

      return stack2.pop();
   }

   public T peek() {
      if(!stack2.isEmpty()) {
         return stack2.speek();
      }

      moveStack1ToStack2();

      if(stack2.isEmpty()) return null;

      return stack2.speek();
   }

}






