import java.util.Stack;

/**
 * Created by ydm on 2017/6/14.
 *
 * LeetCode 20 Valid Parentheses
 * 给定义一个字符串  只包含 (,[,{,),],}
 * 判断括号匹配是否合法
 * 如:()合法  （]不合法
 */
public class ValidParentheses {
    public boolean ValidParentheses(String s){
        char[] strs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < strs.length;i++ ){
            if(strs[i] == '{' || strs[i] == '[' || strs[i] == '('){
                stack.push(strs[i]);
            }else{
                if(stack.size() == 0){
                    return false;
                }else{
                    Character top = stack.peek();
                    Character match  = null;
                    if(strs[i]  == ')'){
                        match = '(';

                    }else if(strs[i]  == '}'){
                        match = '{';
                    }else if(strs[i]  == ']'){
                        match = '[';
                    }
                    if (match != top){
                        return false;
                    }
                    stack.pop();
                }
            }

        }

        if (!stack.empty()){
            return false;
        }
        return true;
    }
    public static void main(String[] args){


        System.out.println(new ValidParentheses().ValidParentheses("{}}"));
    }
}
