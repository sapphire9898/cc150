import javax.swing.tree.TreeNode;
import javax.xml.crypto.NodeSetData;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by yueyangzou on 16/1/7.
 */


    public class Tree{

        public Nodeself root;

        public Tree(){
            root = null;
        }
    public Tree(Nodeself d){
        root = d;
    }

        //class Nodeself
        class Nodeself{
            int iData;
            double dData;
            Nodeself leftChild=null;
            Nodeself rightChild=null;

            public Nodeself(int i,double d){
                iData = i;
                dData = d;
            }


            public void displayNode(){
                System.out.println('{');
                System.out.println(iData);
                System.out.println(',');
                System.out.println(dData);
                System.out.println('}');
            }
        }//end of class Node



        public Nodeself find(int key){
            Nodeself current = root;
            while(key!=current.iData){
                if(key<current.iData){
                    current = current.leftChild;
                }
                else{
                    current = current.rightChild;
                }
                if(current ==null){
                    return null;
                }
            }
            return current;
        }
        public Nodeself getSuccessor(Nodeself delNode){
            //find the smallest number of the larger numbers.
            if(delNode==null||delNode.rightChild==null)return delNode;
            Nodeself current = delNode.rightChild;
            Nodeself parent = current;
            while(current!=null){
                parent = current;
                current = current.leftChild;
            }
            return parent;
        }
        public void insert(int id,double dd){
            //find the position.
            if(root==null){
                root = new Nodeself(id,dd);
            }
            boolean rightornot = false;
            Nodeself parent = root;
            Nodeself current = root;
            while(current != null){
                if(current.iData<id){
                    parent = current;
                    current = current.leftChild;
                    rightornot = false;
                }
                else{
                    parent = current;
                    current = current.rightChild;
                    rightornot = true;
                }
            }
            if(rightornot)parent.rightChild = new Nodeself(id,dd);
            else parent.leftChild = new Nodeself(id,dd);
        }
/*
        public boolean delete(int key){
            //there is no child

            //there is one child

            //there is two children
        }
        */
        public void preOrder(Nodeself r){
            if(r!=null) {
                System.out.println(r.iData);
                preOrder(r.leftChild);
                preOrder(r.rightChild);
            }
        }
        public void inOrder(Nodeself r){
            if(r!=null) {
                inOrder(r.leftChild);
                System.out.println(r.iData);
                inOrder(r.rightChild);
            }
        }
        public void postOrder(Nodeself r){
            if(r!=null) {
                System.out.println(r.iData);
                postOrder(r.leftChild);
                postOrder(r.rightChild);
            }

        }
        public void traverse(int traverseType){
            switch (traverseType){
                case 1:
                    System.out.println("\nPreorder traversal: ");
                    preOrder(root);
                    break;
                case 2:
                    System.out.println("\nInorder traversal: ");
                    inOrder(root);
                    break;
                case 3:
                    System.out.println("\npostorder");
                    postOrder(root);
                    break;
            }
            System.out.println();
        }
         public boolean isBalanced(){

             return isBalanced1(this.root)!=-1;

          }
         private int isBalanced1(Nodeself root){
        if(root ==null)return 0;

        int left = isBalanced1(root.leftChild);
        int right = isBalanced1(root.rightChild);

        if(left==-1||right==-1||left-right>1){
            return -1;
        }
        return Math.max(left,right)+1;
        }

    public Nodeself minHeight (int[] Arr,int start,int end){
        if(end<start)return null;

        int middle = (start+end)/2;
        System.out.println(middle);
        Nodeself left = minHeight(Arr,start,middle-1);
        Nodeself right = minHeight(Arr,middle+1,end);

        Nodeself root = new Nodeself(Arr[middle],0);
        root.leftChild = left;
        root.rightChild = right;
        return root;
    }
    ArrayList<LinkedList<Nodeself>> createLevel(Nodeself root){
        ArrayList<LinkedList<Nodeself>> result = new ArrayList<>();
        LinkedList<Nodeself> current = new LinkedList<>();
        if(root!=null){
            current.add(root);
        }
        while(current.size()>0){
            result.add(current);
            LinkedList<Nodeself> parents = current;
            current = new LinkedList<Nodeself>();
            for(Nodeself parent: parents){
                if(parent.leftChild!=null){
                    current.add(parent.leftChild);
                }
                if(parent.rightChild!=null){
                    current.add(parent.rightChild);
                }
            }
        }

        return result;

    }

    public static void main(String[] args){
         Tree d = new Tree();
        d.insert(14,2);
        d.insert(41,2);
        d.insert(35,2);
        d.insert(12,2);
        d.insert(64,2);
        d.insert(90,2);
        d.insert(17,2);
        d.insert(25,2);

        d.traverse(2);
        System.out.println(d.isBalanced());





        int[] Arr = {1,2,3,4,5,6,7,8,9};
        Nodeself r = d.minHeight(Arr,0,8);
        Tree de = new Tree(r);
        de.traverse(2);

    }

}


