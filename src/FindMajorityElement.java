/*Algorithm 1:
Use 2 loops
In inner loop calculate the count of every element
In outer loop check, if count is greater than n/2, return the element.
If out of the loops, return null.
Time Complexity: O(n^2)

Algorithm2:
Sort the array
Again iterate over the array once and count occurrence of each element.
If an element is found with count is greater than n/2, return the element.
If no such element found, return null.
Time Complexity:
If O(nlogn) sorting algorithm is used, sorting step takes O(nlogn) time
Counting step takes O(n) time
Hence time complexity is O(nlogn)

Algorithm 3: Boyer-Moore Vote Algorithm
Step 1: Find a candidate for majority element.
Step 2: Check if this candidate is a majority element.
Step1:
Find the candidate for majority element
1: Initialize count of current candidate as 0, count = 0
2: Iterate over the array and do following steps:
(a) If count == 0, set candidate = array[i], count = 1
(b) Else (i) If candidate == array[i], set count = count + 1 (ii) else set count = count - 1
Step 2: 
Check if candidate is Majority Element
1: If count == 0, there is no majority element.
2: Else, iterate over array to get count of candidate. (a) If count is greater than n/2, return candidate (b) Else return null;
*/
import java.util.Arrays;
public class FindMajorityElement {
 
    // Boyer-Moore Vote Algorithm
    public static Integer getMajorityElement(int[] array) {
 
        if (array == null || array.length == 0) {
            return null;
        }
 
        // Step 1: Find max element
        Integer candidate = null;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                candidate = array[i];
                count = 1;
                continue;
            } else {
                if (candidate == array[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
 
        if (count == 0) {
            return null;
        }
 
        // Step 2: Check if candidate is majority element
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (candidate == array[i]) {
                count++;
            }
        }
        return (count > array.length / 2) ? candidate : null;
    }
 
    // Naive Algorithm
    public static Integer getMajorityElementNaive(int[] array) {
 
        if (array == null || array.length == 0) {
            return null;
        }
 
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
            if (count > array.length / 2) {
                return array[i];
            }
        }
        return null;
    }
 
    public static void main(String[] args) {
 
        int[] array = { 2, 6, 2, 2, 6, 2, 2, 8, 2, 1 };
        System.out.println(Arrays.toString(array) + " \nMajority Element: " + getMajorityElement(array));
 
    }
}
        