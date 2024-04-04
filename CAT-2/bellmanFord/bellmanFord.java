import java.util.Arrays;
import java.util.Scanner;

public class bellmanFord {
    static int[] findShortestPaths(int[][] adj, int[][] edges, int n, int s) {
        int[] dists = new int[n];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[s] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                if (dists[edge[0]] + adj[edge[0]][edge[1]] < dists[edge[1]])
                    dists[edge[1]] = dists[edge[0]] + adj[edge[0]][edge[1]];
            }
        }

        return dists;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, e;
        n = sc.nextInt();
        e = sc.nextInt();

        int[][] adj = new int[n][n];
        int[][] edges = new int[e][2];
        int x, y, w;
        for (int i = 0; i < e; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            w = sc.nextInt();
            adj[x][y] = w;
            edges[i][0] = x;
            edges[i][1] = y;
        }

        int src = sc.nextInt();

        sc.close();

        int[] dists = findShortestPaths(adj, edges, n, src);
        for (int dist : dists)
            System.out.print(dist + " ");
    }
}