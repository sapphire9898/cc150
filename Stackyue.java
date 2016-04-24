/**
 * Created by yueyangzou on 16/1/5.
 */
import java.util.Stack;
public class Stackyue {
    queueself qdogs = new queueself();
    queueself qcats = new queueself();

    public Node findDC(char c){
        if(c==' '){
            Node acats = qcats.isEmpty()?null:qcats.dequeue();
            Node adogs = qdogs.isEmpty()?null:qdogs.dequeue();
            int catda = acats==null?0:acats.idata;
            int dogda = adogs==null?0:adogs.idata;
            return catda<dogda?acats:adogs;
        }
        else if(c=='c'){
            if(!qcats.isEmpty())return qcats.dequeue();
        }
        else if(c=='d'){
            if(!qdogs.isEmpty())return qdogs.dequeue();
        }
        return null;

    }

    public void add(char c,int value){
        if(c=='c'){
            qcats.enqueue(value,c);
        }
        else if(c=='d'){
            qdogs.enqueue(value,c);
        }
    }
    public static void main(String[] args){
        Stackyue catsdogs = new Stackyue();
        catsdogs.add('c',1);
        catsdogs.add('c',3);
        catsdogs.add('c',5);
        catsdogs.add('c',7);
        catsdogs.add('c',9);
        catsdogs.add('c',11);

        catsdogs.add('d',2);
        catsdogs.add('d',4);
        catsdogs.add('d',6);
        catsdogs.add('d',8);
        catsdogs.add('d',10);

        Node a = catsdogs.findDC('d');
        System.out.println(a.idata);

    }

    class Stackself {
         private Node top;

         public int pop(){
            if(top==null)return 0;
            else{
                int a = top.idata;
                top = top.next;
                return a;
            }
        }
        public void push(int a){
            Node t = new Node(a,' ');
            t.next = top;
            top = t;

        }
        public int peek(){
            return top.idata;
        }

    }

    class queueself{
        Node first, last;
        public void enqueue(int b, char a){
            if(first ==null){
                first = new Node(b,a);
                last = first;

            }
            else{
                last.next = new Node(b,a);
                last = last.next;
            }
        }
        public Node dequeue(){
            if(first ==null){
                return null;
            }
            Node a = first;
            first = first.next;
            return a;
        }
        public boolean isEmpty(){
            return first==null;
        }
    }


    }






