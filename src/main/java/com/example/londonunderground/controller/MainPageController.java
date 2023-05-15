package com.example.londonunderground.controller;
// Backslash for Shane to copy --------------> \ <-----------------
import com.example.londonunderground.models.Route;
import com.example.londonunderground.utils.GraphNodeAL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import com.example.londonunderground.models.Station;
import com.example.londonunderground.models.StationNew;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.shape.Line;

public class MainPageController {

    @FXML
    private Button ShortestDisButton;

    @FXML
    private ChoiceBox<?> avoidDropDown;

    @FXML
    private Button clearJourneyButton;

    @FXML
    private ChoiceBox<String> fromDropDown;

    @FXML
    private Button planJounreyButton;

    @FXML
    private ChoiceBox<?> stationDropDown;

    @FXML
    private ChoiceBox<String> toDropDown;

    private static int applyAsInt(int i) {
        return i + 1;
    }

    @FXML
    void calculateJourney(ActionEvent event) {

    }

    @FXML
    void calculateShortestPath(ActionEvent event)
    {
 //       depthFirst(fromDropDown.getSelectionModel().getSelectedItem(), List<GraphNodeAL> pointsReached);
    }

    @FXML
    void clearJourney(ActionEvent event) {

    }



    private TubeAPI tubeAPI;
    ArrayList<Station> stations;
    ArrayList<int[]> connections;
    ArrayList<Route> routes;
    List<GraphNodeAL> pointsReached;

//    ArrayList<GraphNodeAL<Station>> stationNodeList;
    ArrayList<GraphNodeAL<StationNew>> stationNodeList;
    ArrayList<StationNew> stationNewArrayList;


