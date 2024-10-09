
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graphs {

  public static class Graph {

    private final int V; // number of vertices
    private int E; // number of edges

    int[][] adjMatrix;

    // undirected graph
    public Graph(int nodes) {
      this.V = nodes;
      this.E = 0;
      this.adjMatrix = new int[nodes][nodes];
    }

    void addEdge(int u, int v) {
      this.adjMatrix[u][v] = 1;
      this.adjMatrix[v][u] = 1; // because it is undirected graph
      E++;
    }

    // addEdge(0 , 1)
    // addEdge(1 , 2)
    // addEdge(2 , 3)
    // addEdge(3 , 0)

    /*-
     *
          0 1 2 3
    
      0   0 1 0 1
      1   1 0 1 0
      2   0 1 0 1
      3   1 0 1 0
     
     */

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();

      System.out.println("Matrix Graph Representation");
      sb.append(V).append(" vertices, ").append(E).append(" edges").append("\n");

      for (int v = 0; v < V; v++) {
        sb.append(v).append(": ");
        for (Object w : adjMatrix[v]) {
          sb.append(w).append(" ");
        }
        sb.append("\n");
      }

      return sb.toString();

    }

  }

  public static class LinkedListGraph {

    public LinkedList<Integer>[] adjList;

    int E = 0;
    int V;
    int adjno = 0;

    @SuppressWarnings("unchecked")
    public LinkedListGraph(int nodes) {
      this.V = nodes;
      this.adjList = new LinkedList[nodes];
      for (int i = 0; i < nodes; i++) {
        this.adjList[i] = new LinkedList<>();
        adjno++;
      }
    }

    public void addEdge(int u, int v) {
      this.adjList[u].add(v);
      this.adjList[v].add(u); // because it is undirectional
      E++;
    }

    public int getadjno() {
      System.out.println();
      System.out.println(adjno);
      return adjno;
    }

    // addEdge(0 , 1)
    // addEdge(1 , 2)
    // addEdge(2 , 3)
    // addEdge(3 , 0)

    // 0 - 1 -> 3
    // 1 - 0 -> 2
    // 2 - 1 -> 3
    // 3 - 2 -> 0

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      System.out.println("Linked List Graph Representation");
      System.out.println(V + " vertices, " + E + " edges ");
      for (int v = 0; v < V; v++) {
        sb.append(v).append(": ");
        for (int w : adjList[v]) {
          sb.append(w).append(" ");
        }
        sb.append("\n");
      }
      return sb.toString();
    }

    public void iterative_bfs(int s) {
      Queue<Integer> q = new LinkedList<>();
      boolean[] visited = new boolean[V]; // to keep track of the nodes that are visited to avoid the cycle in the graph

      visited[s] = true;
      q.offer(s);
      while (!q.isEmpty()) {
        int u = q.poll();
        System.out.print(u + " ");
        for (int integer : adjList[u]) {
          if (!visited[integer]) {
            visited[integer] = true;
            q.offer(integer);
          }
        }
      }

    }

    public void iterative_dfs(int s) {
      System.out.println();
      boolean[] visited = new boolean[V];
      Stack<Integer> st = new Stack<>();
      visited[s] = true;
      st.push(s);
      while (!st.isEmpty()) {
        int u = st.pop();
        System.out.print(u + " ");
        for (int i : adjList[u]) {
          if (!visited[i]) {
            visited[i] = true;
            st.push(i);
          }
        }
      }
    }

    public void recursive_bfs(int s) {
      Queue<Integer> q = new LinkedList<>();
      boolean[] visited = new boolean[V];
      visited[s] = true;
      q.offer(s);
      bfsUtil(visited, q);
    }

    public void bfsUtil(boolean[] visited, Queue<Integer> q) {
      int u = q.poll();
      System.out.print(u + " ");
      while (!q.isEmpty()) {
        for (int i : adjList[u]) {
          if (!visited[i]) {
            visited[i] = true;
            q.offer(u);
          }
        }
      }
    }

    public void recursive_dfs() { // used when some of the nodes have no connecting edges (independent)
      boolean[] visited = new boolean[V];
      for (int v = 0; v < V; v++) {
        if (!visited[v]) {
          dfsUtil(visited, v);
        }
      }
    }

    public void dfsUtil(boolean[] visited, int v) {
      visited[v] = true;
      System.out.print(v + " ");
      for (int i : adjList[v]) {
        if (!visited[i]) {
          visited[i] = true;
          dfsUtil(visited, i);
        }
      }
    }

    void connected_components_undirected_graphs() {
      // using recursive dfs algo

      boolean[] visited = new boolean[V];
      int count = 0;
      int[] componentId = new int[V];
      for (int v = 0; v < V; v++) {
        if (!visited[v]) {
          connect_components_recursive_dfs(visited, v, count, componentId);
          count++;
        }
      }

    }

    void connect_components_recursive_dfs(boolean[] visited, int v, int count, int[] componentId) {
      visited[v] = true;
      componentId[v] = count;
      for (int i : adjList[v]) {
        if (!visited[i]) {
          connect_components_recursive_dfs(visited, i, count, componentId);
        }
      }
    }

    int number_of_islands(char[][] grid) {
      int m = grid.length; // to traverse rows
      int n = grid[0].length; // to traverse columns

      boolean[][] visited = new boolean[m][n];

      int numOfIslands = 0;

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (!visited[i][j] && grid[i][j] == '1') {
            dfs_4_number_of_islands(grid, i, j, visited);
            numOfIslands++;
          }
        }
      }

      return numOfIslands;
    }

    void dfs_4_number_of_islands(char[][] grid, int row, int column, boolean[][] visited) {
      if (visited[row][column] ||
          grid[row][column] == '0' ||
          row < 0 || column < 0 ||
          row >= grid.length || column >= grid[0].length) {
        return;
      }

      visited[row][column] = true;

      dfs_4_number_of_islands(grid, row - 1, column, visited); // go up
      dfs_4_number_of_islands(grid, row, column + 1, visited); // go right
      dfs_4_number_of_islands(grid, row + 1, column, visited); // go down
      dfs_4_number_of_islands(grid, row, column - 1, visited); // go left

    }

  }

  public static class Graph_Representation_Using_Edge_List {

    private final int V; // number of vertices
    private int E; // number of edges
    private final List<int[]> edgeList; // list of edges

    public Graph_Representation_Using_Edge_List(int nodes) {
      this.V = nodes;
      this.E = 0;
      this.edgeList = new ArrayList<>();
    }

    public void addEdge(int u, int v) {
      edgeList.add(new int[] { u, v });
      E++;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      System.out.println("Edge List Graph Representation");
      sb.append(V).append(" vertices, ").append(E).append(" edges").append("\n");
      for (int i = 0; i < edgeList.size(); i++) {
        // sb.append(i);
        sb.append(edgeList.get(i)[0]).append(" - ").append(edgeList.get(i)[1]);
        sb.append("\n");
      }

      return sb.toString();
    }

  }

  public static void main(String[] args) {

    Graph g = new Graph(4);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 0);

    LinkedListGraph llg = new LinkedListGraph(5);
    llg.addEdge(0, 1);
    llg.addEdge(1, 2);
    llg.addEdge(2, 3);
    llg.addEdge(3, 0);
    llg.addEdge(2, 4);

    Graph_Representation_Using_Edge_List gel = new Graph_Representation_Using_Edge_List(4);
    gel.addEdge(0, 1);
    gel.addEdge(1, 2);
    gel.addEdge(2, 3);
    gel.addEdge(3, 0);

    System.out.println(g);
    System.out.println(llg);
    System.out.println(gel);

    // Bread first search

    llg.iterative_bfs(0);
    llg.iterative_dfs(0);

    llg.getadjno();
  }

}
