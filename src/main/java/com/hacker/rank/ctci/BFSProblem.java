package com.hacker.rank.ctci;


import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class BFSProblem {


   public static void main(String[] args) {
      /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner scan = new Scanner(System.in);
      int q = scan.nextInt();
      for (int i = 0; i < q; i++) {
         int V = scan.nextInt();
         int E = scan.nextInt();
         Graph graph = new Graph(V, E);
         for (int j = 0; j < E; j++) {
            int v = scan.nextInt();
            int w = scan.nextInt();
            graph.addEdge(v - 1, w - 1);
         }

         int s = scan.nextInt();
         BreadthFirstSearch bfs = new BreadthFirstSearch(graph, s - 1);

         for (int k = 0; k < V; k++) {
            if (k==(s-1)) continue;
            System.out.printf("%d ", bfs.pathTo(k));
         }

         System.out.println();
      }
      scan.close();
   }
}

class BreadthFirstSearch {
   private boolean[] marked;
   private int[] edgeTo;
   private final int s;

   public BreadthFirstSearch(Graph G, int s) {
      marked = new boolean[G.V()];
      edgeTo = new int[G.V()];
      this.s = s;
      bfs(G, s);
   }

   private void bfs(Graph G, int s) {
      Deque<Integer> queue = new ArrayDeque<>();
      marked[s] = true;
      queue.add(s);
      while (!queue.isEmpty()) {
         int v = queue.remove();
         for (int w : G.adj(v)) {
            if (!marked[w]) {
               edgeTo[w] = v;
               marked[w] = true;
               queue.add(w);
            }
         }
      }
   }

   public boolean hasPathTo(int v) {
      return marked[v];
   }

   public int pathTo(int v) {
      if (!hasPathTo(v)) return -1;

      int count = 0;

      for (int x = v; x != s; x = edgeTo[x]) {
         count++;
      }

      return count*6;
   }
}

class Graph {
   private final int V;
   private final int E;
   private LinkedList<Integer>[] adj;

   public Graph(int V, int E) {
      this.V = V;
      this.E = E;
      adj = new LinkedList[V];
      for (int v = 0; v < V; v++) {
         adj[v] = new LinkedList<Integer>();
      }
   }

   public void addEdge(int v, int w) {
      adj[v].add(w);
      adj[w].add(v);
   }

   public int V() {
      return V;
   }

   public int E() {
      return E;
   }

   public LinkedList<Integer> adj(int v) {
      return adj[v];
   }

}

