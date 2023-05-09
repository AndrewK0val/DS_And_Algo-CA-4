package models;
import utils.*;
import org.controlsfx.tools.Utils;
import utils.AdjacencyMatrix;

public class GraphNodeAM<T> {
    public T data;
    AdjacencyMatrix mat;

    String dataString = convertObjectToString(data);

    public int nodeId;
    public static String convertObjectToString(Object obj) {
        if (obj == null) {
            return "null";
        }

        if (obj instanceof String) {
            return (String) obj;
        }

        if (obj instanceof Integer) {
            return Integer.toString((int) obj);
        }

        if (obj instanceof Double) {
            return Double.toString((double) obj);
        }

        // Add additional checks and conversions for other types as needed

        return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
    }

    public GraphNodeAM(T data, AdjacencyMatrix mat){
        this.data=data;
        this.mat=mat;
        mat.nodes[nodeId=mat.nodeCount++]=this; //Add node to incidence matrix and record id
        nodeId = parseId(dataString);
    }

    private int parseId(String dataString) {
        String[] tokens = dataString.split(",");
        for (String token : tokens) {
            if (token.trim().startsWith("id=")) {
                return Integer.parseInt(token.trim().substring(3));
            }
        }
        return -1; // Return -1 if no ID is found. You can handle this error as needed.
    }

    public void connectToNodeDirected(GraphNodeAM<T> destNode){
        mat.adjMat[nodeId][destNode.nodeId]=true;
    }

    public void connectToNodeUndirected(GraphNodeAM<T> destNode){
        mat.adjMat[nodeId][destNode.nodeId]=mat.adjMat[destNode.nodeId][nodeId]=true;}

}
