package models;
// Backslash for Shane to copy --------------> \ <-----------------



public class Station
{
    public int id;

    private float longitude;

    private float latitude;

    public String name;

    public String displayName;

    public int zone;

    public int totalLines;

    public int rail;

    public Station(int id, float longitude, float latitude, String name, String displayName, int zone, int totalLines, int rail) {
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

    public int getZone() {
        return zone;
    }

    public int getTotalLines() {
        return totalLines;
    }

    public int getRail() {
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

    public void setZone(int zone) {
        this.zone = zone;
    }

    public void setTotalLines(int totalLines) {
        this.totalLines = totalLines;
    }

    public void setRail(int rail) {
        this.rail = rail;
    }

}
