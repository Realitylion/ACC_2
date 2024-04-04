import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class DFS {
    static void depthFirstSearch(int[][] adj, int n, int start) {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stk = new Stack<>();
        stk.push(start);

        int cur;
        while (!stk.empty()) {
            cur = stk.pop();
            if (!visited.contains(cur)) {
                visited.add(cur);
                System.out.print(cur + " ");

                for (int i = n - 1; i >= 0; i--) {
                    if (adj[cur][i] == 1)
                        stk.push(i);
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

        depthFirstSearch(adj, n, start);
    }
}