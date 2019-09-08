import java.io.*;
import java.util.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int numberOfValleys = 0;
        int seaLevel = 0;
        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            if(c == 'D') {
                seaLevel -= 1;
            }
            if(c == 'U') {
                seaLevel += 1;
                if(seaLevel == 0) {
                    numberOfValleys +=1;
                }
            }
        }
        return numberOfValleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);
        System.out.print(result);

        scanner.close();
    }
}
