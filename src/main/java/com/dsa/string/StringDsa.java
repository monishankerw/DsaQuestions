package com.dsa.string;

import java.util.Arrays;

public class StringDsa {
    public static class UpperCase {
        public static void main(String[] args) {
            String str = "Hello World";
            System.out.println("Lowercase string: " + str.toLowerCase());
            System.out.println("Uppercase string: " + str.toUpperCase());

        }
    }

    public static class RemoveWhiteSpace {
        public static void main(String[] args) {
            String str = "Hello World";
            System.out.println("String with whitespace: " + str);
            System.out.println("String without whitespace: " + str.replaceAll("\\s", ""));
        }
    }

    public static class LengthOfStr {
        public static void main(String[] args) {
            String str = "Hello World";
            System.out.println("Length of string: " + str.length());
        }
    }

    public static class ConconentString {
        public static void main(String[] args) {
            String str1 = "Hello";
            String str2 = "World";
            /**
             * 	•	The concat() method appends the specified string (str2) to the end of another string (str1).
             * 	Immutable strings
             * concat() doesn’t change the original strings — it returns a new string.
             * NullPointerException
             * If you pass null to concat(), it will throw an exception.
             * Safer alternative
             * Use StringBuilder when concatenating strings in loops (for performance).
             */
            System.out.println("Concatenated string: " + str1.concat(str2));
        }
    }

    public static class CompareTwoStrCaseSensitive {
        public static void main(String[] args) {
            String str1 = "Hello";
            String str2 = "hello";
            System.out.println("Are strings equal: " + str1.equals(str2));
        }
    }

    public static class CompareTwoStrIgnoreCase {
        public static void main(String[] args) {
            String str1 = "Hello";
            String str2 = "hello";
            /**
             * equalsIgnoreCase() method in Java — useful for case-insensitive string comparison.
             * boolean result = str1.equalsIgnoreCase(str2);
             * ✅ Purpose:
             * 	•	Compares two strings, ignoring case differences.
             * 	•	Returns true if both strings are equal regardless of upper/lowercase.
             * 	Return type   :boolean
             * Null-safe?     :No. Throws NullPointerException if called on a null string
             */
            System.out.println("Are strings equal ignoring case: " + str1.equalsIgnoreCase(str2));
        }
    }

    /**
     *
     */
    public static class ConvertStrToCharArray {
        public static void main(String[] args) {
            String str = "Hello World";
            /**
             * 	•	Converts a String into a char[] (character array).
             * 	•	Each character of the string becomes an element in the array.
             * 		•	toCharArray() converts a String to a char[].
             * 	•	Arrays.toString(charArray) converts the char[] to a readable String format like [h, e, l, l, o].
             */
            char[] charArray = str.toCharArray();
            System.out.println("Character array: " + Arrays.toString(charArray));
        }
    }

    public static class SplitaSentenceBySpace {
        public static void main(String[] args) {
            String str = "Hello World";
            /**
             * 	•	split(" ") splits the string by spaces.
             * 	•	Returns a String[] array of words.
             * 	Use regex to remove extra spaces:
             * 	String[] words = str.trim().split("\\s+");
             */
            String[] words = str.split(" ");
            System.out.println("Words in sentence: " + Arrays.toString(words));
        }
    }

    public static class CheckIfStringContsinSubstring {
        public static void main(String[] args) {
            String str = "Hello World";
            String target = "World";
            /**
             * 	•	The contains() method checks whether a substring exists in a given string.
             * 	•	It returns true if the substring is found, otherwise false.
             */
            System.out.println("Does string contain substring: " + str.contains(target));
        }
    }

    //1. Remove Special Characters
    public static class RemoveSpacialCarct {
        public static void main(String[] args) {
            String input = "Di@!$^$pawa%&*li =.";
            String output = input.replaceAll("[^a-zA-Z0-9]", "");
            System.out.println("Input: " + input);
            System.out.println("Output: " + output);
        }
    }

    //2.Email Matching
    public static class EmailMatching {
        public static void main(String[] args) {
            String input = "monishanker@gmail.com";
            String output = input.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") ? "Valid" : "Invalid";
            System.out.println("Input: " + input);
            System.out.println("Output: " + output);
        }
    }

    //3.Convert CamelCase to snake_case
    public static class CamelCaseToSnakeCase {
        public static void main(String[] args) {
            String input = "camelCaseString";
            String output = input.replaceAll("(?<!^)(?=[A-Z])", "_").toLowerCase();
            System.out.println("Input: " + input);
            System.out.println("Output: " + output);
        }
    }

    public static class IsSubstring {
        public static void main(String[] args) {
            String s1 = "hello";
            String s2 = "ell";
            if (s1.contains(s2)) {
                System.out.println("String is Substring");
            } else {
                System.out.println("String is not Substring");
            }
        }
    }

