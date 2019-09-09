import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static String twoStrings(String a, String b) {
        Set<Character> aLetterSet = new HashSet<>();
        Set<Character> bLetterSet = new HashSet<>();

        //Populate the sets
        for(int i = 0; i < a.length(); i++)
            aLetterSet.add(a.charAt(i));

        for(int i = 0; i < b.length(); i++)
            bLetterSet.add(b.charAt(i));

        //Perform the intersection of the two sets
        aLetterSet.retainAll(bLetterSet);

        if(aLetterSet.size() > 0)
            return "YES";
        else
            return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);
            System.out.println(result);
        }

        scanner.close();
    }
}
