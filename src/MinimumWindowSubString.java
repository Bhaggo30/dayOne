public class MinimumWindowSubString {


        public static String findMinimumWindowSubstring(String s, String t) {
            // Initialize variables
            int minWindowStart = 0;
            int minWindowEnd = 0;
            int minWindowLength = Integer.MAX_VALUE;
            String minWindow = "";

            // Iterate over the string s
            for (int i = 0; i < s.length(); i++) {
                // Initialize a flag to check if all characters of t are found
                boolean allCharsFound = true;

                // Iterate over the string t
                for (int j = 0; j < t.length(); j++) {
                    // Check if the character is found in the current window
                    if (s.indexOf(t.charAt(j), i) == -1) {
                        allCharsFound = false;
                        break;
                    }
                }

                // If all characters of t are found, update the minimum window
                if (allCharsFound) {
                    int windowLength = s.length() - i;
                    if (windowLength < minWindowLength) {

                        minWindowStart = i;
                        minWindowEnd = s.length();
                        minWindowLength = windowLength;
                        minWindow = s.substring(minWindowStart, minWindowEnd);
                    }
                }
            }

            return minWindow;
        }

        public static void main(String[] args) {
            String s = "ADOBECODEBANC";
            String t = "ABC";
            System.out.println("Minimum window substring: " + findMinimumWindowSubstring(s, t));
        }
    }

