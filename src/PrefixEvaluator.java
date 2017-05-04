import java.util.ArrayDeque;
import java.util.Stack;

public class PrefixEvaluator {

    public static void main(String[] args) {
        String[] prefixStr = "* + 16 4        + 3 1 ".split(" ");
        Stack<Integer> stack = new Stack<>();
        for(int i=prefixStr.length-1;i>-1;i--){
            String s = prefixStr[i];
            if(s.equals("")){
                continue;
            }
            if(s.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }else if(s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        System.out.println(stack.pop());
    }

}/*
for (int i = 1; i < 1001; i++)
{
   array[i] = array[i] ^ array[i-1] ^ i;
}

printf("Answer : %d\n", array[1000]);
*/