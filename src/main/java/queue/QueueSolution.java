package queue;

import java.util.Stack;

public class QueueSolution {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
        stack2.clear();

        for (int i = stack1.size() - 1; i >= 0; i--) {
            stack2.push(stack1.get(i));
        }
    }

    public int pop() {
        int result = stack2.pop();
        stack1.clear();
        for (int i = stack2.size() - 1; i >= 0; i--) {
            stack1.push(stack2.get(i));
        }
        return result;
    }


    public static void main(String[] args) {
        QueueSolution solution = new QueueSolution();
        for (int i = 0; i < 9; i++) {
            solution.push(i);
        }

        solution.pop();

        solution.push(11);

        for (int i = 0; i < 9; i++) {
            int a = solution.pop();
            System.out.print(" " + a);
        }
    }
}
