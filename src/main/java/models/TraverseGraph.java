package models;
// Backslash for Shane to copy --------------> \ <-----------------
import java.util.ArrayList;
import java.util.List;

public class TraverseGraph
{


    //Regular recursive depth-first graph traversal
    public static void traverseGraphDepthFirst(GraphNode<?> from, List<GraphNode<?>> encountered )
    {
        System.out.println(from.data);
        if(encountered==null) encountered=new ArrayList<>(); //First node so create new (empty) encountered list
        encountered.add(from);
        for(int i=0;i<from.mat.edgeCount;i++) //Loop across row in incidence matrix
        {
            if (from.mat.incedenceMatrix[from.nodeId][i]) //Found a true entry in current column indicating an edge/link
            {
                for (int j = 0; j < from.mat.nodeCount; j++) //Loop down the column looking for the "other" true entry
                {
                    if (from.mat.incedenceMatrix[j][i] && j != from.nodeId && !encountered.contains(from.mat.nodes[j])) //Found it
                    {
                        traverseGraphDepthFirst(from.mat.nodes[j], encountered);
                    }
                }
            }
        }
    }


    //Agenda list based breadth-first graph traversal (tail recursive)
    public static void traverseGraphBreadthFirst(List<GraphNode<?>> agenda, List<GraphNode<?>> encountered )
    {
        if(agenda.isEmpty()) return;
        GraphNode<?> next=agenda.remove(0);
        System.out.println(next.data);
        if(encountered==null) encountered=new ArrayList<>(); //First node so create new (empty) encountered list
        encountered.add(next);
        for(int i=0;i<next.mat.edgeCount;i++) //Loop across row in incidence matrix
        {
            if (next.mat.incedenceMatrix[next.nodeId][i]) //Found a true entry in current column indicating an edge/link
            {
                for (int j = 0; j < next.mat.nodeCount; j++)
                { //Loop down the column looking for the "other" true entry
                    if (next.mat.incedenceMatrix[j][i] && j != next.nodeId && !encountered.contains(next.mat.nodes[j]) && !agenda.contains(next.mat.nodes[j]))
                     {
                        agenda.add(next.mat.nodes[j]); //Add children to end of agenda
                    }
                }
            }
        }
        traverseGraphBreadthFirst(agenda, encountered ); //Tail call
    }


    //Agenda list based depth-first graph traversal (tail recursive)
    public static void traverseGraphDepthFirst(List<GraphNode<?>> agenda, List<GraphNode<?>> encountered )
    {
        if(agenda.isEmpty()) return;
        GraphNode<?> next=agenda.remove(0);
        System.out.println(next.data);
        if(encountered==null) encountered=new ArrayList<>(); //First node so create new (empty) encountered list
        encountered.add(next);
        for(int i=0;i<next.mat.edgeCount;i++)//Loop across row in incidence matrix
        {
            if (next.mat.incedenceMatrix[next.nodeId][i]) //Found a true entry in current column indicating an edge/link
            {
                for (int j = 0; j < next.mat.nodeCount; j++) //Loop down the column looking for the "other" true entry
                {
                    if (next.mat.incedenceMatrix[j][i] && j != next.nodeId && !encountered.contains(next.mat.nodes[j]) && !agenda.contains(next.mat.nodes[j])) {
                        agenda.add(0, next.mat.nodes[j]); //Add children to front of
                    }
                }
            }
        }


        //agenda (order unimportant here)
        traverseGraphDepthFirst(agenda, encountered ); //Tail call
    }
}
