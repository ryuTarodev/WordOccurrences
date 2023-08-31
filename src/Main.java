import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
//        Scanner sc = new Scanner(System.in);
        String input = "Java 900 Monday 812.5 812.5 950 700 Tuesday 812.5 October Java 900 25.3 7.26 9.23 Do it right database network 90.25 -99 -777 10.5";
        String[] splitStrings = input.split(" ");

        ArrayList<String> lowercaseStrings = new ArrayList<>();
        for (String word : splitStrings) {
            lowercaseStrings.add(word.toLowerCase());
        }

        //System.out.println(lowercaseStrings);

        for (int i = 0; i < lowercaseStrings.size(); i++) {
            String tester = lowercaseStrings.get(i);
            if (!hm.containsKey(tester)) {
                ArrayList<Integer> indices = new ArrayList<>(); // create arraylist because hashmap can input only ReferenceType
                indices.add(i + 1); // Adding +1 to match your example output
                hm.put(tester, indices);
            } else {
                ArrayList<Integer> indices = hm.get(tester);
                indices.add(i + 1); // Adding +1 to match your example output
            }
        }

        //System.out.println(hm);

        System.out.println("Word occurrences:");
        for (String key : hm.keySet()) {
            System.out.print(key + "(" + hm.get(key).size() + "): @ ");
            ArrayList<Integer> indices = hm.get(key);
            for (int i = 0; i < indices.size(); i++) {
                if (i > 0) {
                    System.out.print(", @ ");
                }
                System.out.print(indices.get(i));
            }
            System.out.println();
        }
    }
}