        public void initialize() {
            routes = new ArrayList<>();
            stations = new ArrayList<>();
            connections = new ArrayList<>();
            stationNodeList = new ArrayList<>();
            stationNewArrayList = new ArrayList<>();

    //        pasreCSV();
            parseStationsCSV();
            System.out.println(connections.size());
            parseLineDefCSV();
            parseRoutesCSV();
            for(int i = 0; i < stationNewArrayList.size(); i++) {
                fromDropDown.getItems().addAll(stationNewArrayList.get(i).getName());
                toDropDown.getItems().addAll(stationNewArrayList.get(i).getName());
            }
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

//focus on-------------------------------------------
// JavaFX GUI = 10%
// JUnit testing = 5%
// Custom graph data structure/classes = 10%
// Generate any single valid route between two stations = 10%
// Shortest route using Dijkstra’s algorithm = 10%



//    public void parseStationsCSV() {
//        String CSVStations = "src/main/resources/CSV/stations.csv";
//        String line = "";
//        try {
//            BufferedReader brStations = new BufferedReader(new FileReader(CSVStations)); //set up a new buffer reader
//            while ((line = brStations.readLine()) != null) {
//                String[] data = line.split(",");
//                int id = Integer.parseInt(data[0] /*ID*/);
////                    System.out.println(id);
//                float latitude = Float.parseFloat(data[1]/*latitude*/);
////                    System.out.println(latitude);
//                float longitude = Float.parseFloat(data[2] /*longitude*/);
////                    System.out.println(longitude);
//                String name = data[3/*name*/];
////                    System.out.println(name);
//                String displayName = data[4 /*display name*/];
////                    System.out.println(displayName);
//                float zone = Float.parseFloat(data[5]/*zone*/);
////                    System.out.println(zone);
//                int totalLines = Integer.parseInt(data[6] /*total lines*/);
////                    System.out.println(totalLines);
//                boolean rail = Boolean.parseBoolean(data[7] /*rail/no rail*/);
////                    System.out.println(rail);
//                Station station = new Station(id, latitude, longitude, name, displayName, zone, totalLines, rail);
////                stations.add(station);
//                stationNodeList.add(new GraphNodeAL(station));
////                System.out.println(station.toString());
////                System.out.println("\n ");
//            }
//        } catch (FileNotFoundException e) //exception for bufferreader
//        {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e); //exception for file reader
//        }
//    }

//    public void parseStationsCSV() {
//        String CSVStations = "src/main/resources/CSV/stationsNEW.csv";
//
//        String line = "";
//        try {
//            BufferedReader brStations = new BufferedReader(new FileReader(CSVStations));
//
//            int previousIndex = 0;
////            Map<Integer, StationNew> stationsMap = new HashMap<>();
//            while ((line = brStations.readLine()) != null) {
//            previousIndex++;
//                String[] data = line.split(",");
//                int id = Integer.parseInt(data[0] /*ID*/);
//                float latitude = Float.parseFloat(data[1]/*latitude*/);
//                float longitude = Float.parseFloat(data[2] /*longitude*/);
//                String name = data[3/*name*/];
////                String displayName = data[4 /*display name*/];
////                float zone = Float.parseFloat(data[5]/*zone*/);
////                int totalLines = Integer.parseInt(data[6] /*total lines*/);
//                boolean rail = Boolean.parseBoolean(data[4] /*rail/no rail*/);
//                String lineName = data[5] /*line_name*/;
//                String color = data[6] /*color*/;
//                int x = Integer.parseInt(data[7] /*x*/);
//                int y = Integer.parseInt(data[8] /*y*/);
//
////                StationNew station = stationsMap.get(id);
////                if (station == null) {
//                   StationNew station = new StationNew(id, latitude, longitude, name, rail, lineName, color, x, y);
//                   //if the previous station ID is the same as the ID of the current station, only add the line name to the station
//
//
////                   if(stationNodeList.get(previousIndex)){
////
////                   }
//                   stationNodeList.add(new GraphNodeAL<>(station));
//                    stationNewArrayList.add(station);
//                    System.out.println(station.toString());
////                    stationsMap.put(id, station);
////                }
////                station.addLineName(lineName);
////                station.setColor(color);
////                station.setX(x);
////                station.setY(y);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void parseStationsCSV() {
        String CSVStations = "src/main/resources/CSV/stationsNEW.csv";

        String line = "";
        try {
            BufferedReader brStations = new BufferedReader(new FileReader(CSVStations));

            Map<String, StationNew> stationMap = new HashMap<>();
            while ((line = brStations.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0] /*ID*/);
                float latitude = Float.parseFloat(data[1]/*latitude*/);
                float longitude = Float.parseFloat(data[2] /*longitude*/);
                String name = data[3/*name*/];
                String lineName = data[5] /*line name*/;
                int x = Integer.parseInt(data[7] /*x*/);
                int y = Integer.parseInt(data[8] /*y*/);

                StationNew station = stationMap.get(name);
                if (station == null) {
                    // If the station doesn't exist in the map, create a new StationNew object
                    station = new StationNew(id, latitude, longitude, name, new ArrayList<>(), x, y);
                    stationMap.put(name, station);
                }
                // Add the line name to the lineNames list of the StationNew object
                station.addLineName(lineName);
            }

            // Add all the StationNew objects to the stationNodeList and stationNewArrayList
            for (StationNew station : stationMap.values()) {
                stationNodeList.add(new GraphNodeAL<>(station));
                stationNewArrayList.add(station);
                System.out.println(station.toString());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void parseLineDefCSV() {
        String CSVDefinitions = "src/main/resources/CSV/line definitions.csv"; //local variables for csv file for line definitions
        String line = "";
        try {
            BufferedReader brDef = new BufferedReader(new FileReader(CSVDefinitions)); //set up a new buffer reader
            while ((line = brDef.readLine()) != null) {
                String[] data = line.split(",");
                int station1 = Integer.parseInt(data[0] /*station1*/);
//                System.out.println(station1);
                int station2 = Integer.parseInt(data[1] /*station2*/);
//                System.out.println(station2);
//                int lineID = Integer.parseInt(data1[2] /*lineID*/);
                connections.add(new int[]{station1, station2});
                // start with the ID of the first station (that is the current node ID), scan through the line def CSV
                // when the ID of the first station matches the ID of the current node, add the ID of the second station to the adjacency list


            }

        } catch (FileNotFoundException e) //exception for bufferreader
        {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e); //exception for file reader
        }
    }


//    public void populateAdjacencyListsForEachNode(){
//        for (int[] connection : connections) {
//            int station1 = connection[0];
//            int station2 = connection[1];
//            for (GraphNodeAL<Station> station : stationNodeList) {
//                if (station.data.getId() == station1) {
//                    for (GraphNodeAL<Station> stationAL : stationNodeList) {
//                        if (stationAL.data.getId() == station2) {
//                            station.connectToNodeUndirected(stationAL);
//                            System.out.println(station.data.getName() + " is connected to " + stationAL.data.getName());
//                        }
//                    }
//                }
//            }
//        }
        public void populateAdjacencyListsForEachNode(){
        for (int[] connection : connections) {
            int station1 = connection[0];
            int station2 = connection[1];
            //find common line between two stations

            for (GraphNodeAL<StationNew> station : stationNodeList) {
                if (station.data.getId() == station1) {
                    for (GraphNodeAL<StationNew> stationAL : stationNodeList) {
                        if (stationAL.data.getId() == station2) {
                            station.connectToNodeUndirected(stationAL);
                            System.out.println(station.data.getName() + " is connected to " + stationAL.data.getName());
                        }
                    }
                }
            }
        }
    }



    public void listConnectedStations(GraphNodeAL<Station> station){
        for (GraphNodeAL<Station> connectedStation : station.adjList) {
            System.out.println(connectedStation.data.getName());
        }
    }

    public void parseRoutesCSV(){
        String CSVRoutes = "src/main/resources/CSV/routes.csv"; //local variable for csv file of routes
        String line = "";
        try {
            BufferedReader brRoutes = new BufferedReader(new FileReader(CSVRoutes)); //set up a new buffer reader
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
        }
         catch (FileNotFoundException e) //exception for bufferreader
        {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e); //exception for file reader
        }
    }




//    public void pasreCSV() {
//        String CSVStations = "src/main/resources/CSV/stations.csv"; //pre defining location of the csv file I want to read
//        String CSVRoutes = "src/main/resources/CSV/routes.csv"; //local variable for csv file of routes
//        String CSVDefinitions = "src/main/resources/CSV/line definitions.csv"; //local variables for csv file for line definitions
//        String line = "";
////        this.stations = new ArrayList<Station>();
//        try {
//            BufferedReader brStations = new BufferedReader(new FileReader(CSVStations)); //set up a new buffer reader
//            BufferedReader brRoutes = new BufferedReader(new FileReader(CSVRoutes)); //set up a new buffer reader
//            BufferedReader brDef = new BufferedReader(new FileReader(CSVDefinitions)); //set up a new buffer reader
//            //had to remove the top very top line from the CVS file because the method was trying to read numbers from text
//            while ((line = brStations.readLine()) != null) {
//                String[] data = line.split(",");
//
//                int id = Integer.parseInt(data[0] /*ID*/);
////                    System.out.println(id);
//                float latitude = Float.parseFloat(data[1]/*latitude*/);
////                    System.out.println(latitude);
//                float longitude = Float.parseFloat(data[2] /*longitude*/);
////                    System.out.println(longitude);
//                String name = data[3/*name*/];
////                    System.out.println(name);
//                String displayName = data[4 /*display name*/];
////                    System.out.println(displayName);
//                float zone = Float.parseFloat(data[5]/*zone*/);
////                    System.out.println(zone);
//                int totalLines = Integer.parseInt(data[6] /*total lines*/);
////                    System.out.println(totalLines);
//                boolean rail = Boolean.parseBoolean(data[7] /*rail/no rail*/);
////                    System.out.println(rail);
//                Station station = new Station(id, latitude, longitude, name, displayName, zone, totalLines, rail);
//                stations.add(station);
////                System.out.println(station.toString());
////                System.out.println("\n ");
//            }
//            while ((line = brDef.readLine()) != null) {
//                String[] data = line.split(",");
//                int station1 = Integer.parseInt(data[0] /*station1*/);
////                System.out.println(station1);
//                int station2 = Integer.parseInt(data[1] /*station2*/);
////                System.out.println(station2);
////                int lineID = Integer.parseInt(data1[2] /*lineID*/);
//                connections.add(new int[]{station1, station2});
//            }
//            while ((line = brRoutes.readLine()) != null) {
//                String[] data = line.split(",");
//                int lineNumber = Integer.parseInt(data[0]);
//                String lineName = data[1];
////                System.out.println(lineName);
//                String lineColour = data[2];
////                System.out.println(lineColour);
//                boolean ifContainsStripe = Boolean.parseBoolean(data[3]);
////                System.out.println(ifContainsStripe);
//                Route route = new Route(lineNumber, lineName, lineColour, ifContainsStripe);
//                System.out.println(route.toString());
//                routes.add(route);
//            }
//
////            while ((line = brDef.readLine()) != null) //while this is not equal to null ...
////            {
////                while(line != null)
////                {
////                    System.out.println(data[Integer.parseInt(line)]);
////                    line += 1;
////                }
////
////            }
//        } catch (FileNotFoundException e) //exception for bufferreader
//        {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e); //exception for file reader
//        }
//    }

