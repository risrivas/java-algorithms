package com.hacker.rank.ctci;

public class CountPathsDP {

   private static boolean[][] blocks = new boolean[8][8];

   static {
      blocks[1][2] = true;
      blocks[1][6] = true;
      blocks[2][4] = true;

      blocks[3][0] = true;
      blocks[3][2] = true;
      blocks[3][5] = true;

      blocks[4][2] = true;
      blocks[5][3] = true;
      blocks[5][4] = true;

      blocks[5][6] = true;
      blocks[6][1] = true;
      blocks[6][5] = true;
   }

   public static void main(String[] args) {
      int paths[][] = new int[8][8];
      System.out.println(countPaths(0, 0, paths));
   }

   private static int countPaths(int row, int col, int[][] paths) {
      if (blocks[row][col]) return 0;
      if (row == 7 || col == 7) return 1;
      if (paths[row][col] == 0) {
         paths[row][col] = countPaths(row + 1, col, paths) + countPaths(row, col + 1, paths);
      }
      return paths[row][col];
   }

}
