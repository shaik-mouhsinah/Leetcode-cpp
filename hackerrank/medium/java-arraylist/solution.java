import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of lines
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // Read each line
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt(); // number of integers in this line
            ArrayList<Integer> inner = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                inner.add(sc.nextInt());
            }
            list.add(inner);
        }

        int q = sc.nextInt(); // number of queries
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt(); // line number
            int y = sc.nextInt(); // position in that line

            try {
                System.out.println(list.get(x - 1).get(y - 1));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }

        sc.close();
    }
}
