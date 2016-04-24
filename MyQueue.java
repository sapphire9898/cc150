import java.util.Stack;

/**
 * Created by yueyangzou on 16/1/7.
 */
public class MyQueue {
    private Stack<Integer> stack1,stack2;

    public MyQueue(){
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public int pop(){
        shift();
        if(stack2.isEmpty())return Integer.MAX_VALUE;
        else{
            return stack2.pop();
        }
    }
    public void push(int value){
        stack1.push(value);
    }
    public void shift(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
    }




}
