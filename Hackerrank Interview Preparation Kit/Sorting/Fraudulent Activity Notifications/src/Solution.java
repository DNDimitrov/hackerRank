import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int median = 100000;
        int count = 0;
        int[] currArray ;
        for(int i = 0;i<expenditure.length;i++) {
            int endOfArray = i + d -1;
            if (expenditure.length > endOfArray) {
                if (expenditure[i + d - 1] >= median * 2) {
                    count++;
                }
                //TODO apply fixes to not copy the array to new array and then sort it. Instead insert the new number to the correct spot
                currArray = Arrays.copyOfRange(expenditure, i, i + d);

                median = calculateMedian(currArray, d);

            }
        }
        return count;
    }

    static int calculateMedian(int[] expenditure, int d) {
        int median =0;
        Arrays.sort(expenditure);
        if(d%2==0) {
            median = (expenditure[d / 2 - 1] + expenditure[d / 2]);
        }
        else {
                median = expenditure[d/2];
            }
            return median;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {

            String[] nd = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nd[0]);

            int d = Integer.parseInt(nd[1]);

            int[] expenditure = new int[n];

            String[] expenditureItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int expenditureItem = Integer.parseInt(expenditureItems[i]);
                expenditure[i] = expenditureItem;
            }

            int result = activityNotifications(expenditure, d);
            System.out.println(result);

            scanner.close();
        }
    }
