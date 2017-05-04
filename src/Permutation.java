public class Permutation {
    public int strStr(String haystack, String needle) {
        if(haystack.length() <needle.length()) return -1;
        boolean temp=true;
        int window=needle.length(), start=0, end =0;
        while (end<haystack.length()){
        	temp=true;
            end = start+window;
            for(int i=start,j=0; i<end; i++){
               if(haystack.charAt(i)!=needle.charAt(j)){
                temp=false;
                System.out.println("i="+i);
                System.out.println("j="+j);
                break;
                }
               j++;
           }
            if(temp) return end-window;
            start++;
        }
       if(!temp) return -1;
       else return end-window;
    }
    public static void main(String args[]){
    	Permutation p = new Permutation();
    	System.out.println(p.strStr("mississipi","a"));
    }
}