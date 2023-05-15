package com.example.londonunderground.models;

import java.util.*;

public class StationNew {
    private int id;
    private float latitude;
    private float longitude;
    private String name;
//    private String displayName;
    private float zone;
    private int totalLines;
    private boolean rail;
    private List<String> lineNames;
    private String color;
    private int x;
    private int y;

    public StationNew(int id, float latitude, float longitude, String name, List<String> lineNames, int x, int y) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
//        this.displayName = displayName;
        this.zone = zone;
        this.totalLines = totalLines;
//        this.rail = rail;
        this.lineNames = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getZone() {
        return zone;
    }

    public void setZone(float zone) {
        this.zone = zone;
    }

    public int getTotalLines() {
        return totalLines;
    }

    public void setTotalLines(int totalLines) {
        this.totalLines = totalLines;
    }

    public boolean isRail() {
        return rail;
    }

    public void setRail(boolean rail) {
        this.rail = rail;
    }

    public List<String> getLineNames() {
        return lineNames;
    }

    public void setLineNames(List<String> lineNames) {
        this.lineNames = lineNames;
    }

    public String getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void addLineName(String lineName) {
        this.lineNames.add(lineName);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "StationNew{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", name='" + name + '\'' +
//                ", zone=" + zone +
//                ", totalLines=" + totalLines +
                ", rail=" + rail +
                ", lineNames=" + lineNames +
//                ", color='" + color + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
// ... getters and setters
}
