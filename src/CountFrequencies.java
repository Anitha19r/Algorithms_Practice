/*
 * Algorithm 1:
Find frequency of elements 1 – n one by one using 2 loops:
1. Outer loop runs from i = 1 to n.
2. Inner loop calculates the count of i in the input array.
3. Print the count of i when inner loop ends.
Time Complexity: O(n^2)
Space Complexity: O(1)

Algorithm 2:
1. Create a count array of size n with all elements from index i = 0 to n-1 initialized to 0.Here, count[i] is count of i+1.
2. Traverse the array once. For i = 0 to n-1, increment count[input[i]-1] by 1.
3. Traverse count array and print count array.
Time Complexity: O(n)
Space Complexity: O(n)

Algorithm 3(Optimized):
1. Reduce all elements by 1 so that the elements are converted in the range 0 to n-1.
2. Traverse the input array. For i = 0 to n-1, add n to element at index (input[i]%n). After all the elements are completed, element at index i will be incremented by n*k where k is the number of times i occurs in the array.
3. Finally, print counts of elements and simultaneously convert the array back to original array.
a: Print count of i+1 as input[i]/n. 
b: Set input[i] = input[i]%n+1.
Time Complexity: O(n)
Space Complexity: O(1)
*/
             
public class CountFrequencies {
 
    // O(n^2) time and O(1) space
    public static void countFrequenciesNaive(int[] input) {
        int n = input.length;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (input[j] == i) {
                    count++;
                }
            }
            System.out.println(i + " " + count);
        }
    }
 
    // O(n) time and O(n) space
    public static void countFrequencies(int[] input) {
        int n = input.length;
        int[] count = new int[n];
 
        for (int i = 0; i < n; i++) {
            count[i] = 0;
        }
 
        for (int i = 0; i < n; i++) {
            count[input[i] - 1]++;
        }
 
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + " " + count[i]);
        }
    }
 
    // O(n) time and O(1) space
    public static void countfrequenciesEfficient(int input[]) {
 
        int n = input.length;
        for (int i = 0; i < n; i++) {
            input[i]--;
        }
 
        for (int i = 0; i < n; i++) {
            input[input[i] % n] += n;
        }
 
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " " + input[i] / n);
            // Change the element back to original value
            input[i] = input[i] % n + 1;
        }
    }
 
    public static void main(String[] args) {
        int[] input = { 2, 3, 3, 2, 5 };
        countfrequenciesEfficient(input);
    }
}