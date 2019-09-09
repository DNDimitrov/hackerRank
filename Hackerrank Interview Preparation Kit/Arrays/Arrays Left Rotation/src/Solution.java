import java.io.*;
import java.util.*;

public class Solution {

    // The task can be solved with changing the indexes of the array
    // However I solve it using Queue. This needs some more memory but the solution is fast and clean
    static int[] rotLeft(int[] a, int d) {
        Queue<Integer> numbers = new LinkedList<>();
        for(int i = 0;i<a.length;i++) {
            numbers.add(a[i]);
        }
        for(int i = 0;i<d;i++) {
            int head = numbers.remove();
            numbers.add(head);
        }
        for(int i = 0;i<a.length;i++) {
            a[i] = numbers.remove();
        }
        return a;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);
        for(int i = 0;i<result.length;i++) {
            System.out.print(result[i] + " ");
        }

        scanner.close();
    }
}
