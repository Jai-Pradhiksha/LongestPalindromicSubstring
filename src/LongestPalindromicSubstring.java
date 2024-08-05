public class LongestPalindromicSubstring {
    // Time Complexity : O(n^2)
    // Space Complexity : O(1)

    public static void main(String[] args) {
        System.out.printf("The Longest Palindromic Sub-String in \"%s\" is %s%n", "fafab", longestPalindromicSubstring("fafab")); // multiple palindromic substring
        System.out.printf("The Longest Palindromic Sub-String in \"%s\" is %s%n", "ftubhjjf", longestPalindromicSubstring("ftubhjjf")); // single palindromic substring
        System.out.printf("The Longest Palindromic Sub-String in \"%s\" is %s%n", "j", longestPalindromicSubstring("j")); // single character
        System.out.printf("The Longest Palindromic Sub-String in \"%s\" is %s%n", "jp", longestPalindromicSubstring("jp")); // no palindromic substrings
        System.out.printf("The Longest Palindromic Sub-String in \"%s\" is %s%n", "repaper", longestPalindromicSubstring("repaper")); // itself a palindrome
    }
    public static String longestPalindromicSubstring(String str) {
        if (str.length() == 0) {
            return str;
        }
        String maxStr = "";
        int maxLen = 0;

        for (int index = 0; index < str.length(); index++) {
            String currentStr = expand(str, index, index);
            int currentLen = currentStr.length();

            if (currentLen > maxLen) {
                maxLen = currentLen;
                maxStr = currentStr;
            }
            currentStr = expand(str, index, index + 1);
            currentLen = currentStr.length();

            if (currentLen > maxLen) {
                maxLen = currentLen;
                maxStr = currentStr;
            }
        }
        return maxStr;
    }

    public static String expand(String s, int low, int high) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
        }
        return s.substring(low + 1, high);
    }
}