package com.hacker.rank.ctci;

import java.util.Scanner;

public class IsBST {
//   boolean checkBST(Node root) {
//      if(root==null) return true;
//      if(root.left!=null) {
//         if (root.left.data < root.data)  return checkBST(root.left);
//         else if (root.left.data >= root.data)  return false;
//      }
//
//      if(root.right!=null) {
//         if (root.right.data > root.data)  return checkBST(root.right);
//         else if (root.right.data <= root.data)  return false;
//      }
//
//      return true;
//   }



   public static boolean checkBST(Node root) {
      if(root==null) return true;

      boolean isleftRootNotNull = root.left!=null;
      boolean isrightRootNotNull = root.right!=null;

      if(isleftRootNotNull) {
         if (root.left.data >= root.data)  return false;
      }

      if(isrightRootNotNull) {
         if (root.right.data <= root.data)  return false;
      }

      if (isleftRootNotNull && isrightRootNotNull)
         return checkBST(root.left) && checkBST(root.right) ;

      if (isleftRootNotNull && !isrightRootNotNull)
         return checkBST(root.left) ;

      if (!isleftRootNotNull && isrightRootNotNull)
         return checkBST(root.right) ;

      return true;
   }

   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int T=sc.nextInt();
      Node root=null;
      while(T-->0){
         int data=sc.nextInt();
         root=BSTHeight.insert(root,data);
      }

      System.out.println(checkBST(root));
   }

}


