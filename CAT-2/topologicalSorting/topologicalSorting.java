import java.util.Scanner;
import java.util.Stack;

public class topologicalSorting {
    static void topoSortUtil(int[][] adj, int n, int[] visited, Stack<Integer> stk, int V) {
        visited[V] = 1;

        for (int i = 0; i < n; i++) {
            if (adj[V][i] == 1 & visited[i] == 0)
                topoSortUtil(adj, n, visited, stk, i);
        }

        stk.push(V);
    }

    static void topoSort(int[][] adj, int n) {
        Stack<Integer> stk = new Stack<>();
        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0)
                topoSortUtil(adj, n, visited, stk, i);
        }

        while (!stk.empty())
            System.out.print(stk.pop() + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] adj = new int[n][n];
        int e = sc.nextInt();
        int x, y;
        for (int i = 0; i < e; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            adj[x][y] = 1;
        }
        sc.close();

        topoSort(adj, n);
    }
}