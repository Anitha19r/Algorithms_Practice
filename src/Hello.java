import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class Hello{
	void removeDuplicates(String str)
    {
        LinkedHashSet<Character> lhs = new LinkedHashSet<>();
        for(int i=0;i<str.length();i++)
            lhs.add(str.charAt(i));
         
        // print string after deleting duplicate elements
        for(Character ch : lhs)
            System.out.print(ch);
    }
     
    /* Driver program to test removeDuplicates */
    public static void main(String args[])
    {
        String str = "hello, how are you?";
        Hello r = new Hello();
        r.removeDuplicates(str);
    }
/*public static void main(String args[]){
	String string = "hello, how are you?";

	char[] chars = string.toCharArray();
	Set<Character> present = new HashSet<>();
	int len = 0;
	for (char c : chars)
	    if (present.add(c))
	        chars[len++] = c;

	System.out.println(new String(chars, 0, len)); 
}*/
}
 
