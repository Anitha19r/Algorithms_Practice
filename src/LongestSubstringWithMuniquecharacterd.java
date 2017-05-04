import java.util.HashMap;

public class LongestSubstringWithMuniquecharacterd {
	 
    public static String getLongestSubstringWithMUniqueCharacters(String s, Integer m) throws Exception {
        int start = 0, end = 0, windowSize = 1, windowStart = 0;
        int n = s.length();
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        char ch = s.charAt(0);
        hash.put(ch, 1);
 
        for (int i = 1; i < n; i++) {
            ch = s.charAt(i);
            if (!hash.containsKey(ch)) {
                hash.put(ch, 1);
            } else {
                int temp = hash.get(ch);
                hash.put(ch, ++temp);
            }
            end++;
            // move start forward if number of unique characters is greater than m
            while (!isLessThanM(hash, m)) {
                int temp = hash.get(s.charAt(start));
                hash.put(s.charAt(start), --temp);
                start++;
            }
            if (end - start + 1 > windowSize) {
                windowSize = end - start + 1;
                windowStart = start;
            }
        }
        return s.substring(windowStart, windowStart + windowSize);
 
    }
 
    public static boolean isLessThanM(HashMap<Character, Integer> hash, Integer m) {
        int count = 0;
        for (Character key : hash.keySet()) {
            if (hash.get(key) > 0)
                count++;
            if(count > m) {
                return false;
            }
        }
 
        return true;
    }
 
    public static void main(String args[]) throws Exception {
        System.out.println(getLongestSubstringWithMUniqueCharacters("karappa", 3));
    }
}