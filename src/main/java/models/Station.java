package models;
// Backslash for Shane to copy --------------> \ <-----------------



public class Station
{
    public int id;

    private float longitude;

    private float latitude;

    public String name;

    public String displayName;

    public float zone;

    public int totalLines;

    public boolean rail;

    public Station(int id, float longitude, float latitude, String name, String displayName, float zone, int totalLines, boolean rail) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.displayName = displayName;
        this.zone = zone;
        this.totalLines = totalLines;
        this.rail = rail;
    }


    public int getId() {
        return id;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public float getZone() {
        return zone;
    }

    public int getTotalLines() {
        return totalLines;
    }

    public boolean getRail() {
        return rail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setZone(float zone) {
        this.zone = zone;
    }

    public void setTotalLines(int totalLines) {
        this.totalLines = totalLines;
    }

    public void setRail(boolean rail) {
        this.rail = rail;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", zone=" + zone +
                ", totalLines=" + totalLines +
                ", rail=" + rail +
                '}';
    }
}
