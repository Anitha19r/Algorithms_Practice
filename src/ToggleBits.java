
public class ToggleBits {
	public static void main(String args[]){
		int num =50;int soln = 0;
		if(num==0) 
			System.out.println("Toggled = " +1);
		else {
			int nextBit =1;
			while (num!=0){
				int lastBit = (num&1);
				if(lastBit==0){
					soln|=nextBit;
				}
				nextBit <<=1;
				num>>>=1;	
			}
			
		}
		System.out.println(soln);
	}

}
