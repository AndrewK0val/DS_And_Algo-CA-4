package controller;
// Backslash for Shane to copy --------------> \ <-----------------
import javafx.scene.image.Image;
import models.GraphLink;
import models.GraphNode;
import models.Station;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TubeAPI {
private Image tubeImage;

private List<GraphNode<Station>> lisOfStations;
private ArrayList<GraphNode<Station>> stationNodes;
//private ArrayList<GraphLink<Route>>

    public TubeAPI()
    {
        this.tubeImage = new Image(getClass().getResourceAsStream("/com.example.londonunderground/london underground.gif"));
    }

    public void inputStartingStation(Station station){


    }

    public void inputDestinationStation(Station station){



    }





}






