package defaultpackage;

public class BuyAndSellStocks 
{
	public static int maxProfit(int[] prices) 
	{
		 int result=0;
	    if(prices==null||prices.length<=1)
	        return result;
	 
	    int min=prices[0]; 
	   
	 
	    for(int i=1; i<prices.length; i++){
	        result = Math.max(result, prices[i]-min);
	        min = Math.min(min, prices[i]);
	    }
	 
	    return result;
	}
	
	public static void main(String args[])
	{
		int[] prices ={1,5,-3,10,1};
		System.out.println(maxProfit(prices));
		
	}
}
