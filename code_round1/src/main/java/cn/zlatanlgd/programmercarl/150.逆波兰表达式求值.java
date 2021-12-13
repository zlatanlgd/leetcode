import java.util.ArrayDeque;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        // ArrayDeque<Integer> stack = new ArrayDeque<>();
        // for (String token : tokens) {
        //     char c = token.charAt(0);
        //     if (c == '+' || c == '-' || c == '*' || c == '/') {
        //         int num1 = stack.pop();
        //         int num2 = stack.pop();
        //         if (c == '+')
        //             stack.push(num1 + num2);
        //         if (c == '-')
        //             stack.push(num2 - num1);
        //         if (c == '*')
        //             stack.push(num2 * num1);
        //         if (c == '/')
        //             stack.push(num2 / num1);
        //     } else {
        //         stack.push(StoI(c));
        //     }
        // }
        // return stack.pop();
        Deque<Integer> stack = new ArrayDeque<>();
        for (String t : tokens) {
            switch (t){
                case "+": 
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int num = stack.pop();
                    stack.push(stack.pop() - num);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int num2 = stack.pop();
                    stack.push(stack.pop() / num2);
                    break;
                default:
                    stack.push(Integer.valueOf(t));
            }
        }
        return stack.pop();
    }
}
// @lc code=end
