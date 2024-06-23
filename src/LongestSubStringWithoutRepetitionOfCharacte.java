public class LongestSubStringWithoutRepetitionOfCharacte{

        public static String findLongestPalindromicSubstring(String s) {
            if (s == null || s.isEmpty()) {
                return "";

           }

            String longestPalindrome = s.substring(0, 1);

            for (int i = 0; i < s.length(); i++) {
                String oddLengthPalindrome = expandCenter(s, i, i);
                String evenLengthPalindrome = expandCenter(s,i, i + 1);

                String currentLong = oddLengthPalindrome.length() > evenLengthPalindrome.length() ? oddLengthPalindrome : evenLengthPalindrome;

                if (currentLong.length() > longestPalindrome.length()) {
                    longestPalindrome = currentLong;
                }
            }

            return longestPalindrome;
        }

        public  static String expandCenter(String str1, int left, int right) {
            while (left >= 0 && right < str1.length() && str1.charAt(left) == str1.charAt(right)) {
                left--;
                right++;
            }
            return str1.substring(left + 1, right);
        }

        public static void main(String[] args) {
            String str = "babad";
            System.out.println("Longest palindromic substring: " + findLongestPalindromicSubstring(str));
        }
    }