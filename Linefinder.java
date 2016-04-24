import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by yueyangzou on 16/1/14.
 */
public class Linefinder {
    ArrayList<point> points = new ArrayList<point>();

    class point{
        double x;
        double y;

        public point(double a, double b){
            x=a;
            y=b;
        }
    }
    class line {
        double slope;
        double intercept;

        public line(double a ,double b){
            slope = a;
            intercept = b;
        }
        public boolean isEquivalent(double a,double b){
            return Math.abs(a-b)<0.0000001;
        }
        public boolean isEquivalent(line linedd){
            if(isEquivalent(slope,linedd.slope)&& isEquivalent(intercept,linedd.intercept)){
                return true;
            }
            return false;
        }
    }
    public line findLinebetweenTwo(point a, point b){
        if(a.x==b.x){
            return new line(a.x,Double.MAX_VALUE);
        }
        double slope = (a.y - b.y)/(a.x - b.x);
        double intercept = a.y - a.x*slope;
        return new line(slope,intercept);
    }

   public void insertLine(HashMap<Double,ArrayList<line>> lineBySlope,line lined){
       ArrayList<line> lines = null;
       double key = floorTonear(lined.slope);
       if(!lineBySlope.containsKey(key)){
           lines = new ArrayList<line>();
           lineBySlope.put(key,lines);
       }else{
           lines = lineBySlope.get(key);
       }
       lines.add(lined);

   }
    public line getCommonLine(){
        line bestline = null;
        int bestCount = 0;
        HashMap<Double,ArrayList<line>> lineBySlope = new HashMap<Double,ArrayList<line>>();

        for(int i = 0;i<points.size();i++){
            for(int j = 0;j<points.size();j++){
                line linedd = findLinebetweenTwo(points.get(i),points.get(j));
                insertLine(lineBySlope,linedd);
                int count = countEquivlines(lineBySlope,linedd);
                if(count>bestCount){
                    bestline = linedd;
                    bestCount = count;
                }
            }
        }
        return bestline;
    }
    //compute the number of lines with the same slope as the linedd;
    public int countEquivalengLines(ArrayList<line> lines , line linedd){
        if(lines ==null)return 0;
        int count = 0;
        for(line parallellines: lines){
            if(parallellines.isEquivalent(linedd))count++;
        }
        return count;
    }

    //compute the number of lines with the same slope as the linedd in the hashmap.
    public int countEquivlines(HashMap<Double, ArrayList<line>> m,line linedd){
        double key = floorTonear(linedd.slope);
        double eps = 0.0000001;
        int count = countEquivalengLines(m.get(key),linedd)+countEquivalengLines(m.get(key-eps),linedd)+countEquivalengLines(m.get(key+eps),linedd);
        return count;
    }
    public double floorTonear(double d){
        int r = (int)(d/0.00001);
        return ((double)r)*0.00001;
    }

}
