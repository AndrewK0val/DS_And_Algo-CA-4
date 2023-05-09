package controller;
// Backslash for Shane to copy --------------> \ <-----------------
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;
import models.GraphNode;
import models.GraphNodeAM;
import models.Route;
import models.Station;
import utils.AdjacencyMatrix;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.IntStream;

public class MainPageController {

    @FXML
    private Button ShortestDisButton;

    @FXML
    private ChoiceBox<?> avoidDropDown;

    @FXML
    private Button clearJourneyButton;

    @FXML
    private ChoiceBox<?> fromDropDown;

    @FXML
    private Button planJounreyButton;

    @FXML
    private ChoiceBox<?> stationDropDown;

    @FXML
    private ChoiceBox<?> toDropDown;

    private static int applyAsInt(int i) {
        return i + 1;
    }

    @FXML
    void calculateJourney(ActionEvent event) {

    }

    @FXML
    void calculateShortestPath(ActionEvent event) {

    }

    @FXML
    void clearJourney(ActionEvent event) {

    }

    private TubeAPI tubeAPI;
    ArrayList<Station> stations;
    ArrayList<int[][]> connections;
    ArrayList<Route> routes;

    AdjacencyMatrix am;

    public void initialize() {
        routes = new ArrayList<>();
        stations = new ArrayList<>();
        connections = new ArrayList<>();
        am = new AdjacencyMatrix(stations.size());
        pasreCSV();
//        putStationsInMatrix();

    }


// Marking Scheme
//------------------------------------------------------------
// Custom graph data structure/classes = 10%
// Generate any single valid route between two stations = 10%
// Generate multiple valid route permutations using DFS = 10%
// Shortest route using Dijkstra’s algorithm = 10%
// Shortest route with line/train change penalties using Dijkstra’s algorithm = 10%
// Illustrating Zone 1 routes on geographical map = 15%
// Waypoint support = 5%
// Avoiding specified stations = 5%
// JavaFX GUI = 10%
// JUnit testing = 5%
// JMH benchmarking of key methods = 5%
// General (overall completeness, structure, commenting, logic, etc.) = 5%

    public void pasreCSV() {
        String CSVStations = "src/main/resources/CSV/stations.csv"; //pre defining location of the csv file I want to read
        String CSVRoutes = "src/main/resources/CSV/routes.csv"; //local variable for csv file of routes
        String CSVDefinitions = "src/main/resources/CSV/line definitions.csv"; //local variables for csv file for line definitions
        String line = "";
//        this.stations = new ArrayList<Station>();
        try {
            BufferedReader brStations = new BufferedReader(new FileReader(CSVStations)); //set up a new buffer reader
            BufferedReader brRoutes = new BufferedReader(new FileReader(CSVRoutes)); //set up a new buffer reader
            BufferedReader brDef = new BufferedReader(new FileReader(CSVDefinitions)); //set up a new buffer reader
            //had to remove the top very top line from the CVS file because the method was trying to read numbers from text
            while ((line = brStations.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0] /*ID*/);
//                    System.out.println(id);
                float latitude = Float.parseFloat(data[1]/*latitude*/);
//                    System.out.println(latitude);
                float longitude = Float.parseFloat(data[2] /*longitude*/);
//                    System.out.println(longitude);
                String name = data[3/*name*/];
//                    System.out.println(name);
                String displayName = data[4 /*display name*/];
//                    System.out.println(displayName);
                float zone = Float.parseFloat(data[5]/*zone*/);
//                    System.out.println(zone);
                int totalLines = Integer.parseInt(data[6] /*total lines*/);
//                    System.out.println(totalLines);
                boolean rail = Boolean.parseBoolean(data[7] /*rail/no rail*/);
//                    System.out.println(rail);
                Station station = new Station(id, latitude, longitude, name, displayName, zone, totalLines, rail);
                stations.add(station);
//                System.out.println(station.toString());
//                System.out.println("\n ");
            }
            while ((line = brDef.readLine()) != null) {
                String[] data = line.split(",");
                int station1 = Integer.parseInt(data[0] /*station1*/);
//                System.out.println(station1);
                int station2 = Integer.parseInt(data[1] /*station2*/);
//                System.out.println(station2);
//                int lineID = Integer.parseInt(data1[2] /*lineID*/);
                connections.add(new int[][]{{station1, station2}});
                Station firstStation = returnStationFromID(station1);
                Station destStation = returnStationFromID(station2);
                connectStations(firstStation, destStation);

            }
            while ((line = brRoutes.readLine()) != null) {
                String[] data = line.split(",");
                int lineNumber = Integer.parseInt(data[0]);
                String lineName = data[1];
//                System.out.println(lineName);
                String lineColour = data[2];
//                System.out.println(lineColour);
                boolean ifContainsStripe = Boolean.parseBoolean(data[3]);
//                System.out.println(ifContainsStripe);
                Route route = new Route(lineNumber, lineName, lineColour, ifContainsStripe);
                System.out.println(route.toString());
                routes.add(route);
            }
//
//
//            while ((line = brDef.readLine()) != null) //while this is not equal to null ...
//            {
//                while(line != null)
//                {
//                    System.out.println(data[Integer.parseInt(line)]);
//                    line += 1;
//                }
//
//            }
        } catch (FileNotFoundException e) //exception for bufferreader
        {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e); //exception for file reader
        }
    }

    public void printStations() {
//        pasreCSV();
        for (int i = 0; i < stations.size(); i++) {

            System.out.println(stations.get(i).toString());
            //print the value pairs from the connections array list
            int station1 = connections.get(i)[0][0];
            int station2 = connections.get(i)[0][1];
            System.out.println(station1 + " " + station2);

        }
    }

