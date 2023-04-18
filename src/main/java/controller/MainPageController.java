package controller;
// Backslash for Shane to copy --------------> \ <-----------------
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import models.Station;

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

    public static void main(String[] args)
     {
        String CSVStations = "src/main/resources/CSV/stations.csv"; //pre defining location of the csv file I want to read
        String CSVRoutes = "src/main/resources/CSV/routes.csv"; //local variable for csv file of routes
        String CSVDefinitions = "src/main/resources/CSV/line definitions.csv"; //local variables for csv file for line definitions
        String line = "";
        try {
            BufferedReader brStations = new BufferedReader(new FileReader(CSVStations)); //set up a new buffer reader
            BufferedReader brRoutes = new BufferedReader(new FileReader(CSVRoutes)); //set up a new buffer reader
            BufferedReader brDef = new BufferedReader(new FileReader(CSVDefinitions)); //set up a new buffer reader
            String[] data = line.split(",");

            while ((line = brStations.readLine()) != null) //while this is not equal to null ...
            {
                System.out.println(line);


//                while() //GO left to write and read in each value until 'line' is 'null'
//                {
//                    System.out.println(data[Integer.parseInt(line)]); //print out the value at position 'line'
//                    line += 1; //move over to the next position
//                }

            }


//            while ((line = brRoutes.readLine()) != null) //while this is not equal to null ...
//            {
//                while(line != null)
//                {
//                    System.out.println(data[Integer.parseInt(line)]);
//                    line += 1;
//                }
//            }
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

        }
         catch (FileNotFoundException e) //exception for bufferreader
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e); //exception for file reader
        }
    }






}
