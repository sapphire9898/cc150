import java.util.Stack;

/**
 * Created by yueyangzou on 16/1/6.
 */
 class nodewithMin {
    public int idata;
    public int min;
    public nodewithMin(int data, int _min){
        idata = data;
        min = _min;
    }

}
//keep every  min in every node using an extra class.
 class stackwithMin2 extends Stack<nodewithMin> {
/* test case of class stackwithMin2
public static void main(String[] args){
stackwithMin2 a = new stackwithMin2();
a.push(9);
a.push(2);
a.push(6);
a.push(3);
a.push(2);
System.out.println(a.min());
}
*/

    public void push(int value) {
        int newmin = Math.min(value, min());
        super.push(new nodewithMin(value, newmin));

    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return peek().min;
    }

    public nodewithMin pop(){
        if(this.isEmpty())return null;
        return pop();
    }
}

public class stackwithMin extends Stack<Integer>{
    Stack<Integer> amin;
    public stackwithMin(){
        amin = new Stack<Integer>();
    }



    public void push(int value){
        super.push(value);
        if(value<min()){
            amin.push(value);
        }
    }

    public int min(){
        if(amin.isEmpty())return Integer.MAX_VALUE;
        else return amin.peek();
    }
    public Integer pop(){
        int value = super.pop();
        if(value == amin.peek()){
            amin.pop();
        }
        return value;
    }


}
