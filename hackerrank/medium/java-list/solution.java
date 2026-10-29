import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // initial number of elements
        List<Integer> list = new ArrayList<>();

        // read initial list
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int q = sc.nextInt(); // number of queries

        // process queries
        for (int i = 0; i < q; i++) {
            String queryType = sc.next(); // "Insert" or "Delete"

            if (queryType.equals("Insert")) {
                int index = sc.nextInt();
                int value = sc.nextInt();
                list.add(index, value);
            } else if (queryType.equals("Delete")) {
                int index = sc.nextInt();
                list.remove(index);
            }
        }

        // print final list
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
