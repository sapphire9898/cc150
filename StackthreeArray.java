/**
 * Created by yueyangzou on 16/1/5.
 */
// solve 3.1
public class StackthreeArray{
    int stacksize = 3;
    int[] buffer = new int[stacksize*3];
    int[] stackPointer = {-1,-1,-1};

    public static void main(String[] args) throws Exception{
        StackthreeArray s = new StackthreeArray();
        s.push(1,1);
        s.push(2,4);
        s.push(1,2);
        s.push(2,5);
        s.push(1,3);
        s.push(2,6);

        System.out.println(s.pop(1));
        System.out.println(s.pop(1));
        System.out.println(s.pop(1));

    }

    public void push(int stackNum,int value) throws Exception{
        if(stackPointer[stackNum]+1>stacksize){
            throw new Exception("out of space");
        }
        //store the value into the position of num stack
        stackPointer[stackNum]++;
        buffer[abstop(stackNum)]=value;
    }
    public int pop(int stackNum) throws Exception{
        if(stackPointer[stackNum]<0){
            throw new Exception("empty");
        }
        stackPointer[stackNum]--;
        return buffer[abstop(stackNum)];
    }
    public int peek(int stackNum) throws Exception{
        if(stackPointer[stackNum]<0){
            throw new Exception("empty");
        }
        return buffer[abstop(stackNum)];

    }
    public int abstop(int stackNum){
        return stackNum*stacksize + stackPointer[stackNum];
    }



}

