/**
 * Created by yueyangzou on 16/1/7.
 */
public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;


    public Graph(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int j =0; j<MAX_VERTS;j++){
            for(int k = 0;k<MAX_VERTS;k++){
                adjMat[j][k]=0;
            }
        }
    }

    public void addVertex(char lab){
        vertexList[nVerts++] = new Vertex(lab);
    }
    public void addEdge(int start,int end){
        adjMat[start][end]=1;
        adjMat[end][start]=1;
    }
    public void displayVertex(int v){
        System.out.println(vertexList[v].label);
    }
    public int getAdjUnvistedVertex(int v){
        for(int j=0; j<nVerts;j++){
            if(adjMat[v][j]==1 && vertexList[j].wasVisited==false){
                return j;
            }
        }
        return -1;
    }







    class Vertex{
        public char label;
        public boolean wasVisited;

        public Vertex(char lab){
            label = lab;
            wasVisited = false;
        }
    }

}
