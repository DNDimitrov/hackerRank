import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> q = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        for(int i =0;i<queries.size();i++) {
            if(queries.get(i).get(0) == 1) {
                if(map.containsKey(queries.get(i).get(1))) {
                    map.put(queries.get(i).get(1), map.get(queries.get(i).get(1)) + 1);
                }
                else {
                    map.put(queries.get(i).get(1), 1);
                }
            }
            else if (queries.get(i).get(0) == 2) {
                if(map.containsKey(queries.get(i).get(1))) {
                    map.put(queries.get(i).get(1), -1);
                }
            }
            else if (queries.get(i).get(0) == 3) {
                //O(n) complexity of containsValue
                //it can be solved with 2nd map counting the 
                if(map.containsValue(queries.get(i).get(1))) {
                   current.add(1);
                }
                else {
                   current.add(0);
                }

            }


        }
     return current;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);
        for(int i = 0;i< ans.size();i++) {
            System.out.println(ans.get(i));
        }


        bufferedReader.close();
    }
}
