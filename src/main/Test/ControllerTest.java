import com.example.londonunderground.controller.MainPageController;
import com.example.londonunderground.models.StationNew;
import com.example.londonunderground.utils.GraphNodeAL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest {
    @Test
    public void testPopulateAdjacencyListsForEachNode() {
        // Create an instance of the MainPageController
        MainPageController controller = new MainPageController();

        // Prepare the data for testing
        int[][] connections = {
                {1, 2},
                {2, 3},
                {3, 4}
        };

        // Assuming you have a populated stationNodeList
        // You may need to mock or create test data for this list

        // Set the connections in the controller
//        controller.setConnections(connections);

        // Call the method to populate adjacency lists
        controller.populateAdjacencyListsForEachNode();

        // Perform assertions to verify the results

        // Assuming you have a way to retrieve a station node by ID
//        GraphNodeAL<StationNew> station1Node = controller.getStationNodeById(1);
//        GraphNodeAL<StationNew> station2Node = controller.getStationNodeById(2);
//        GraphNodeAL<StationNew> station3Node = controller.getStationNodeById(3);
//        GraphNodeAL<StationNew> station4Node = controller.getStationNodeById(4);
//
//        // Check the connections between stations
//        assertTrue(station1Node.isConnectedToNode(station2Node));
//        assertTrue(station2Node.isConnectedToNode(station1Node));
//
//        assertTrue(station2Node.isConnectedToNode(station3Node));
//        assertTrue(station3Node.isConnectedToNode(station2Node));
//
//        assertTrue(station3Node.isConnectedToNode(station4Node));
//        assertTrue(station4Node.isConnectedToNode(station3Node));
    }



}
