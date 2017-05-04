public class FIndDuplicateInArray {
static int xorArray,dup;
public static void main(String args[]){
	//int[] _array = new int[]{1,2,6,3,4,5,6,7};
	int[] _array = new int[]{11,12,13,14,14,15,16};
	int duplicate = findWithXOR(_array);
	System.out.println("Duplicate : " + duplicate);
}
public static int findWithXOR(int[] input){
int xorArray=1;//,
int dup=0;
for(int i=2; i<=(input.length-1);i++){
xorArray = xorArray ^  i;
//System.out.println(“XOR : ” + xorArray);
}
System.out.println("XOR Array :  "+ xorArray);
for(int k=0;k<=input.length-1;k++){
xorArray = xorArray ^ input[k];
System.out.println(xorArray);
}
//System.out.println(“Duplicate : ” + dup);
return xorArray;
}
}