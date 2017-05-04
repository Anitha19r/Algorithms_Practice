/*
Algorithm 1 (Naive):
For every element, iterate over array elements on the right to find the first element which is greater than the current element.
If the end of array is reached, then next greater element for the current element is null.
Time Complexity: O(n^2)
Space Complexity: O(1)

Algorithm 2 (Optimized):
Traverse the array once.
1: If the stack is empty or array[i] is less than stack.top, push the array[i] on the stack.
2: While array[i] is greater than stack.top, Pop top element & print 'Next Greater Element of top is array[i]'.
3: Push array[i] on the stack.
4: Repeat steps 2-3 till the end of array is reached.
5: Finally, print null as next greater element for all remaining stack elements.
Time Complexity: O(n)
Space Complexity: O(n)

*/
import java.util.Stack;
public class NextGreaterElement {
	 
    public static void printNextGreaterElement(int[] input) {
        Stack<Integer> stack = new Stack<Integer>();
        int inputSize = input.length;
        stack.push(input[0]);
        for (int i = 1; i < inputSize; i++) {
            while (!stack.isEmpty() && stack.peek() < input[i]) {
                System.out.println("Next greater element for "
                                    + stack.pop() + "\t = " + input[i]);
            }
            stack.push(input[i]);
        }
        while (!stack.isEmpty()) {
            int top = (int) stack.pop();
            System.out.println("Next greater element for " + top + "\t = " + null);
        }
    }
 
    public static void main(String[] args) {
        int[] input = { 98, 23,28,26, 54, 12, 20, 7, 27 };
        printNextGreaterElement(input);
    }
}