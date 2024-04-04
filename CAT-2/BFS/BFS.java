import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class BFS {
    static void breadthFirstSearch(int[][] adj, int n, int start) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int cur;
        while (!queue.isEmpty()) {
            cur = queue.remove();
            if (!visited.contains(cur)) {
                visited.add(cur);
                System.out.print(cur + " ");

                for (int i = 0; i < n; i++) {
                    if (adj[cur][i] == 1)
                        queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, e;
        n = sc.nextInt();
        e = sc.nextInt();

        int[][] adj = new int[n][n];
        int x, y;
        for (int i = 0; i < e; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }

        int start = sc.nextInt();

        sc.close();

        breadthFirstSearch(adj, n, start);
    }
}