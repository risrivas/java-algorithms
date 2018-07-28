package com.hacker.rank.ctci;

import java.util.Scanner;

public class BSTHeight {

   public static Node insert(Node root,int data){
      if(root==null){
         return new Node(data);
      }
      else{
         Node cur;
         if(data<=root.data){
            cur=insert(root.left,data);
            root.left=cur;
         }
         else{
            cur=insert(root.right,data);
            root.right=cur;
         }
         return root;
      }
   }
   public static void main(String args[]){
      Scanner sc=new Scanner(System.in);
      int T=sc.nextInt();
      Node root=null;
      while(T-->0){
         int data=sc.nextInt();
         root=insert(root,data);
      }
      int height=getHeight(root);
      System.out.println(height);
   }

   public static int getHeight(Node root){
      //Write your code here
      if(root==null) {
         return -1;
      }

      int rightHt = 1 + getHeight(root.right);
      int leftHt = 1 + getHeight(root.left);

      System.out.println("right:" + rightHt);
      System.out.println("left:" + leftHt);

      return Math.max(rightHt, leftHt);
   }


}

class Node{
   Node left,right;
   int data;
   Node(int data){
      this.data=data;
      left=right=null;
   }
}

