import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int minJumps = 0;
        int currentPosition = 0;
        for(int i =0;i<c.length; i ++) {
            if(currentPosition + 2 < c.length){
                if(c[currentPosition + 2] == 0) {
                    currentPosition += 2;
                    minJumps++;
                    continue;
                }
            }
            if(currentPosition + 1 < c.length) {
                if(c[currentPosition + 1] == 0){
                    currentPosition += 1;
                    minJumps++;
                }
            }
        }
        return minJumps;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);
        System.out.print(result);

        scanner.close();
    }
}