    public void prepareStationsForAdjacencyList() {
        for (int i = 0; i < connections.size(); i++) {
            int[] currentPair = connections.get(i);
//            System.out.println(currentPair[0] + ", " + currentPair[1]);
            int stationID1 = currentPair[0];
            int stationID2 = currentPair[1];
            Station station1 = returnStationFromID(stationID1);
            Station station2 = returnStationFromID(stationID2);
//            System.out.println("station 1: "+ station1.toString() + ", " +"station 2: " + station2.toString());
//            connectStations(station1, station2);
            GraphNodeAL<Station> node1 = new GraphNodeAL<>(station1);
            GraphNodeAL<Station> node2 = new GraphNodeAL<>(station2);
            node1.connectToNodeUndirected(node2);
            System.out.println(station1.name + " is connected to " + station2.name);
        }

//            int station1 = connections.get(i)[0][0];
//            int station2 = connections.get(i)[0][1];
            // return both values from connections array list
     }
//        for (int i = 0; i < stations.size(); i++) {
//
//
//            Station firstStation = returnStationFromID(station1);
//            Station destStation = returnStationFromID(station2);
//            connectStations(firstStation, destStation);
//        }




    public void printStations() {
        for (int i = 0; i < stationNodeList.size(); i++) {
            StationNew station = stationNodeList.get(i).data;
            System.out.println(station.toString());
        }
    }

//    public void putStationsInList() {
//        for (int i = 0; i < stations.size(); i++) {
//            GraphNodeAM<Station> node = new GraphNodeAM<Station>(stations.get(i), am);
//            System.out.println(node.toString());
//        }
//    }



