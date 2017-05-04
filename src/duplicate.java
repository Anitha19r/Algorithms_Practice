import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class duplicate {
    public static void main(String[] args) {
    // TODO Auto-generated method stub

    	String string = "hello how are you?";

    	/*char[] chars = string.toCharArray();
    	Set<Character> present = new HashSet<>();
    	int len = 0;
    	for (char c : chars)
    	    if (present.add(c))
    	        chars[len++] = c;
    	System.out.println(present.toString());
    	System.out.println(new String(chars, 0, len));*/
    	String str = string;
    	if (str == null || str.isEmpty()){
    		System.out.println("No");
        }

        final char[] chArray = str.toCharArray();
        final Set<Character> set = new LinkedHashSet<>();
        for (char c : chArray) {
            set.add(c);
        }

        final StringBuilder sb = new StringBuilder();
        for (Character character : set) {
            sb.append(character);
            break;
        }
        System.out.println(sb.toString());
    }}
    	
    	/*String str = string;
    	if (str == null || str.isEmpty()){
            return str;
        }

        final char[] chArray = str.toCharArray();
        final Set<Character> set = new LinkedHashSet<>();
        for (char c : chArray) {
            set.add(c);
        }

        final StringBuilder sb = new StringBuilder();
        for (Character character : set) {
            sb.append(character);
        }
        return sb.toString();
    }*/
    /*
     void remove_duplicate (char* str, int len) {
    unsigned int index = 0;
    int c = 0;
    int i = 0;
    while (c < len) {
        // this is just example more check can be added for
         //  capital letter, space and special chars 

        int pos = str[c] - 'a';
        if ((index & (1<<pos)) == 0) {
            str[i++] = str[c];
            index |= (1<<pos);
        }
        c++;
    }
    str[i] = 0;
}
     */

   
