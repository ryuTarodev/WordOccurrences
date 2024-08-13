import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> hm = new HashMap<>();
        String input = "Java java java 900 Monday 812.5 812.5 950 700 jAvA Tuesday 812.5 October Java 900 25.3 7.26 9.23 Do it right database network 90.25 -99 -777 10.5";
        ArrayList<String> lowercaseSplitStrings = splitAndLowercase(input);
        for (int i = 0; i < lowercaseSplitStrings.size(); i++) {
            String tester = lowercaseSplitStrings.get(i);
            if (checkedInteger(tester)) {
                continue; // if found number ->  skip
            }
            if (!hm.containsKey(tester)) {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i + 1);
                hm.put(tester, indices);
            } else {
                hm.get(tester).add(i + 1);
            }
//            printHmDebugger(hm);
        }
        System.out.println("Word occurrences: " + input);
        printWordOccurrences(hm);
//        stringBuilderWordOccurrences(hm);
    }
    public static ArrayList<String> splitAndLowercase(String input){
        String[] splitStrings = input.split(" ");
        ArrayList<String> lowercaseStrings = new ArrayList<>();
        for (String word : splitStrings) { //lowercase
            lowercaseStrings.add(word.toLowerCase());
        }
        return lowercaseStrings;
    }
    public static boolean checkedInteger(String tester) {
        String checker = "1234567890-";
        for (int i = 0; i < 11; i++) {
            if (tester.charAt(0) == checker.charAt(i)) {
                return true; // Skip digit words
            }
        }
        return false; // Return non-digit words

    }
    public static void printWordOccurrences(Map<String, ArrayList<Integer>> hm){
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

    public static void stringBuilderWordOccurrences(Map<String, ArrayList<Integer>> hm){
        for (String key : hm.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(key).append("(").append(hm.get(key).size()).append("): @ ");
            ArrayList<Integer> indices = hm.get(key);
            for (int i = 0; i < indices.size(); i++) {
                sb.append(indices.get(i));
                if (i < indices.size() - 1) {
                    sb.append(", @ ");
                }
            }
            System.out.println(sb.toString());
        }
    }
    public static void printHmDebugger(Map<String, ArrayList<Integer>> hm){
        for (var key : hm.keySet()) {
            System.out.println(key + ":"  +  hm.get(key));
        }
    }
}
