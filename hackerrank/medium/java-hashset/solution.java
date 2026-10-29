import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

//Write your code here
Set<String> uniquePairs = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String a = pair_left[i];
            String b = pair_right[i];

            // Canonicalize the pair so (a, b) and (b, a) map to the same key
            String pair;
            if (a.compareTo(b) < 0) {
                pair = a + " " + b;
            } else {
                pair = b + " " + a;
            }

            uniquePairs.add(pair);
            sb.append(uniquePairs.size()).append("\n");
        }

        System.out.print(sb);
   }
}
