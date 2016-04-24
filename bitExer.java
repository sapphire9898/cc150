import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by yueyangzou on 16/1/13.
 */
public class bitExer {

    boolean getBit(int num,int i){
        return ((num & 1<<i )!=0);
    }
    int setBit(int num,int i){
        return num | (1<<i);
    }
    int clearBit(int num,int i){
        int mask = ~(1<<i);
        return num & mask;
    }
    int clearBitMSBthroughI(int num, int i){
        int mask = (1<<i)-1;
        return num & mask;
    }
    int clearBitsIthrough0(int num, int i){
        int mask = ~((1<<(i+1))-1);
        return num & mask;
    }
    int updataBit(int num,int i, int v){
        int mask = ~(1<<i);
        return (num & mask) | (v<<i);
    }
    int fitBits(int N,int M,int i,int j){
        int allOnes = ~0;
        int left = allOnes<<(j+1);
        int right = ((1<<i)-1);
        int mask = left | right;

        int N1 = (N & mask) | (M<<i);
        return N1;
    }

    public String DecimaltoBinary (double c){
        if(c<=0 || c>=1){
            return "Error1";
        }
        StringBuilder binary = new StringBuilder();
        binary.append('.');
        while(c>0){
            if(binary.length() >= 32)return "Error2";
            double num=c*2;
            if(num>=1){
                binary.append('1');
                c = num-1;
            }
            else if (num<1){
                binary.append('0');
                c = num;
            }
        }
        return binary.toString();
    }
    public int count1s(int m){
        int n = 0;
        while(m>0){
            int re = m%2;
            m=m/2;//m=m>>1;
            if(re==1)n++;//count += m&1;
        }
        return n;
    }
    public int[] findMiLar(int m){
        int num = count1s(m);
        System.out.println(num);
        int mdeduce = m-1;
        int madd = m+1;
        int [] ans = new int[2];
        while(count1s(madd)!=num && madd<10000){
            madd++;
            ans[0]=madd;
        }
        while(count1s(mdeduce)!=num && mdeduce>0){

            mdeduce--;
            ans[1]=mdeduce;
        }
        System.out.println(madd+"is the larger number with "+ count1s(madd)+" 1s");
        System.out.println(mdeduce+"is the larger number with "+ count1s(mdeduce)+" 1s");
        return ans;
    }
    public int bitSwaprequired(int a,int b){
        int c = a^b;
        return count1s(c);
    }
    public int swapOddEvenBits(int x){
        return (((x & 0xaaaaaaaa)>>1)|((x & 0x55555555)<<1));
    }
    /*
   chapter 7: mathematical parts.
     */
    /*
    7.4 realizing the subtraction, multiply, divide operations based on addition.
     */
    public int negate(int a){
        int x = 0;
        int d = a>0?-1:1;
        while(a!=0){
            a+=d;
            x+=d;
        }
        return x;
    }
    public int subtracAB(int a, int b){
        return a+negate(b);
    }
    public int multiplyAB(int a,int b){
        if(a>b) return multiplyAB(b,a);

        int aabs = Math.abs(a);
        int sum = 0;

        while(aabs!=0){
            sum +=b;
            aabs--;
        }
        if(a<0){
            return negate(sum);
        }
        return sum;
    }
    public int divideAB(int a,int b){
        if(b==0)return Integer.MAX_VALUE;
        int aabs = Math.abs(a);
        int babs = Math.abs(b);

        int x = 0;
        int product = 0;

        while(product+babs<=aabs){
            product += babs;
            x++;
        }
        if((a<0&&b>0)||(a>0&&b<0)){
            return negate(x);
        }
            return x;
    }
    /*
    chapter 9  recursive and dynamic programming
     */
    //test of 9.1
    public int stairCase1(int n){
        if(n<0){
            return 0;
        }
        else if(n==0){
            return 1;
        }
        else {
            return stairCase1(n - 1) + stairCase1(n - 2) + stairCase1(n - 3);
        }
    }
    int[] newway = new int[100];
    public int stairCase2(int n){
        if(n<0)return 0;
        if(n==0)return 1;
        if(newway[n]>0)return newway[n];
        newway[n]= stairCase2(n-1)+stairCase2(n-2)+stairCase2(n-3);
        return newway[n];
    }
    public int findPossiblePath(int x,int y){
        if(x==0 && y==0)return 1;
        else if(x==0)return findPossiblePath(x,y-1);
        else if(y==0)return findPossiblePath(x-1,y);
        else {
            return findPossiblePath(x - 1, y) + findPossiblePath(x, y - 1);
        }
    }
    public int magicSlow(int[] array,int start,int end){
        if(end<start||start<0||end>=array.length){
            return -1;
        }
        int mid = (start + end)/2;
        if(array[mid]<mid){
            //go to the right side.
            return magicSlow(array,mid+1,end);
        }
        else if(array[mid]>mid){
            //go to the left side.
            return magicSlow(array,start,mid-1);
        }
        else{
            return mid;
        }
    }
    public ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> m,int index){
        ArrayList<ArrayList<Integer>> allsubsets;
        if(m.size()==index){
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
        }else {
            allsubsets = getAllSubsets(m,index+1);
            int item = m.get(index);
            ArrayList<ArrayList<Integer>> en = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset: allsubsets){
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                en.add(newsubset);
            }
            allsubsets.addAll(en);
        }
        return allsubsets;
    }

    public ArrayList<ArrayList<Integer>> getAllsubsets2(ArrayList<Integer> original){
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
        int max = original.size();
        int n = 1<<max;
        for(int i = 0;i<n;i++){
            ArrayList<Integer> newsubset = getSet(i,original);
            allsubsets.add(newsubset);
        }
        return allsubsets;
    }
    public ArrayList<Integer> getSet(int k,ArrayList<Integer> sets){
        ArrayList<Integer> set = new ArrayList<Integer>();
        int index = 0;
        for(;k>0;k>>=1){
            if((k&1)==1){
                set.add(sets.get(index));
            }
            index++;
        }
        return set;
    }
    public int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            n = swapbit(n, i, 32-i-1);
        }
        return n;
    }
    public int swapbit(int n, int i, int j) {
        int a = (n >> i)&1;
        int b = (n >> j)&1;

        if ((a ^ b) != 0) {
           n ^= (1 << i) | (1 << j);
        }
        return n;
    }





    public static void main(String[] args){
        bitExer Bitmanipulation = new bitExer();
        int N = 1<<10;
        int M = 3;

        System.out.println(Bitmanipulation.fitBits(N,M,2,6));

        System.out.println(Bitmanipulation.DecimaltoBinary(0.625));
        System.out.println(Bitmanipulation.count1s(1024));
        int[] e = new int[2];
        e=Bitmanipulation.findMiLar(24);
        System.out.println(e[0]);
        System.out.println(e[1]);
        System.out.println(Bitmanipulation.bitSwaprequired(31,14));
        System.out.println(Bitmanipulation.swapOddEvenBits(1));
        System.out.println(Bitmanipulation.multiplyAB(56,2));
        System.out.println(Bitmanipulation.divideAB(56,0));
        System.out.println(Bitmanipulation.subtracAB(56,2));
        System.out.println(Bitmanipulation.stairCase1(4));
        System.out.println(Bitmanipulation.stairCase2(4));
        System.out.println(Bitmanipulation.findPossiblePath(2,2));

    }



}
