package com.dsa.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapStringQuestions {
    /*
    🧑‍💻 0–1 Years Experience (Beginner Level)
     */
    //1. Count frequency of characters in a string	“banana”	{b=1, a=3, n=2}
    public static class FrqOcc {
        public static void main(String[] args) {
            String str = "banana";
            Map<Character, Long> freOccs = freOccsJava8(str);
            System.out.println("Freq Occ::" + freOccs);
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
/*
toCharArray method is used to convert a String into a character array (char[]).
getOrDefault method is used to retrieve the value associated with the given key from the map.
If the key is not found in the map, it returns the specified default value.
 */
            }
            System.out.println("Frequency of characters: " + map);
        }

        private static Map<Character, Long> freOccsJava8(String str) {
            return str
                    // Step 1: Convert the string into an IntStream of character Unicode values
                    .chars()

                    // Step 2: Convert each int (Unicode) into a Character object
                    .mapToObj(c -> (char) c)

                    // Step 3: Group the characters using Collectors.groupingBy
                    //         and count their occurrences using Collectors.counting()
                    .collect(
                            Collectors.groupingBy(
                                    Function.identity(),   // key: the character itself
                                    Collectors.counting()  // value: number of times it occurs
                            )
                    );
        }


    }

    /*
    2	Find first non-repeating character	“swiss”	'w'
     */
    public static class FindFirstNonRepeatingChar {
        public static void main(String[] args) {
            String str = "swiss";
            Optional<Character> firstNonRepeatingChar = findFirstNonRepeatingCharJava8(str);
            System.out.println("FindFirstNonRepeatingChar :: " +
                    firstNonRepeatingChar.orElse('∅'));  // ∅ is just a symbol for "none"

            Map<Character, Integer> map = new HashMap<>();
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    System.out.println("First non-repeating character: " + entry.getKey());
                    break;
                }
            }
        }

        /**
         *  Explanation Recap:
         * 	1.	str.chars() — converts the string into an IntStream of Unicode code points.
         * 	2.	.mapToObj(c -> (char) c) — casts each int to a char, giving a Stream<Character>.
         * 	3.	groupingBy(..., LinkedHashMap::new, counting()) — groups and counts each character, keeping order.
         * 	4.	Stream over entrySet — filters entries with count 1 and returns the first one.

         For the input "swiss":
         •	Frequencies: {s=3, w=1, i=1}
         •	The first character with count 1 is: 'w'
         */
        private static Optional<Character> findFirstNonRepeatingCharJava8(String str) {
            Map<Character, Long> frequencyMap = str.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(
                            Function.identity(),
                            LinkedHashMap::new, // Maintain insertion order
                            Collectors.counting()
                    ));

            // Find the first entry with count 1
            return frequencyMap.entrySet().stream()
                    .filter(entry -> entry.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .findFirst();
        }
    }

    /*
    3	Check if two strings are anagrams	“listen”, “silent”	true

     */
    public static class CheckAnagrams {
        public static void main(String[] args) {
            String str1 = "listen";
            String str2 = "silent";
            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();
            for (char ch : str1.toCharArray()) {
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
            }
            for (char ch : str2.toCharArray()) {
                map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            }
            if (map1.equals(map2)) {
                System.out.println("The strings are anagrams.");
            } else {
                System.out.println("The strings are not anagrams.");
            }
        }
    }

    /*
    4. Find duplicate characters	“programming”	[r, g, m]

     */
    public static class FindDuplicateChar {
        public static void main(String[] args) {
            String str = "programming";
            Optional<Character> duplicateChar = findDuplicateCharJava8(str);
            System.out.println("FindDuplicateChar :: " +
                    duplicateChar.orElse('∅'));
            Map<Character, Integer> map = new HashMap<>();

            // Step 1: Count frequency of each character
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            // Step 2: Print characters with frequency > 1
            //Loop through the map and print entries where the value (frequency) is greater than 1:
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                    System.out.println("Duplicate character: " + entry.getKey());
                }
            }
        }

        private static Optional<Character> findDuplicateCharJava8(String str) {
            Map<Character, Long> frequencyMap = str.chars()
                    .mapToObj(c -> (char) c) // convert int to char
                    .collect(Collectors.groupingBy(
                            Function.identity(),   // group by character
                            LinkedHashMap::new,    // preserve insertion order
                            Collectors.counting()  // count occurrences
                    ));

            // Return the first duplicate character (frequency > 1)
            return frequencyMap.entrySet().stream()
                    .filter(entry -> entry.getValue() > 1)
                    .map(Map.Entry::getKey)
                    .findFirst(); // returns Optional<Character>
        }

    }

    /*
    5	Check if a string can be rearranged to form a palindrome	“civic”	true
     */
    public static class RearrangePalindrome {
        public static void main(String[] args) {
            String str = "civic";
           Optional<Boolean> isPalindrome = rearrangeToFormPalindromeJava8(str);
            System.out.println("RearrangePalindrome :: " +isPalindrome);
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            int count = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 == 1) {
                    count++;
                }
            }
            if (count <= 1) {
                System.out.println("The string can be rearranged to form a palindrome.");
            } else {
                System.out.println("The string cannot be rearranged to form a palindrome.");
            }
        }

        private static Optional<Boolean> rearrangeToFormPalindromeJava8(String str) {
            Map<Character, Long> frequencyMap = str.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(
                            Function.identity(),
                            LinkedHashMap::new,
                            Collectors.counting()
                    ));
            // Check if there is exactly one character with odd frequency
            return frequencyMap.entrySet().stream()
                    .filter(entry -> entry.getValue() % 2 == 1)
                    .count() == 1 ? Optional.of(true) : Optional.of(false);
        }
    }

    /*
    6	Find first repeated character	“geeksforgeeks”	'e'

     */
    public static class FindFirstRepeatedChar {
        public static void main(String[] args) {
            String str = "geeksforgeeks";

            Optional<Character> firstRepeatedChar = findFirstRepeatedCharJava8(str);
            System.out.println("FindFirstRepeatedChar :: " + firstRepeatedChar.orElse('∅'));

            // Corrected imperative approach using LinkedHashMap
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                    System.out.println("First repeated character: " + entry.getKey());
                    break;
                }
            }
        }

        private static Optional<Character> findFirstRepeatedCharJava8(String str) {
            Map<Character, Long> frequencyMap = str.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(
                            Function.identity(),
                            LinkedHashMap::new,
                            Collectors.counting()
                    ));

            return frequencyMap.entrySet().stream()
                    .filter(entry -> entry.getValue() > 1)
                    .map(Map.Entry::getKey)
                    .findFirst();
        }
    }

    /*
    7	Remove duplicate characters (keep order)	“programming”	"progamin"

     */
    public static class RemoveDuplicateChar {
        public static void main(String[] args) {
            String str = "programming";
            Optional<String> results =removeDuplicateCharJava8(str);
            System.out.println("RemoveDuplicateChar :: " + results.orElse("∅"));

            Map<Character, Integer> map = new HashMap<>();
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            String result = "";
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    result += entry.getKey();
                }
            }
            System.out.println("String after removing duplicates: " + result);
        }

        private static Optional<String> removeDuplicateCharJava8(String str) {
            // Step 1: Create frequency map with LinkedHashMap to maintain insertion order
            Map<Character, Long> frequencyMap = str.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(
                            Function.identity(),
                            LinkedHashMap::new,
                            Collectors.counting()
                    ));

            // Step 2: Filter characters with count == 1 and collect to string
            String result = frequencyMap.entrySet().stream()
                    .filter(entry -> entry.getValue() == 1)
                    .map(entry -> entry.getKey().toString())
                    .collect(Collectors.joining());

            System.out.println("String after removing duplicates: " + result);
            return Optional.of(result);
        }
    }

    /*
    8	Replace repeated characters with ‘*’	“apple”	"ap*le"

     */
    public static class ReplaceRepeatedChar {
        public static void main(String[] args) {
            String str = "apple";

            // ✅ Imperative approach
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            StringBuilder result1 = new StringBuilder();
            for (char ch : str.toCharArray()) {
                if (map.get(ch) > 1) {
                    result1.append(ch).append("*");
                } else {
                    result1.append(ch);
                }
            }
            System.out.println("Imperative → " + result1);

            // ✅ Java 8 Stream approach
            Map<Character, Long> freqMap = str.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

            String result2 = str.chars()
                    .mapToObj(c -> {
                        char ch = (char) c;
                        return freqMap.get(ch) > 1 ? ch + "*" : String.valueOf(ch);
                    })
                    .collect(Collectors.joining());

            System.out.println("Java 8 Stream → " + result2);
        }
    }

    /*
    9	Count vowels and consonants	“interview”	{vowels=4, consonants=5}

     */
    public class CountVowelsAndConsonants {
        public static void main(String[] args) {
            String str = "interview";

            // ✅ Imperative approach
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            int vowels = 0, consonants = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (isVowel(entry.getKey())) {
                    vowels += entry.getValue();
                } else {
                    consonants += entry.getValue();
                }
            }

            System.out.println("Imperative → Vowels: " + vowels + ", Consonants: " + consonants);

            // ✅ Java 8 approach
            Map<Boolean, Long> result = str.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.partitioningBy(
                            CountVowelsAndConsonants::isVowel,
                            Collectors.counting()
                    ));

            long vowelCount = result.getOrDefault(true, 0L);
            long consonantCount = result.getOrDefault(false, 0L);

            System.out.println("Java 8 Stream → Vowels: " + vowelCount + ", Consonants: " + consonantCount);
        }

        // ✅ Utility method to check vowels
        private static boolean isVowel(char ch) {
            return "aeiouAEIOU".indexOf(ch) != -1;
        }
    }

    /*
    10	Count uppercase and lowercase letters	“JavaProgramming”	{upper=2, lower=13}

     */
    public static class CountUppercaseAndLowercase {
        public static void main(String[] args) {
            String str = "JavaProgramming";

            // ✅ Imperative approach
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            int uppercase = 0, lowercase = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (Character.isUpperCase(entry.getKey())) {
                    uppercase += entry.getValue();
                } else {
                    lowercase += entry.getValue();
                }
            }

            System.out.println("Imperative → Uppercase: " + uppercase + ", Lowercase: " + lowercase);

            // ✅ Java 8 approach
            Map<Boolean, Long> result = str.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.partitioningBy(
                            Character::isUpperCase,
                            Collectors.counting()
                    ));

            long upperCount = result.getOrDefault(true, 0L);
            long lowerCount = result.getOrDefault(false, 0L);

            System.out.println("Java 8 Stream → Uppercase: " + upperCount + ", Lowercase: " + lowerCount);
        }
    }

    /*
    🧑‍🎓 1–2 Years Experience
     */
  /*
  11	Group characters by frequency	“tree”	{t=1, r=1, e=2}

   */
    public static class GroupCharactersByFrequency {
        public static void main(String[] args) {
            String str = "tree";
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        }
    }

    /*
    12	Sort characters by frequency	“cccaaa”	"aaaccc" or "cccaaa"

     */
    public static class SortCharactersByFrequency {
        public static void main(String[] args) {
            String str = "cccaaa";
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort((a, b) -> b.getValue() - a.getValue());
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : list) {
                for (int i = 0; i < entry.getValue(); i++) {
                    sb.append(entry.getKey());
                }
            }
            System.out.println("String after sorting by frequency: " + sb);
        }
    }

    /*
    13	Longest substring without repeating characters	“abcabcbb”	3
     */
    public static class LongestSubstringWithoutRepeatingCharacters {
        public static void main(String[] args) {
            String str = "abcabcbb";
            Map<Character, Integer> map = new HashMap<>();
            int maxLength = 0;
            int start = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (map.containsKey(ch)) {
                    start = Math.max(start, map.get(ch) + 1);
                }
                map.put(ch, i);
                maxLength = Math.max(maxLength, i - start + 1);
            }
            System.out.println("Length of longest substring without repeating characters: " + maxLength);
        }
    }

    /*
    14	Minimum window substring with all characters of another string	s = “ADOBECODEBANC”, t=“ABC”	"BANC"
     */
    public static class MinimumWindowSubstring {
        public static void main(String[] args) {
            String s = "ADOBECODEBANC";
            String t = "ABC";
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : t.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            int count = map.size();
            int start = 0, end = 0, minLen = Integer.MAX_VALUE;
            while (end < s.length()) {
                char ch = s.charAt(end);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) == 0) {
                        count--;
                    }
                }
                end++;
                while (count == 0) {
                    if (end - start < minLen) {
                        minLen = end - start;
                    }
                    char ch1 = s.charAt(start);
                    if (map.containsKey(ch1)) {
                        map.put(ch1, map.get(ch1) + 1);
                        if (map.get(ch1) > 0) {
                            count++;
                        }
                    }
                    start++;
                }
            }
            System.out.println("Minimum window substring: " + s.substring(start, start + minLen));
        }
    }

    /*
    15	Count all anagram substrings	“forxxorfxdofr”, “for”	3

     */
    public static class CountAllAnagramSubstrings {
        public static void main(String[] args) {
            String s = "forxxorfxdofr";
            String t = "for";
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : t.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            int count = map.size();
            int start = 0, end = 0, result = 0;
            while (end < s.length()) {
                char ch = s.charAt(end);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) == 0) {
                        count--;
                    }
                }
                end++;
                while (count == 0) {
                    result++;
                    char ch1 = s.charAt(start);
                    if (map.containsKey(ch1)) {
                        map.put(ch1, map.get(ch1) + 1);
                        if (map.get(ch1) > 0) {
                            count++;
                        }
                    }
                    start++;
                }
            }
            System.out.println("Count all anagram substrings: " + result);
        }
    }

    /*
    16	Count palindromic characters	“racecar”	true

     */
    public static class CountPalindromicCharacters {
        public static void main(String[] args) {
            String s = "racecar";
            Map<Character, Integer> map = new HashMap<>();

            // Count frequency
            for (char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            // Count characters with odd frequency
            int oddCount = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    oddCount++;
                }
            }

            boolean canBePalindrome = oddCount <= 1;
            System.out.println("Input: " + s);
            System.out.println("Character frequencies: " + map);
            System.out.println("Odd frequency character count: " + oddCount);
            System.out.println("Can be rearranged to palindrome: " + canBePalindrome);
        }
    }

    /*
    17	First word with unique characters	“red green blue red green”	"blue"

     */
    public static class FirstUniqueWord {
        public static void main(String[] args) {
            String input = "red green blue red green";

            // Step 1: Split words
            String[] words = input.split(" ");
            Map<String, Integer> map = new LinkedHashMap<>(); // LinkedHashMap preserves order

            // Step 2: Count frequency
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            // Step 3: Find first word with frequency = 1
            String result = null;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    result = entry.getKey();
                    break;
                }
            }

            System.out.println("Input: " + input);
            System.out.println("First unique word: " + result); // Output: "blue"
        }
    }

    /*
    18	Count words in a sentence	“the dog and the cat”	{the=2, dog=1, and=1, cat=1}

     */
    public static class WordFrequencyCounter {
        public static void main(String[] args) {
            String input = "the dog and the cat";

            String[] words = input.split(" ");
            Map<String, Integer> map = new LinkedHashMap<>(); // Maintains order

            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            System.out.println("Input: " + input);
            System.out.println("Word frequencies: " + map); // Output: {the=2, dog=1, and=1, cat=1}
        }
    }
    /*
    19	Most frequent word	“apple banana apple orange”	"apple"

     */

    public static class MostFrequentWord {
        public static void main(String[] args) {
            String input = "apple banana apple orange";

            String[] words = input.split(" ");
            Map<String, Integer> map = new HashMap<>();

            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            String mostFrequentWord = null;
            int maxCount = 0;

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxCount) {
                    mostFrequentWord = entry.getKey();
                    maxCount = entry.getValue();
                }
            }

            System.out.println("Input: " + input);
            System.out.println("Word frequencies: " + map);
            System.out.println("Most frequent word: " + mostFrequentWord); // Output: apple
        }
    }

    /*
    20	Find the highest frequency character	“helloooworld”	'o'

     */
    public class HighestFrequencyCharacter {
        public static void main(String[] args) {
            String input = "helloooworld";

            Map<Character, Integer> map = new HashMap<>();
            for (char ch : input.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            char maxChar = 0;
            int maxCount = 0;

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxChar = entry.getKey();
                    maxCount = entry.getValue();
                }
            }

            System.out.println("Input: " + input);
            System.out.println("Character frequencies: " + map);
            System.out.println("Highest frequency character: " + maxChar + " (count=" + maxCount + ")");
        }
    }


    public static class StringMapQuestions_2to3Years {

        // Q21: Group words by frequency
        public static Map<String, Integer> groupWordsByFrequency(String input) {
            String[] words = input.split(" ");
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            return map;
        }

        // Q22: Check if all characters have same frequency
        public static boolean hasSameCharFrequency(String input) {
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : input.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            Set<Integer> freqSet = new HashSet<>(map.values());
            return freqSet.size() == 1;
        }

        // Q23: Frequency of digits in a string
        public static Map<Character, Integer> digitFrequency(String input) {
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : input.toCharArray()) {
                if (Character.isDigit(ch)) {
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                }
            }
            return map;
        }

        // Q24: Frequency of each word using LinkedHashMap
        public static Map<String, Integer> wordFrequencyLinkedHashMap(String input) {
            String[] words = input.split(" ");
            Map<String, Integer> map = new LinkedHashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            return map;
        }

        // Q25: Unique characters in each window of size k
        public static List<Integer> uniqueCharsInWindows(String input, int k) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i <= input.length() - k; i++) {
                String window = input.substring(i, i + k);
                Set<Character> set = new HashSet<>();
                for (char ch : window.toCharArray()) set.add(ch);
                result.add(set.size());
            }
            return result;
        }

        // Q26: Count substrings with equal number of 0s and 1s
        public static int countEqual0s1s(String s) {
            int count = 0, zero = 0, one = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1); // diff zero - one
            for (char ch : s.toCharArray()) {
                if (ch == '0') zero++;
                else one++;
                int diff = zero - one;
                count += map.getOrDefault(diff, 0);
                map.put(diff, map.getOrDefault(diff, 0) + 1);
            }
            return count;
        }

        // Q27: Reverse frequency order of characters
        public static List<Character> reverseFrequencyOrder(String input) {
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : input.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
            entries.sort((a, b) -> b.getValue() - a.getValue());

            List<Character> result = new ArrayList<>();
            for (Map.Entry<Character, Integer> entry : entries) {
                result.add(entry.getKey());
            }
            return result;
        }

        // Q28: Count even and odd frequency characters
        public static Map<String, Integer> evenOddCharFrequency(String input) {
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : input.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            int even = 0, odd = 0;
            for (int freq : map.values()) {
                if (freq % 2 == 0) even++;
                else odd++;
            }

            Map<String, Integer> result = new HashMap<>();
            result.put("even", even);
            result.put("odd", odd);
            return result;
        }

        // Q29: Lowercase word frequency
        public static Map<String, Integer> lowerCaseWordFrequency(String input) {
            String[] words = input.toLowerCase().split(" ");
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            return map;
        }

        // Q30: Count bigram (character pair) occurrences
        public static Map<String, Integer> bigramFrequency(String input) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < input.length() - 1; i++) {
                String pair = input.substring(i, i + 2);
                map.put(pair, map.getOrDefault(pair, 0) + 1);
            }
            return map;
        }

        // MAIN DRIVER to test all
        public static void main(String[] args) {
            System.out.println("Q21: " + groupWordsByFrequency("a b a c b c c"));
            System.out.println("Q22: " + hasSameCharFrequency("abab"));
            System.out.println("Q23: " + digitFrequency("a1b2c3a4"));
            System.out.println("Q24: " + wordFrequencyLinkedHashMap("dog cat dog"));
            System.out.println("Q25: " + uniqueCharsInWindows("abcabc", 3));
            System.out.println("Q26: " + countEqual0s1s("0101"));
            System.out.println("Q27: " + reverseFrequencyOrder("abbccc"));
            System.out.println("Q28: " + evenOddCharFrequency("aabbbccdd"));
            System.out.println("Q29: " + lowerCaseWordFrequency("Java java"));
            System.out.println("Q30: " + bigramFrequency("hello"));
        }
    }

    public static class MapStringQuestions_3to4Years {

        // 31. Check if string contains all characters of another string
        public static class ContainsAllChars {
            public static void main(String[] args) {
                String s1 = "abcdef", s2 = "fed";
                Set<Character> set = new HashSet<>();
                for (char c : s1.toCharArray()) set.add(c);
                boolean result = true;
                for (char c : s2.toCharArray()) {
                    if (!set.contains(c)) {
                        result = false;
                        break;
                    }
                }
                System.out.println("Contains all chars: " + result); // true
            }
        }

        // 32. Check if string is a permutation of palindrome
        public static class IsPalindromePermutation {
            public static void main(String[] args) {
                String s = "tactcoa";
                Map<Character, Integer> map = new HashMap<>();
                for (char c : s.toCharArray())
                    map.put(c, map.getOrDefault(c, 0) + 1);

                int odd = 0;
                for (int freq : map.values())
                    if (freq % 2 != 0) odd++;

                System.out.println("Is Palindrome Permutation: " + (odd <= 1)); // true
            }
        }

        // 33. Group anagrams
        public static class GroupAnagrams {
            public static void main(String[] args) {
                String[] arr = {"bat", "tab", "cat"};
                Map<String, List<String>> map = new HashMap<>();
                for (String word : arr) {
                    char[] ch = word.toCharArray();
                    Arrays.sort(ch);
                    String sorted = new String(ch);
                    map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(word);
                }
                System.out.println("Grouped Anagrams: " + map.values());
            }
        }

        // 34. Character frequency in every kth index
        public static class FrequencyEveryKth {
            public static void main(String[] args) {
                String s = "abcdefabc";
                int k = 3;
                Map<Character, Integer> map = new HashMap<>();
                for (int i = 0; i < s.length(); i += k)
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

                System.out.println("Every Kth Frequency: " + map); // {a=2, d=1}
            }
        }

        // 35. Frequency of each character in lexicographical order
        public static class LexicalFreq {
            public static void main(String[] args) {
                String s = "cbabc";
                Map<Character, Integer> map = new TreeMap<>();
                for (char c : s.toCharArray())
                    map.put(c, map.getOrDefault(c, 0) + 1);

                System.out.println("Lexical Order Freq: " + map); // {a=1, b=2, c=2}
            }
        }

        // 36. Count pairs of characters with same frequency
        public static class PairsWithSameFreq {
            public static void main(String[] args) {
                String s = "aabbcc";
                Map<Character, Integer> map = new HashMap<>();
                for (char c : s.toCharArray())
                    map.put(c, map.getOrDefault(c, 0) + 1);

                Set<Integer> freqs = new HashSet<>();
                int count = 0;
                for (int freq : map.values()) {
                    if (freqs.contains(freq)) count++;
                    else freqs.add(freq);
                }
                System.out.println("Pairs with same frequency: " + count); // 3
            }
        }

        // 37. Maximum frequency substring of size k
        public static class MaxFreqSubstring {
            public static void main(String[] args) {
                String s = "abcabcabc";
                int k = 3;
                Map<String, Integer> map = new HashMap<>();
                for (int i = 0; i <= s.length() - k; i++) {
                    String sub = s.substring(i, i + k);
                    map.put(sub, map.getOrDefault(sub, 0) + 1);
                }
                String maxStr = "";
                int max = 0;
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > max) {
                        max = entry.getValue();
                        maxStr = entry.getKey();
                    }
                }
                System.out.println("Max frequency substring: " + maxStr); // abc
            }
        }

        // 38. Find if map of character frequencies is palindrome
        public static class FreqIsPalindrome {
            public static void main(String[] args) {
                String s = "aabbcc";
                Map<Character, Integer> map = new HashMap<>();
                for (char c : s.toCharArray())
                    map.put(c, map.getOrDefault(c, 0) + 1);

                int oddCount = 0;
                for (int val : map.values())
                    if (val % 2 != 0) oddCount++;

                System.out.println("Freqs form palindrome? " + (oddCount <= 1)); // true
            }
        }

        // 39. Frequency-based sorting of string characters
        public static class FreqSort {
            public static void main(String[] args) {
                String s = "tree";
                Map<Character, Integer> map = new HashMap<>();
                for (char c : s.toCharArray())
                    map.put(c, map.getOrDefault(c, 0) + 1);

                List<Character> chars = new ArrayList<>(map.keySet());
                chars.sort((a, b) -> map.get(b) - map.get(a));

                StringBuilder sb = new StringBuilder();
                for (char c : chars)
                    sb.append(String.valueOf(c).repeat(map.get(c)));

                System.out.println("Sorted by frequency: " + sb); // eetr or eert
            }
        }

        // 40. Find missing lowercase characters in string
        public static class FindMissingChars {
            public static void main(String[] args) {
                String s = "thequickbrownfxjmpsvlazydg";
                Set<Character> set = new HashSet<>();
                for (char c : s.toCharArray())
                    set.add(c);
                boolean allPresent = true;
                for (char c = 'a'; c <= 'z'; c++) {
                    if (!set.contains(c)) {
                        allPresent = false;
                        System.out.println("Missing: " + c);
                        break;
                    }
                }
                System.out.println("All lowercase present? " + allPresent); // false
            }
        }
    }

    public static class MapStringQuestionsAdvanced {

        // 41. Pattern match string to word format
        public static boolean wordPattern(String pattern, String str) {
            String[] words = str.split(" ");
            if (words.length != pattern.length()) return false;

            Map<Character, String> map = new HashMap<>();
            Set<String> used = new HashSet<>();

            for (int i = 0; i < pattern.length(); i++) {
                char c = pattern.charAt(i);
                String w = words[i];

                if (map.containsKey(c)) {
                    if (!map.get(c).equals(w)) return false;
                } else {
                    if (used.contains(w)) return false;
                    map.put(c, w);
                    used.add(w);
                }
            }
            return true;
        }

        // 42. Find top K frequent words
        public static List<String> topKFrequentWords(String[] words, int k) {
            Map<String, Integer> freq = new HashMap<>();
            for (String word : words) freq.put(word, freq.getOrDefault(word, 0) + 1);

            return freq.entrySet().stream()
                    .sorted((a, b) -> b.getValue().equals(a.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue())
                    .limit(k)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }

        // 43. Custom frequency comparator
        public static String customFrequencySort(String s) {
            Map<Character, Integer> freq = new HashMap<>();
            for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);

            return freq.entrySet().stream()
                    .sorted((a, b) -> b.getValue().equals(a.getValue()) ? a.getKey() - b.getKey() : b.getValue() - a.getValue())
                    .map(e -> String.valueOf(e.getKey()).repeat(e.getValue()))
                    .collect(Collectors.joining());
        }

        // 44. Frequency map of each substring of size K
        public static List<Map<Character, Integer>> substringFrequencyMap(String s, int k) {
            List<Map<Character, Integer>> result = new ArrayList<>();
            for (int i = 0; i <= s.length() - k; i++) {
                String sub = s.substring(i, i + k);
                Map<Character, Integer> map = new HashMap<>();
                for (char c : sub.toCharArray()) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
                result.add(map);
            }
            return result;
        }

        // 45. Frequency map using stream API
        public static Map<Character, Long> streamFrequency(String s) {
            return s.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        }

        // 46. Sorted frequency map using TreeMap
        public static Map<Character, Integer> sortedFrequencyMap(String s) {
            Map<Character, Integer> map = new TreeMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            return map;
        }

        // 47. Frequency of words ignoring case
        public static Map<String, Integer> frequencyIgnoreCase(String s) {
            String[] words = s.toLowerCase().split(" ");
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
            return map;
        }

        // 48. Count duplicate bigrams
        public static Map<String, Integer> bigramFrequency(String s) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length() - 1; i++) {
                String bigram = s.substring(i, i + 2);
                map.put(bigram, map.getOrDefault(bigram, 0) + 1);
            }
            return map;
        }

        // 49. Merge two frequency maps
        public static Map<String, Integer> mergeFrequencyMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
            Map<String, Integer> result = new HashMap<>(map1);
            for (Map.Entry<String, Integer> entry : map2.entrySet()) {
                result.put(entry.getKey(), result.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
            return result;
        }

        // 50. Character to list of indexes map
        public static Map<Character, List<Integer>> charIndexMap(String s) {
            Map<Character, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.computeIfAbsent(c, x -> new ArrayList<>()).add(i);
            }
            return map;
        }

        // Test driver
        public static void main(String[] args) {
            System.out.println("Q41: " + wordPattern("abba", "dog cat cat dog"));
            System.out.println("Q42: " + topKFrequentWords(new String[]{"apple", "banana", "apple"}, 1));
            System.out.println("Q43: " + customFrequencySort("ddccbbbaaa"));
            System.out.println("Q44: " + substringFrequencyMap("aabba", 2));
            System.out.println("Q45: " + streamFrequency("success"));
            System.out.println("Q46: " + sortedFrequencyMap("dcbaabcd"));
            System.out.println("Q47: " + frequencyIgnoreCase("Java java JAVA"));
            System.out.println("Q48: " + bigramFrequency("hellohello"));

            Map<String, Integer> map1 = new HashMap<>();
            map1.put("a", 2);
            Map<String, Integer> map2 = new HashMap<>();
            map2.put("a", 3);
            System.out.println("Q49: " + mergeFrequencyMaps(map1, map2));

            System.out.println("Q50: " + charIndexMap("banana"));
        }
    }

}