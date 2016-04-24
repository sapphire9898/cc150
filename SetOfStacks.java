import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by yueyangzou on 16/1/6.
 */
public class SetOfStacks {
    ArrayList<Stack> stacks;

    public SetOfStacks(){

        stacks= new ArrayList<Stack>();
    }
    public static void main(String[] args){
        SetOfStacks newone = new SetOfStacks();
        newone.push(1);
        newone.push(2);
        newone.push(3);
        newone.push(4);
        newone.push(5);
        newone.push(6);
        newone.push(7);
        System.out.println(newone.pop());
        System.out.println(newone.pop());
        System.out.println(newone.pop());
        System.out.println(newone.pop());
        System.out.println(newone.pop());
        System.out.println(newone.pop());
        System.out.println(newone.pop());
        System.out.println(newone.pop());


    }
    public void push(int value){
        //if the last stack is full, create a new stack and push it onto.

        Stack last = getLastStack();
        if(last!=null&&!last.isFull()){
            last.push(value);
        }
        else {
            Stack s = new Stack(3);
            s.push(value);
            stacks.add(s);
        }

    }
    public int pop(){
       Stack last = getLastStack();
        if(last==null)return Integer.MAX_VALUE;
        int value = last.pop();
        if(last.size==-1) stacks.remove(stacks.size()-1);
        return value;
    }


    public Stack getLastStack(){
        if(stacks.size()==0){
            return null;
        }
        return stacks.get(stacks.size()-1);
    }

    class Stack{
        private int capacity;
        public int[] sta;
        public int size = -1;

        public Stack(int capacity){
             this.capacity = capacity;
             sta = new int[capacity];
        }

        public int pop(){
            if(isempty()){
                return Integer.MAX_VALUE;
            }
            else{
                int val = size;
                System.out.println(size);
                size--;

                return sta[val];

            }
        }
        public void push(int value){
            if(isFull()){
            }
            else{
                sta[++size]=value;
                //System.out.println(size);
            }

        }

        public boolean isFull(){
            return capacity==size+1;

        }
        public boolean isempty(){
            return size==-1;
        }

    }




}
