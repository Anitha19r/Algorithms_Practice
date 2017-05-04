/*Use binary search to find the square root.
1. Initialize, start = 0, end = number, mid = (start+end)/2.
2. Set prevMid = 0, as the previous mid value.
3. Find diff = absolute difference between prevMid and mid.
4. While mid is not the square root of number (i.e. mid*mid != number) and difference diff is greater than 0.0005, 
repeat the following steps:
   a. If mid*mid > number, then the square root will be less than mid. So, set end = mid.
   b. Else, the square root will be greater than mid. So, set start = mid.
   c. Set prevMid = mid
   d. Re-evaluate mid  = (start+end)/2.
   e. Re-evaluate diff from prevMid and mid.
*/

public class SquareRoot {
 
    private static String findSquareRoot(int number) {
         
        Boolean isNegative = false;
        if(number < 0) {
            number = -number;
            isNegative = true;
        }
 
        if(number == 1) {
            return number + (isNegative ? "i" : "");
        }
 
        double start = 0;
        double end = number;
        double mid = (start+end)/2;
        double prevMid = 0;
        double diff = Math.abs(mid - prevMid);
        double precision = 0.0005;
 
        while((mid*mid != number) && (diff > precision)) {
            if(mid*mid > number) {
                end = mid;
            } else {
                start = mid;
            }
            prevMid = mid;
            mid = (start+end)/2;
            diff = Math.abs(mid - prevMid);
        }
         
        return mid + (isNegative ? "i" : "");
    }
 
    public static void main(String[] args) {
        int number = 2;
        System.out.println("Square root of " + number + " = " + findSquareRoot(number));
    }
}