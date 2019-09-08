import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {

    static int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        List<Integer> notMatched = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(notMatched.contains(ar[i])) {
                pairs++;
                removePair(notMatched,ar,i);
            }
            else {
                notMatched.add(ar[i]);
            }
        }
        return pairs;
    }

    public static void removePair(List<Integer> notMatched, int[] ar , int i) {
        for (Iterator<Integer> iter = notMatched.listIterator(); iter.hasNext(); ) {
            int a = iter.next();
            if (a == ar[i]) {
                iter.remove();
            }
        }
    }

    public static void main(String[] args)  {
        int n = 15;
        int[] ar = {6,5,2,3,5,2,2,1,1,5,1,3,3,3,5};

        int result = sockMerchant(n, ar);
        System.out.print(result);
    }
}
