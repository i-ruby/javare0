package work.iruby.nowcoder.jz;

import java.util.Stack;

public class JZ5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    static class Test {
        public static void main(String[] args) {
            JZ5 jz5 = new JZ5();
            jz5.push(1);
            jz5.push(2);
            jz5.push(3);
            System.out.println(jz5.pop());
            System.out.println(jz5.pop());
            jz5.push(4);
            System.out.println(jz5.pop());
            jz5.push(5);
            System.out.println(jz5.pop());
            System.out.println(jz5.pop());
        }
    }
}