    public static void depthFirst(GraphNodeAL<?> start, List<GraphNodeAL<?>> pointsReached)
    {
        System.out.println(start);
        if(pointsReached==null)
        {
         pointsReached = new ArrayList<>();
        }

        pointsReached.add(start);
        for(GraphNodeAL<?> adjNode : start.adjList)
        {
            if(!pointsReached.contains(adjNode))
            {
            depthFirst(adjNode, pointsReached );
            }
        }
    }

    //searching for point of interest
    public static <T> GraphNodeAL<?> searchPointOfInterest(GraphNodeAL<?> from, List<GraphNodeAL<?>> encountered, T lookingfor )
    {
        if(from.data.equals(lookingfor)) return from;
        if(encountered==null) encountered=new ArrayList<>(); //First node so create new (empty) encountered list
        encountered.add(from);
        for(GraphNodeAL<?> adjNode : from.adjList)
            if(!encountered.contains(adjNode)) {
                GraphNodeAL<?> result=searchPointOfInterest(adjNode,encountered, lookingfor );
                if(result!=null) return result;
            }
        return null;
    }


    public static <T> List<GraphNodeAL<?>> breadthFirst(List<List<GraphNodeAL<?>>> agenda,List<GraphNodeAL<?>> encountered, T lookingfor)
    {
        if (agenda.isEmpty()) {
            return null; //Search failed
        }
        List<GraphNodeAL<?>> nextPath = agenda.remove(0); //Get first item (next path to consider) off agenda
        GraphNodeAL<?> currentNode = nextPath.get(0); //The first item in the next path is the current node
        if (currentNode.data.equals(lookingfor)) {
            return nextPath; //If that's the goal, we've found our path (so return it)
        }
        if (encountered == null) {
            encountered = new ArrayList<>(); //First node considered in search so create new (empty)
        }
        encountered.add(currentNode); //Record current node as encountered so it isn't revisited again
        for (GraphNodeAL<?> adjNode : currentNode.adjList) //For each adjacent node
        {
            if (!encountered.contains(adjNode)) //If it hasn't already been encountered
            {
                List<GraphNodeAL<?>> newPath = new ArrayList<>(nextPath); //Create a new path list as a copy of the current/next path
                newPath.add(0, adjNode); //And add the adjacent node to the front of the new copy
                agenda.add(newPath); //Add the new path to the end of agenda (end->BFS!)
            }
            return breadthFirst(agenda, encountered, lookingfor); //Tail call
        }

        return nextPath;
    }


//    public class GraphNodeAL<T>
//    { //DIjkstras
//        public T data;
//        public int nodeValue=Integer.MAX_VALUE;
//        public List<GraphNodeAL> adjList=new ArrayList<>(); //Could use any concrete List implementation
//        public GraphNodeAL(T data) {
//            this.data=data;
//        }
//        public void connectToNodeDirected(GraphNodeAL<T> destNode,int cost) {
//            adjList.add(new GraphNodeAL(destNode,cost));
//        }
//        public void connectToNodeUndirected(GraphNodeAL<T> destNode,int cost) {
//            adjList.add(new GraphNodeAL(destNode,cost));
//            destNode.adjList.add(new GraphNodeAL(this,cost));
//        }
//
//        //GraphNodeAL origionally GraphLinkAL
//    }







    public Station returnStationFromID ( int id){
        for (int i = 0; i < stations.size(); i++) {
            if (stations.get(i).getId() == id) {
                return stations.get(i);
            }
        }
        return null;
    }

    public StationNew returnStationFromName(String name){
        for (int i = 0; i < stationNewArrayList.size(); i++) {
            if (stationNewArrayList.get(i).getName().equals(name)) {
                return stationNewArrayList.get(i);
            }
        }
        return null;
    }

    public void printConnections(StationNew station){

    }



    public void printConnectionsButton(){
        String stationName = fromDropDown.getSelectionModel().getSelectedItem();
        StationNew station = returnStationFromName(stationName);
        printConnections(station);
    }


    public void prepareStationsForAdjacencyMatrix(ActionEvent actionEvent) {
    }
}
