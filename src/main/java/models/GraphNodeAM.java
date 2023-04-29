package models;

import utils.AdjacencyMatrix;

public class GraphNodeAM<T> {
    public T data;
    AdjacencyMatrix mat;
    public int nodeId;

    public GraphNodeAM(T data, AdjacencyMatrix mat){
        this.data=data;
        this.mat=mat;
        mat.nodes[nodeId=mat.nodeCount++]=this; //Add node to incidence matrix and record id
    }

    public void connectToNodeDirected(GraphNodeAM<T> destNode){
        mat.adjMat[nodeId][destNode.nodeId]=true;
    }

    public void connectToNodeUndirected(GraphNodeAM<T> destNode){
        mat.adjMat[nodeId][destNode.nodeId]=mat.adjMat[destNode.nodeId][nodeId]=true;}

    public void connect(){

    }

}
