import java.util.Stack;
public class decodeString {
     public static String decodeString(String s){
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                k=k*10+(ch - '0');
            }
            else if(ch == '['){
                countStack.push(k);
                stringStack.push(curr.toString());
                curr = new StringBuilder();
                k=0;

            }
            else if(ch == ']'){
                int repeat = countStack.pop();
                StringBuilder temp = new StringBuilder(stringStack.pop());
                for(int i =0;i<repeat;i++){
                    temp.append(curr);
                }
                curr = temp;
            }
            else{
                curr.append(ch);
            }
        }
        return curr.toString();     
    }
    public static void main(String[] args) {
        String s1 = "3[a]2[bc]";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + decodeString(s1));  // aaabcbc
}
}
