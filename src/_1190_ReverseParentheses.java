import java.util.Deque;
import java.util.LinkedList;

public class _1190_ReverseParentheses {
    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