//    public void putStationsInMatrix() {
//        for (int i = 0; i < stations.size(); i++) {
//            GraphNodeAM<Station> node = new GraphNodeAM<Station>(stations.get(i), am);
//            System.out.println(node.toString());
//        }
//    }

    public void connectStations(Station station1, Station station2){
//        for(int i =0; i<connections.size(); i++){
//            int station1 = connections.get(i)[0][0];
//            int station2 = connections.get(i)[0][1];
            GraphNodeAM<Station> node1 = new GraphNodeAM<>(station1, am);
            GraphNodeAM<Station> node2 = new GraphNodeAM<>(station2, am);
            node1.connectToNodeUndirected(node2);
            System.out.println(station1.name + " is connected to " + station2.name);
//        }
    }


//    public static void depthFirst(GraphNodeAM<?> start, List<GraphNodeAM<?>> pointsReached)
//    {
//        System.out.println(start);
//        if(pointsReached==null)
//        {
//         pointsReached = new ArrayList<>();
//        }
//
//        pointsReached.add(start);
//        for(GraphNodeAL<?> adjNode : from.adjList)
//        {
//            if(!pointsReached.contains(adjNode))
//            {
//            depthFirst(adjNode, pointsReached );
//            }
//        }
//    }


//    public static <T> List<GraphNodeAL<?>> breadthFirst(List<List<GraphNodeAL<?>>> agenda,List<GraphNodeAL<?>> encountered, T lookingfor)
//    {
//        if (agenda.isEmpty()) {
//            return null; //Search failed
//        }
//        List<GraphNodeAL<?>> nextPath = agenda.remove(0); //Get first item (next path to consider) off agenda
//        GraphNodeAL<?> currentNode = nextPath.get(0); //The first item in the next path is the current node
//        if (currentNode.data.equals(lookingfor)) {
//            return nextPath; //If that's the goal, we've found our path (so return it)
//        }
//        if (encountered == null) {
//            encountered = new ArrayList<>(); //First node considered in search so create new (empty)
//        }
//        encountered list
//        encountered.add(currentNode); //Record current node as encountered so it isn't revisited again
//        for (GraphNodeAL<?> adjNode : currentNode.adjList) //For each adjacent node
//        {
//            if (!encountered.contains(adjNode)) //If it hasn't already been encountered
//            {
//                List<GraphNodeAL<?>> newPath = new ArrayList<>(nextPath); //Create a new path list as a copy of the current/next path
//                newPath.add(0, adjNode); //And add the adjacent node to the front of the new copy
//                agenda.add(newPath); //Add the new path to the end of agenda (end->BFS!)
//            }
//            return breadthFirst(agenda, encountered, lookingfor); //Tail call
//        }
//
//        return nextPath;
//    }



    public Station returnStationFromID ( int id){
        for (int i = 0; i < stations.size(); i++) {
            if (stations.get(i).getId() == id) {
                return stations.get(i);
            }
        }
        return null;
    }
}
