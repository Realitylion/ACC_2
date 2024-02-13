import java.util.Scanner;

public class celebrity {

    static int findCelebrity(int[][] relationMatrix, int n) {
        int candidate = 0;

        for (int i = 0; i < n; i++) {
            if (relationMatrix[candidate][i] == 1)
                candidate = i;
        }

        for (int i = 0; i < n; i++) {
            if (i == candidate)
                continue;
            if (relationMatrix[candidate][i] == 1 || relationMatrix[i][candidate] == 0)
                return -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of people: ");
        int n = sc.nextInt();

        int relationMatrix[][] = new int[n][n];
        System.out.println("Enter relationship matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                relationMatrix[i][j] = sc.nextInt();
        }

        sc.close();

        int celebrity = findCelebrity(relationMatrix, n);
        if (celebrity == -1)
            System.out.println("There is no celebrity.");
        else
            System.out.println("Celebrity is person no. " + (celebrity + 1));
    }
}