    public static class ReplaceChar {
        public static void main(String[] args) {
            String str = "hello world";
            char oldChar = 'o';
            char newChar = 'x';
            String replace = str.replace(oldChar, newChar);
            System.out.println(replace);
        }
    }

    public static class StringRotations {
        public static void main(String[] args) {
            String a = "HELLO";
            String b = "LOHEL";

            System.out.println("Using Traditional Approach:");
            if (checkRotationTraditional(a, b)) {
                System.out.println("Given Strings are rotations of each other");
            } else {
                System.out.println("Given Strings are not rotations of each other");
            }


        }

        private static boolean checkRotationTraditional(String a, String b) {
            if (a.length() != b.length()) {
                return false;
            }
            String temp = a + a;
            return temp.contains(b);
        }
    }

    public static class UniqueChars {
        public static void main(String[] args) {
            String str = "unique";
            System.out.println("Unique characters: " + findUniqueCharacters(str));
        }

        private static String findUniqueCharacters(String str) {
            StringBuilder unique = new StringBuilder();
            for (char ch : str.toCharArray()) {
                if (unique.indexOf(String.valueOf(ch)) == -1) {
                    unique.append(ch);
                }
            }
            return unique.toString();
        }
    }

    public static class SubStringFromIndex2ToIndex5 {
        public static void main(String[] args) {
            String str = "Hello World";
            System.out.println("Substring from index 2 to index 5: " + str.substring(2, 5));
        }
    }

    public static class RemoveDigitsFromString {
        public static void main(String[] args) {
            String str = "Hello123World";
            System.out.println("String without digits: " + str.replaceAll("\\d", ""));
        }
    }

    public static class CheckIfStringStartsWithPrefix {
        public static void main(String[] args) {
            String str = "Hello World";
            String prefix = "Hello";
            System.out.println("Does string start with prefix: " + str.startsWith(prefix));
        }
    }

    public static class CheckIfStringEndWithSuffix {
        public static void main(String[] args) {
            String str = "Hello World";
            String suffix = "World";
            System.out.println("Does string end with suffix: " + str.endsWith(suffix));
        }
    }

    public static class ReplaceCharacter {
        public static void main(String[] args) {
            String str = "banana";
            char oldChar = 'a';
            char newChar = 'x';

            String replacedStr = str.replace(oldChar, newChar);

            System.out.println("Original String: " + str);
            System.out.println("Modified String: " + replacedStr);
        }
    }

    public static class CharFrequency {
        public static void main(String[] args) {
            String str = "banana";
            char target = 'a';

            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == target) {
                    count++;
                }
            }

