package Stacks;

import java.util.ArrayList;
import java.util.Stack;

class StockSpanner {
    Stack<Integer> stack;
    ArrayList<Integer> list;
    public StockSpanner() {
        stack = new Stack<>();
        list = new ArrayList<>();
    }

    public int next(int price) {
        int index = list.size();
        list.add(price);

        while(!stack.isEmpty() && list.get(stack.peek()) <= price){
            stack.pop();
        }

        int span = stack.isEmpty() ? index+1 : index-stack.peek();
        stack.push(index);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */