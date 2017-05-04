/*
 * Please checkout function inplaceMergeArrays(int[] arrayA, int[] arrayB) in code snippet for implementation details. The time complexity of this algorithm is O(n) with space complexity of O(1).

 */

public class MergeSortedArraysInplace 
{
    final static int INVALID_NUM = 0;
 
    public void inplaceMergeArrays(int[] arrayA, int[] arrayB)
    {
        // move all elements of arrayA with valid values towards the end
        int validNumIndex = arrayA.length - 1;
        for (int i = arrayA.length - 1; i >= 0; i--)
        {
            if (arrayA[i] != INVALID_NUM)
            {
                arrayA[validNumIndex] = arrayA[i];
                validNumIndex -= 1;
            }
        }
         
        // i: index of first valid valued element in arrayA
        int i = validNumIndex + 1;
        int j = 0, k = 0;
         
        // fill-up arrayA starting from 0th index since this end of arrayA is free now
        while ((i < arrayA.length) && (j < arrayB.length))
        {
            if (arrayA[i] < arrayB[j])
            {
                arrayA[k++] = arrayA[i++];
            }
            else
            {
                arrayA[k++] = arrayB[j++];
            }
        }
         
        // copy any remaining elements of smaller array into larger one 
        while (j < arrayB.length)
        {
            arrayA[k++] = arrayB[j++];
        }
    }
     
    public static void main(String[] args) 
    {
        MergeSortedArraysInplace solution = new MergeSortedArraysInplace();
         
         
        int[] arrayA = {-3, 5, INVALID_NUM, 7, INVALID_NUM, 10, INVALID_NUM, 11, INVALID_NUM};
        int[] arrayB = {-1, 2, 6, 12};
         
        solution.inplaceMergeArrays(arrayA, arrayB);
        for (int i = 0;  i < arrayA.length; i++)
        {
            System.out.print(arrayA[i] + ", ");
        }
    }
}
      