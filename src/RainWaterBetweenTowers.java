/*Algorithm:
1: With given towerHeight array, create 2 arrays, maxSeenRight and maxSeenLeft.
   maxSeenLeft[i]  - max height on left side of Tower[i]. 
   maxSeenRight[i] - max height on right side of Tower[i].
2: Calculate for each tower: 
   rainwater = rainwater + Max(Min(maxSeenLeft[i], maxSeenRight[i]) - towerHeight[i], 0);
*/
    public class RainWaterBetweenTowers {
 
    public static int getMaxRainwaterBetweenTowers(int[] towerHeight) {
        int maxSeenSoFar = 0;
 
        int[] maxSeenRight = new int[towerHeight.length];
        int maxSeenLeft = 0;
 
        int rainwater = 0;
 
        for (int i = towerHeight.length - 1; i >= 0; i--) {
            if (towerHeight[i] > maxSeenSoFar) {
                maxSeenSoFar = towerHeight[i];
                maxSeenRight[i] = maxSeenSoFar;
            } else {
                maxSeenRight[i] = maxSeenSoFar;
            }
        }
 
        for (int i = 0; i < towerHeight.length; i++) {
            rainwater = rainwater + Integer.max(Integer.min(maxSeenLeft, maxSeenRight[i]) - towerHeight[i], 0);
            if (towerHeight[i] > maxSeenLeft) {
                maxSeenLeft = towerHeight[i];
            }
        }
 
        return rainwater;
    }
 
    public static void main(String[] args) {
        int[] towerHeight = { 1, 5, 2, 3, 1, 7, 2, 4 };
        System.out.println(getMaxRainwaterBetweenTowers(towerHeight));
    }
}