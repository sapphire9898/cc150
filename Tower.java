import java.util.Stack;

/**
 * Created by yueyangzou on 16/1/6.
 */
public class Tower {
    private Stack<Integer> disks;
    private int index;
    public Tower(int i){
        disks = new Stack<>();
        index = i;
    }
    public int getIndex() {
        return index;
    }
    public void add(int value){
        if(!disks.isEmpty()&&value>=disks.peek()) System.out.println("Error");
        else {
            disks.push(value);
        }
    }
    public void moveTopto(Tower ttt,Tower des){
        if(!ttt.disks.isEmpty()) {
            des.add(ttt.disks.pop());
            System.out.println("from "+ttt.getIndex()+" to"+des.getIndex());
        }


    }
    public void moveDisks(int n, Tower origin, Tower buffer, Tower dest){
        if(n==0)return;

        if(n>0) {
            moveDisks(n - 1, origin, dest, buffer);
            moveTopto(origin, dest);
            moveDisks(n - 1, buffer, origin, dest);
        }
    }
    public static void main(String[] args) {
        int n = 3;
        Tower[] towers = new Tower[n];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        for(int j = 2;j>=0;j--){
            towers[0].add(j);
        }

        towers[0].moveDisks(2,towers[0],towers[1],towers[2]);
    }

}
