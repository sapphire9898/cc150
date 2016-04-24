import sun.awt.image.ImageWatched;

import java.util.HashMap;

/**
 * Created by yueyangzou on 15/12/29.
 * remember to redo the 2.7 with recursive approach and stack approach.
 */
public class Node {
    Node next = null;
    int idata;
    char cdata;
    public Node(){
        idata=0;
        cdata=' ';
    }



    public Node(int d,char c){
        cdata = c;
        idata = d;

    }

    public static void main(String[] args){
        Node LinkList = new Node(1,'A');
        LinkList.appendToTail(2,'B');
        LinkList.appendToTail(3,'C');
        LinkList.appendToTail(3,'D');
        LinkList.appendToTail(2,'E');
        LinkList.appendToTail(3,'C');

        Node a1 = new Node(0,'A');
        Node b2= new Node(1,'b');
        Node c3 = new Node(2,'C');
        Node d9 = new Node(3,'D');
        Node e3 = new Node(4,'E');

        a1.next = b2;
        b2.next = c3;
        c3.next = d9;
        d9.next = e3;
        e3.next = c3;

     //   Node a = LinkList.findLoopBe(a1);
     //   System.out.println(a.idata);




        Node LinkList2 = new Node(5,'F');
        LinkList2.appendToTail(9,'s');
        LinkList2.appendToTail(2,'t');

        // LinkList2.appendToTail(2,'O');


        Node LinkList1 = new Node(0,'F');
        LinkList1.appendToTail(7,'s');
       // LinkList1.appendToTail(1,'t');

      //  LinkList.printNode(LinkList1);
      //  LinkList.printNode(LinkList2);

      //  Node sum = LinkList.AddSumInorder(LinkList1,LinkList2);
      //  LinkList.printNode(sum);


        //LinkList.deleteNode(LinkList,3);
        //LinkList.printNode(LinkList);
        //LinkList.removeDups2(LinkList);
        //LinkList.printNode(LinkList);
        //LinkList.findKth(LinkList,4);
        //LinkList.printNode(LinkList);
        //Node newone = LinkList.getXless(LinkList,4);
        //newone.printNode(newone);





        /*
        test 2.7 of the easy way.
         */
        System.out.println(LinkList.checkPalindrome(LinkList));
    }


    public void appendToTail(int d,char c){
        Node end = new Node(d,c);
        Node n = this;
        while (n.next !=null){
            n = n.next;
        }
        n.next = end;
    }

    public Node deleteNode(Node head,int d){
        Node n = head;

        if(n.idata == d){
            return n.next;
        }
        while (n.next !=null){
            if(n.next.idata == d){
                n.next=n.next.next;
                return head;
            }
            n=n.next;
        }
        return head;
    }
    public void printNode(Node head){
        if(head == null){
            return;
        }
        while(head.next!=null){
            System.out.println(head.idata+"  "+head.cdata);
            System.out.println("\n");
            head=head.next;
        }
        System.out.println(head.idata+"  "+head.cdata);
        System.out.println("\n");
    }
//solve 2.1 using hashmap.
    public Node removeDups(Node head){
        HashMap<Character, Boolean> map = new HashMap<>();
        if(head==null)return null;
        Node previous = null;
        while(head!=null){
            if(map.containsKey(head.cdata)){
                previous.next = head.next;
            }
            else {
                map.put(head.cdata,true);
                previous = head;
            }
            head = head.next;
        }
        return head;
    }
//solve 2.1 without buffer.
    public Node removeDups2(Node head){
        // for every node, iterate from the following nodes and compare them.
        if(head==null)return null;
        Node previous = null;
        Node current1 = head;
        Node current2 = head.next;

        while(current1!= null){
            while(current2!=null){
                if(current1.cdata==current2.cdata){
                    previous.next=current2.next;
                }
                else{
                    previous = current2;
                    current2=current2.next;
                }
            }
            current1 = current1.next;
        }
        return head;
    }
    //solve 2.2
    public Node findKth(Node head,int k){
        Node first = head;
        Node second = head;
        while (k!=0){
            if(second==null)return null;
            second=second.next;
            k--;
        }
        while(second!=null){
            first = first.next;
            second = second.next;
        }
        System.out.println(first.cdata);
        return first;
    }
    //solve 2.3
    public void deleteMiddle(Node middle){
        if(middle==null||middle.next==null){
            return;
        }
        middle.idata = middle.next.idata;
        middle.next = middle.next.next;
        return;
    }
    //solve 2.4
    public Node getXless(Node head,int x){
        Node BeforeStart = null;
        Node BeforeEnd = null;
        Node AfterStart = null;
        Node AfterEnd = null;

        while(head != null){
            Node next = head.next;
            head.next = null;
            if(head.idata<x){
                if(BeforeEnd==null){
                    BeforeStart = head;
                    BeforeEnd = head;
                }else{
                    BeforeEnd.next = head;
                    BeforeEnd = head;
                }

            }
            else{
                if(AfterEnd ==null){
                    AfterStart = head;
                    AfterEnd = head;
                }
                else {
                    AfterEnd.next = head;
                    AfterEnd = head;
                }
            }
            if(BeforeEnd==null){
                return AfterStart;
            }
            else{
                BeforeEnd.next = AfterStart;
            }
            head = next;
        }
        return BeforeStart;
    }

