package models;

public class GraphNode<T> {
        public T data;
        public GraphLink mat;
        public int nodeId;
        public GraphNode(T data,GraphLink mat){
            this.data=data;
            this.mat=mat;
            mat.nodes[nodeId=mat.nodeCount++]=this; //Add node to incidence matrix and record id
        }
        public void connectToNode(GraphNode<T> destNode) {
//Set two entries in column to true to connect nodes
            mat.incedenceMatrix[nodeId][mat.edgeCount]=mat.incedenceMatrix[destNode.nodeId][mat.edgeCount++]=true;
        }

    }





