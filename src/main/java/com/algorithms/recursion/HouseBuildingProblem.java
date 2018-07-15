package com.algorithms.recursion;

public class HouseBuildingProblem {

   public static void main(String[] args) {
      HouseBuildingProblem houseBuildingProblem = new HouseBuildingProblem();
      houseBuildingProblem.buildLayerHead(4);
      houseBuildingProblem.buildLayerTail(4);
   }

   public void buildLayerHead(int height) {
      if (height == 0) return;
      buildLayerHead(height - 1);
      System.out.println(height);
   }

   public void buildLayerTail(int height) {
      if (height == 0) return;
      System.out.println(height);
      buildLayerTail(height - 1);
   }


}
