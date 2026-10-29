import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // size of BitSets
        int m = sc.nextInt(); // number of operations

        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);

        for (int i = 0; i < m; i++) {
            String op = sc.next();
            int setNum = sc.nextInt();
            int arg = sc.nextInt();

            BitSet first = (setNum == 1) ? b1 : b2;
            BitSet second = (setNum == 1) ? b2 : b1;

            switch (op) {
                case "AND":
                    first.and(second);
                    break;
                case "OR":
                    first.or(second);
                    break;
                case "XOR":
                    first.xor(second);
                    break;
                case "FLIP":
                    first.flip(arg);
                    break;
                case "SET":
                    first.set(arg);
                    break;
            }

            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }
        sc.close();
    }
}
