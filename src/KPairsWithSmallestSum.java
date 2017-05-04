/*
import java.util.*;

public class KPairsWithSmallestSum 
{
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<int[]>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) 
            return list;
               k = Math.min(nums1.length * nums2.length, k);
        Comparator<int[]> cmp = new Comparator<int[]>(){
            public int compare(int[] a, int[] b) 
            {
                int sum1 = nums1[a[0]] + nums2[a[1]];
                int sum2 = nums1[b[0]] + nums2[b[1]];
                return sum1 - sum2;
            }
        };
        PriorityQueue<int[]> q = new PriorityQueue<int[]>(cmp);
       int j = Math.min(nums1.length,k);
        for(int i = 0; i < j; i++) {
            q.add(new int[]{i, 0});
        }
        while(!q.isEmpty() && list.size() <k) {
            int[] ind = q.poll();
            list.add(new int[]{nums1[ind[0]], nums2[ind[1]]});
            ind[1]++;
            if(ind[1] != nums2.length) q.add(ind);
        }
        return list;
    }
	public static void main(String args[]){
		int nums1[] = {1,2,3,4};
		int nums2[] = {1,2,3,4};
		int k=4;
		List<int[]> s= kSmallestPairs(nums1, int[] nums2, int k) ;
		
	}
}*/