            System.out.println("Character '" + target + "' appears " + count + " times.");
        }
    }

    public static class SubsequenceCheck {
        public static void main(String[] args) {
            String s1 = "abc";
            String s2 = "ahbgdc";
            System.out.println("Is subsequence: " + isSubsequence(s1, s2));
        }

        private static boolean isSubsequence(String s1, String s2) {
            int index1 = 0;
            int index2 = 0;
            while (index1 < s1.length() && index2 < s2.length()) {
                if (s1.charAt(index1) == s2.charAt(index2)) {
                    index1++;
                }
                index2++;
            }
            return index1 == s1.length();
        }
    }

    public static class ReverseString {
        public static void main(String[] args) {
            String reverseString = ReverseString.reverse("testing");
            System.out.println("Reverse String: " + reverseString);
        }

        public static String reverse(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }
    }

    public static class PalindromeString {
        public static void main(String[] args) {
            String isPalindrome = PalindromeString.isPalindrome("madam");
            System.out.println("Is Palindrome: " + isPalindrome);
        }

        public static String isPalindrome(String s) {
            String org_str = s;
            // TODO •You perform many modifications (e.g., appends) in a single-threaded context.
            StringBuilder sb = new StringBuilder();

            for (int i = s.length() - 1; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
            /**
             * charAt(int index)--Returns the character at the specified index.
             * length()--Returns the length of the string.
             * .equals(): Compares string values (content comparison).
             */
            return org_str.equals(sb.toString()) ? "Yes" : "No";
        }

        public static class ReverseSentence {
            public static void main(String[] args) {
                String reverseSenence = ReverseSentence.reverseSenence("hello world");
                System.out.println("Reverse Senence: " + reverseSenence);
            }

            public static String reverseSenence(String s) {
                String[] words = s.split(" ");
                StringBuilder sb = new StringBuilder();
                for (int i = words.length - 1; i >= 0; i--) {
                    sb.append(words[i]).append(" ");

                }
                return sb.toString();
            }
        }

        public static class IgnoreCasePalindrome {
            public static void main(String[] args) {
                IgnoreCasePalindrome.run();
            }

            public static void run() {
                String s = "A man, a plan, a canal: Panama";
                String clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                System.out.println(clean.equals(new StringBuilder(clean).reverse().toString()) ? "Palindrome" : "Not Palindrome");
            }
        }

        public static class LongesrWord {
            public static void main(String[] args) {
                String longestWord = LongesrWord.longestWord("Hello worlds");
                System.out.println("Longest Word: " + longestWord);
            }

            public static String longestWord(String s) {
                String[] words = s.split(" ");
                String longestWord = "";
                for (String word : words) {
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
                return longestWord;
            }
        }

        public static class ShortestWord {
            public static void main(String[] args) {
                String shortestWord = ShortestWord.shortestWord("Hello worlds");
                System.out.println("Shortest Word: " + shortestWord);
            }

            public static String shortestWord(String s) {
                String[] words = s.split(" ");
                String shortestWord = words[0];
                for (String word : words) {
                    if (word.length() < shortestWord.length()) {
                        shortestWord = word;
                    }
                }
                return shortestWord;
            }
        }

        public static class EvenWords {
            public static void main(String[] args) {
                String evenWord = EvenWords.evenWord("Hello worlds");
                System.out.println("Even Word: " + evenWord);
            }

            public static String evenWord(String s) {
                String[] words = s.split(" ");
                StringBuilder sb = new StringBuilder();
                for (String word : words) {
                    if (word.length() % 2 == 0) {
                        sb.append(word).append(" ");
                    }
                }
                return sb.toString();
            }
        }

        public static class WordCount {
            public static void main(String[] args) {
                String str = "This is sentence odd";
                str = str.trim();
                if (str.isEmpty()) {
                }
                int count = 1;
                for (int i = 0; i < str.length() - 1; i++) {
                    if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
    }

    public static class VowelAndCons {
        public static void main(String[] args) {
            String str = "Test Engin";

            System.out.println("Using Traditional Approach:");
            countVowelsAndConsonants(str);

            System.out.println("\nUsing Java 8 Streams:");
            countVowelsAndConsonantsUsingStreams(str);
        }

        // Traditional Approach (Without Java 8)
        private static void countVowelsAndConsonants(String str) {
            int vowels = 0, consonants = 0;
            String small = str.toLowerCase();
/**
 * ✅ toCharArray()
 *
 * toCharArray() converts a String into a character array (char[]), allowing direct access and manipulation of each character.
 *
 * ⸻
 *
 * 🔹 Example:
 *
 * String str = "Hello";
 * char[] chars = str.toCharArray();  // ['H', 'e', 'l', 'l', 'o']
 *
 *
 * ⸻
 *
 * ✅ Use Case:
 *
 * Useful when you need to:
 * 	•	Traverse each character,
 * 	•	Modify characters,
 * 	•	Perform operations like sorting or frequency count.
 *
 *
 * ✅ indexOf(ch)
 *
 * indexOf(ch) returns the index (position) of the first occurrence of the specified character ch in a string. If the character is not found, it returns -1.
 *
 * ⸻
 *
 * 🔹 Example:
 *
 * String str = "banana";
 * int index = str.indexOf('a');  // Output: 1 (first 'a' is at index 1)
 *
 *
 * ⸻
 *
 * ✅ Use Cases:
 * 	•	Finding the position of a character.
 * 	•	Checking if a character exists (indexOf(ch) != -1).
 * 	•	Useful in parsing, validation, and search operations.
 *
 */
            for (char ch : small.toCharArray()) {
                if (Character.isLetter(ch)) {  // Check if it's a letter
                    if ("aeiou".indexOf(ch) != -1) {
                        vowels++;
                    } else {
                        consonants++;
                    }
                }
            }

            System.out.println("Vowels: " + vowels);
            System.out.println("Consonants: " + consonants);
        }

        // Java 8 Stream-Based Approach
        private static void countVowelsAndConsonantsUsingStreams(String str) {
            long vowels = str.toLowerCase()
                    .chars()
                    .filter(c -> "aeiou".indexOf(c) != -1)
                    .count();

            long consonants = str.toLowerCase()
                    .chars()
                    .filter(c -> Character.isLetter(c) && "aeiou".indexOf(c) == -1)
                    .count();

            System.out.println("Vowels: " + vowels);
            System.out.println("Consonants: " + consonants);
        }
    }
    public static class Anagram {
        public static void main(String[] args) {
            String str1 = "listen";
            String str2 = "silent";
            if (str1.length() != str2.length()) {
                System.out.println("Not Anagram");

            }
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            if (Arrays.equals(arr1, arr2)) {
                System.out.println("Anagram");
            } else {
                System.out.println("Not Anagram");
            }
        }
    }
    public static class LongestPrefixSuffix {
        public static void main(String[] args) {
            String str = "ababcababc";
            System.out.println("Longest prefix suffix: " + longestPrefixSuffix(str));
        }

        // This method finds the longest prefix which is also a suffix in the given string.
        private static String longestPrefixSuffix(String str) {
            int n = str.length();
            String prefixSuffix = "";
            // Iterate through the first half of the string
            for (int i = 0; i < n / 2; i++) {
                prefixSuffix = str.substring(0, i + 1);
                // Log the current prefix being evaluated
                System.out.println("Current prefix/suffix: " + prefixSuffix);
            }
            return prefixSuffix;
        }
    }

    public static class SubstringSearch {
        public static void main(String[] args) {
            String text = "hello world";
            String pattern = "world";
            int result = bruteForceSearch(text, pattern);
            System.out.println("Pattern found at index: " + result);
        }

        private static int bruteForceSearch(String text, String pattern) {
            int n = text.length();
            int m = pattern.length();

            for (int i = 0; i <= n - m; i++) {
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == m) return i; // Found pattern
            }
            return -1; // Not found
        }
    }
    public static class PalindromicSubstrings {
        /**
         A substring is a contiguous sequence of characters.
         A palindrome is a string that reads the same forward and backward.
         */
        public static void main(String[] args) {
            String str = "abc";
            //o/p: Count of palindromic substrings: 3
            System.out.println("Count of palindromic substrings: " + countPalindromicSubstrings(str));
        }

        private static int countPalindromicSubstrings(String s) {
            /**
             * 	•	We expand around each center of the string.
             * 	•	Each character is treated as a center of a palindrome.
             * 	•	Two cases:
             * 	•	Odd length palindrome: center at i
             * 	•	Even length palindrome: center between i and i+1
             */
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                count += expandAroundCenter(s, i, i);
                count += expandAroundCenter(s, i, i + 1);
            }
            return count;
        }

        /**
         •	Expands outward while characters at left and right are equal.
         •	Increments count for each palindrome found.
         */
        private static int expandAroundCenter(String s, int left, int right) {
            int count = 0;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
            return count;
        }
        /**
         * 🧠 Step-by-Step for "abc"
         *
         * Let’s go over the loop:
         * 	•	i = 0:
         * 	•	expandAroundCenter(0, 0): “a” → palindrome → count = 1
         * 	•	expandAroundCenter(0, 1): “ab” → not a palindrome
         * 	•	i = 1:
         * 	•	expandAroundCenter(1, 1): “b” → palindrome → count = 2
         * 	•	expandAroundCenter(1, 2): “bc” → not a palindrome
         * 	•	i = 2:
         * 	•	expandAroundCenter(2, 2): “c” → palindrome → count = 3
         * 	•	expandAroundCenter(2, 3): out of bounds → ignored
         *
         * ✅ Final result: 3 palindromic substrings → “a”, “b”, “c”
         *
         * ⸻
         *
         * ✅ Time & Space Complexity
         * Metric
         * Value
         * Time Complexity
         * O(n²)
         * Space Complexity
         * O(1)
         */
    }
    public static class LongestPalindromicSubstring {
        public static void main(String[] args) {
            String str = "babad";
            System.out.println("Longest palindromic substring: " + longestPalindromicSubstring(str));
        }

        private static String longestPalindromicSubstring(String s) {
            //	If input string is empty, return empty.
            if (s.isEmpty()) return "";
            //	•	Keeps track of the longest palindromic substring found.
            String longest = "";
            //Loop through each character of the string, treating each index i as the center of a possible palindrome.
            for (int i = 0; i < s.length(); i++) {
                //odd handles odd-length palindromes like "aba" (center at i).
                // even handles even-length palindromes like "abba" (center between i and i+1).
                String odd = expandAroundCenter(s, i, i);
                String even = expandAroundCenter(s, i, i + 1);
                //	•	Picks the longer of the two palindromes for this center.
                String max = odd.length() > even.length() ? odd : even;
                //	•	Update longest if a new longer palindrome is found.
                if (max.length() > longest.length()) {
                    longest = max;
                }
            }
            return longest;
        }

        private static String expandAroundCenter(String s, int left, int right) {
            //This expands from the center (odd or even) as long as:
            //	•	The characters on both sides are equal.
            //	•	The indices stay within bounds.
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            //	•	Returns the substring from (left+1) to right.
            return s.substring(left + 1, right);
        }
        /**
         *
         ✅ Example Walkthrough (Input: "babad")
         •	i = 0:
         •	Odd: "b"
         •	Even: ""
         → max: "b"
         •	i = 1:
         •	Odd: "bab" ✅
         •	Even: ""
         → max: "bab" (update longest)
         •	i = 2:
         •	Odd: "aba" ✅
         •	Even: ""
         → max: "aba" (same length)
         •	Final result: "bab" or "aba"

         Metric
         Value
         Time Complexity
         O(n²)
         Space Complexity
         O(1)

         */
    }
}
