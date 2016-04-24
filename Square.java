/**
 * Created by yueyangzou on 16/1/14.
 */
public class Square {
    private int xleft;
    private int xright;
    private int ybottom;
    private int ytop;

    public Square(int a, int b, int c,int d){
        xleft = a;
        xright =b;
        ybottom = c;
        ytop = d;
    }
    public int[] getdata(){
        int[] en = {xleft,xright,ybottom,ytop};
        return en;
    }
    public int[] middle(){
        int[] en = new int[2];
        en[0] = (xleft+xright)/2;
        en[1] = (ybottom+ytop)/2;
        return en;
    }
    class line {
        double slope;
        double intercept;

        public line(double a ,double b){
            slope = a;
            intercept = b;
        }
    }

    public line findHalfLine(Square square2){
        int[] middle1 = middle();
        int[] middle2 = square2.middle();

        if(middle1[0]==middle2[0]){
            return new line(0,middle1[1]);
        }
        else if(middle1[1]==middle2[1]){
            return new line(Integer.MAX_VALUE,Integer.MAX_VALUE);
        }
        else{
            double slope = (middle1[1]-middle2[1])/(middle1[0]-middle2[0]);
            double intercept = middle1[1]-middle1[0]*slope;
            return new line(slope, intercept);
        }

    }
}
