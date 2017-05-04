 /*
  * Solution:
1: Iterate over the array using 2 loops. 
2: Initialize currentSum = 0, min = MAX_VALUE
3: Starting from array[i], keep adding array[i] to currentSum till currentSum != k or till last element of the array or size of current subarray becomes greater than min.
4: If currentSum == k update min.
5: Also keep track of start and end index of the min subarray obtained so far.
6: Print array elements from start to end.
  * 
  */
public class MinimumLengthSubArraySum {
  
    public static void main(String[] args) {
        int[] array = {2,3,1,2,4,3};
        int k = 7;
        printMinSubArrayWithSum(array, k);
    }
     
    public static void printMinSubArrayWithSum(int[] array, int k) {
          
        int start = -1;     // Start of min subarray
        int end = -1;       // End of min subarray
        int min = Integer.MAX_VALUE;    // size of the smallest subarray with sum = k
         
        for(int i = 0; i < array.length; i++) {
             
            int currentSum = 0;
            for(int j = i; j < array.length && (j-i+1) < min; j++) {        
                currentSum += array[j];
                if(currentSum == k) {
                    start = i;
                    end = j;
                    min = end - start + 1;
                    break;
                }            
            }    
        }
 
        if(start == -1 || end == -1)  {
            System.out.println("No subarray exists with sum = " + k);
            return ;
        }
 
        System.out.print("[ ");
        while(start <= end) {
            System.out.print(array[start] + " ");
            start++;;
        }       
        System.out.println("]");
    }
 
}
        