    //solve 2.5
    public Node addsum(Node num1, Node num2){
        if(num1==null)return num2;
        if(num2==null)return num1;

        Node sum = null;
        Node current =null;
        int carry = 0;
        while(num1!=null||num2!=null) {
            int num1data = num1 == null ? 0 : num1.idata;
            int num2data = num2 ==null? 0:num2.idata;
            int sumdata = carry+num1data+num2data;

            carry = sumdata/10;
            if(sum==null){
                sum= new Node(sumdata%10,'f');
                current = sum;

            }else{
                Node Newone = new Node(sumdata%10,'n');
                current.next = Newone;
                current = current.next;
            }
            num1 = num1==null? num1:num1.next;
            num2 = num2==null? num2:num2.next;
        }
        if(carry>0){
            Node C = new Node(carry,'c');
            current.next = C;
        }
        return sum;
    }
    public class partialsum{
        Node a = null;
        int carry =0;

    }

    public Node AddSumInorder (Node num1, Node num2){
        int len1 = length(num1);
        int len2 = length(num2);
        if(len1<len2){
            num1 = padlist(num1,len2-len1);
        }
        else{
            num2 = padlist(num2,len1-len2);
        }
        partialsum sumresult = addsumhelper(num1,num2);
        if(sumresult.carry==0)return sumresult.a;

        else{
            Node sum = insertBefore(sumresult.a,sumresult.carry);
            return sum;
        }
    }

    public partialsum addsumhelper(Node num1, Node num2){
        if(num1==null||num2 ==null){
            partialsum newnode = new partialsum();
            return newnode;
        }
        partialsum newnode = addsumhelper(num1.next,num2.next);
        int val = newnode.carry+num1.idata+num2.idata;
        Node fullresult = insertBefore(newnode.a,val%10);

        newnode.carry = val/10;
        newnode.a = fullresult;
        return newnode;
    }
    public int length(Node num1){
        int length = 0;
        if(num1==null)return 0;
        else{

            while(num1!=null){
                length++;
                num1=num1.next;
            }
        }
        return length;
    }
    public Node padlist(Node num1, int len){
        Node current = num1;
        if(len<=0){
            return num1;
        }
        else{
            while(len!=0){
                current = insertBefore(current,0);
                len--;
            }
        }
        printNode(current);
        return current;
    }
    public Node insertBefore(Node num1,int inserta){
        Node newnode = new Node(inserta,'i');
        if(num1==null)return newnode ;
        else{
            newnode.next = num1;
        }
        return newnode;
    }
    //solve 2.6
    public Node findLoopBe(Node head){
        //set the fast pointer(2 steps) and slow pointer(1 step), until they meets.
        Node fast = head;
        Node slow = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow)break;
        }
        if(fast==null||fast.next==null)return null;
        //and then set the faster pointer to the head;
        fast = head;
        //until they meet, the node is the start of the loop.
        while(fast!=slow){
            fast = fast.next;
            slow= slow.next;
        }
        return slow;
    }
    //solve 2.7
    public boolean checkPalindrome (Node head){
        Node headnew = ReverseNode(head);
        while(head!=null){
            if(head.idata!=headnew.idata)return false;
            else{
                head = head.next;
                headnew = headnew.next;
            }
        }
        return true;
    }
    public Node ReverseNode (Node head){
        if(head==null)return null;
        Node newnode = null;


        while(head!=null){
            newnode = insertBefore(newnode,head.idata);
            head = head.next;
        }
        return newnode;
    }


}



