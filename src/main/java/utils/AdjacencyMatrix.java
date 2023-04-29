package utils;

import models.GraphNodeAM;

import java.lang.reflect.Array;

public class AdjacencyMatrix {
    public boolean[][] adjMat;
    public GraphNodeAM<?>[] nodes;
    public int nodeCount=0, edgeCount=0;

    public AdjacencyMatrix(int size) {
        adjMat = new boolean[size][size]; //All false values by default.
        nodes = (GraphNodeAM<?>[]) Array.newInstance(GraphNodeAM.class, size);
    }




}
