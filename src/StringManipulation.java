import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StringManipulation implements Comparable <StringManipulation>
{
    
    public static final String SEPARATOR = "@";
    public String Ticker;
    public String Name;
    public String Quantity;
    double Price;
    double Value;
    double nav;
    static double total=0;
    /*
     * Complete the function below.
     *
 	 * Note: The questions in this test build upon each other. We recommend you
	 * copy your solutions to your text editor of choice before proceeding to
	 * the next question as you will not be able to revisit previous questions.
	 */

    static String printHoldings(String portfolioString) {
        
        ArrayList <StringManipulation> list1 = new ArrayList<StringManipulation>();
        ArrayList <StringManipulation> list2 = new ArrayList<StringManipulation>();
        ArrayList <StringManipulation> list3 = new ArrayList<StringManipulation>();

        String str[] = portfolioString.split(":");
        String portfolio[] = str[0].split("@");
        String benchmark[] = str[1].split("@");
        String a2[] = new String [3];
        String a1[] = new String [3];

        for(int j =0;j<portfolio.length;j++)
        {
          a1 = portfolio[j].split(",");
          a2 = benchmark[j].split(",");
          list1.add(new StringManipulation(a1[0],a1[1],a1[2]));
          list2.add(new StringManipulation(a2[0],a2[1],a2[2],Double.parseDouble(a2[3])));

        }
        
        
        Collections.sort(list1);
        Collections.sort(list2);
        int i =0;
     
        double t1=0.00;
        double t2=0.00;
        
        for(int x =0;x<portfolio.length;x++)
        {
          
            t1+=getValue(list1.get(x).Quantity,list2.get(x).Price);
            t2+=getValue(list2.get(x).Quantity,list2.get(x).Price);
        list3.add(new StringManipulation((list1.get(x).Ticker),(list1.get(x).Name),
        		(list1.get(x).Quantity),(list2.get(x).Price),getValue
        		(list1.get(x).Quantity,list2.get(x).Price)));

            
        }
        int z=0;
     
        
        for(StringManipulation b: list3)
        {   double check =((getValue(list2.get(z).Quantity,list2.get(z).Price))/t2)*t1;
        	
        double check2 = (check-b.Value);
        	
        	
        	double finalHolding;
        	if(check>b.Value)
        			
        			b.Name = "BUY";	
        	else
        		b.Name="SELL";
        	
        	finalHolding=check2/(list2.get(z).Price);
        			
        		System.out.print("["+b.Name+", "+ b.Ticker+ ","+String.format("%.2f",finalHolding)+"]");
            
            if(z<list1.size()-1)
            {
                System.out.print(", ");
            }
            z++;
            
        }
        
        
        
        
        return list1.toString();
        
        
    }
        
        StringManipulation(String t, String n, String q)
        {
            Ticker =t;
            Name = n;
            Quantity =q;
        }
        
        StringManipulation(String t, String n, String q, double p)
        {
            Ticker =t;
            Name = n;
            Quantity =q;
            Price = p;
        }
          
        StringManipulation(String t, String n, String q, double p,double na)
        {
            Ticker =t;
            Name = n;
            Quantity =q;
            Price = p;
            Value = na;
        }
          
        public static double getValue(String q,Double p)
        {
        	return (Double.parseDouble(q)*p);
        	
        }
        public static double getnav(Double val)
        {
        	return ((val/total*100));
        	
        }
        public String getTicker()
        {
            return Ticker;
        }

        
        public int compareTo(StringManipulation o)
        {
            String a = ((StringManipulation)o).getTicker();
            return this.getTicker().compareTo(a);
        }
    
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String res;
        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }
        res = printHoldings(_input);
        //System.out.println(res);
    }
}