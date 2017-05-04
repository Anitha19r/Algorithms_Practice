import java.util.ArrayList;
import java.util.Arrays;

public class duplicate2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
    // TODO Auto-generated method stub

        int num[] = {1,2,3,3,4,63,65,66,67,68,69,70,80,90,91,94,95,4,101,102,75,76,71};

        int l = num.length;
        int i;
        System.out.print("Given number : ");
        for (i = 0;i < l;i++ ){
            System.out.print("  " + num[i]);
        }
        System.out.println("\n");
        Arrays.sort(num);

        ArrayList newArray = new ArrayList();
        newArray = getRanges(num);
        System.out.print("Range : ");
        for(int y=0;y<newArray.size();y++)
        {
            System.out.print(" " +newArray.get(y));
        }
    }

    public static ArrayList getRanges(int num[])
    {  
        ArrayList ranges = new ArrayList();
        int rstart, rend;   
        int lastnum = num[num.length-1];
        for (int i = 0; i < num.length-1; i++) 
        {     
            rstart = num[i];     
            rend = rstart;     
            while ((num[i + 1] - num[i] == 1) || num[i+1]==num[i]) 
            {       
                rend = num[i + 1]; 
                // increment the index if the numbers sequential       
                if(rend>=lastnum)
                {
                    break;
                }
                else
                {
                    i++;
                }  
            }  
            if(rstart==rend)
            {
                ranges.add(rend);
            }
            else
            {
                ranges.add(rstart+"-"+rend);
            }
        } 
        return ranges; 
    } 
}