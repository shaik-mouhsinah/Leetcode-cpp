import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();   // number of entries
        in.nextLine();          // consume newline

        Map<String, String> phoneBook = new HashMap<>();

        // read entries
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            String number = in.nextLine();
            phoneBook.put(name, number);
        }

        // process queries until EOF
        while (in.hasNext()) {
            String query = in.nextLine();
            if (phoneBook.containsKey(query)) {
                System.out.println(query + "=" + phoneBook.get(query));
            } else {
                System.out.println("Not found");
            }
        }

        in.close();
    }
}
