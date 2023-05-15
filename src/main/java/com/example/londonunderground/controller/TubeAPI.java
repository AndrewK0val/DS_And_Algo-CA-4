package com.example.londonunderground.controller;
// Backslash for Shane to copy --------------> \ <-----------------
import com.example.londonunderground.utils.GraphNodeAL;
import javafx.scene.image.Image;
import com.example.londonunderground.models.Station;

import java.util.ArrayList;
import java.util.List;

public class TubeAPI {
private Image tubeImage;

private List<GraphNodeAL<Station>> lisOfStations;
private ArrayList<GraphNodeAL<Station>> stationNodes;
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






