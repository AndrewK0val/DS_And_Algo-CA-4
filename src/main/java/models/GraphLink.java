package models;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GraphLink {
    public boolean[][] incedenceMatrix;
    public GraphNode<?>[] nodes;
    public int nodeCount=0, edgeCount=0;
    public GraphLink(int size){
        incedenceMatrix = new boolean [size][(size*(size-1))/2]; //All false values by default.
//Support max edges for a potential complete graph.
        nodes = (GraphNode<?>[]) Array.newInstance(GraphNode.class, size);
    }

    public static void LengthOfJourney()
    {
        int length = 0;
        ArrayList<String> stations = new ArrayList<>();
    }

}
