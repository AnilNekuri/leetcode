import java.util.Stack;

public class ValidParentheses {
    char[] op = {'(','{','['};
    char[] cp = {')','}',']'};
    public static void main(String[] args) {
        String s = "()[]{}";
        ValidParentheses v = new ValidParentheses();
        boolean isValid = v.isValid(s);
        System.out.println(isValid);
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(containsChar(op,c)){
                stack.push(c);
            }else if(containsChar(cp,c) && stack.size() > 0){
                char pop = stack.pop();
                if((c == ')' && pop != '(')
                || (c == ']' && pop != '[')
                || (c == '}' && pop != '{')){
                    return false;
                }
            }else{
                return false;
            }
        }
        return stack.size() == 0? true: false;
    }

    private boolean containsChar(char[] charr, char c){
        for (int i = 0; i < charr.length; i++){
            if(c == charr[i]){
                return true;
            }
        }
        return false;
    }
}
