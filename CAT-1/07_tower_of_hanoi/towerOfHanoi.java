import java.util.Scanner;

public class towerOfHanoi {

    // recursive Tower of Hanoi - not according to syllabus

    static void recursiveTowerOfHanoi(int n, char sourceRod, char destRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disc 1 from rod " + sourceRod + " to rod " +
                    destRod);
            return;
        }
        recursiveTowerOfHanoi(n - 1, sourceRod, auxRod, destRod);
        System.out.println("Move disc " + n + " from rod " + sourceRod + " to rod " +
                destRod);
        recursiveTowerOfHanoi(n - 1, auxRod, destRod, sourceRod);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of discs: ");
        int n = sc.nextInt();
        sc.close();

        recursiveTowerOfHanoi(n, 'A', 'C', 'B');
        // TODO: iterativeTowerOfHanoi(n);
    }
}