import java.util.Stack;

/**
 * Created by yueyangzou on 16/1/7.
 */
public class stackSort extends Stack<Integer>{
    Stack<Integer> helper = new Stack<Integer>();
    public static void main(String[] args){
        stackSort a = new stackSort();

        a.push(5);
        a.push(2);
        a.push(7);
        a.push(99);
        a.push(3);
        a.push(34);
        a.push(0);
        a.push(1);

        Stack b=a.sorter();
        a.printstack(b);


    }

    public Stack sorter(){
        while(!isEmpty()) {
                int value = pop();
                while (!helper.isEmpty()&&value < helper.peek()) {
                    push(helper.pop());
                }
                helper.push(value);
        }
        return helper;
    }


    public void printstack(Stack stack){
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
