import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramWindow {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Fill the pCount array with frequencies of characters in p
        for (char ch : p.toCharArray()) {
            pCount[ch - 'a']++;
        }

        // Traverse the string s
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            // Remove the leftmost character of the previous window
            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            // Compare the two arrays to check for anagrams
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}


