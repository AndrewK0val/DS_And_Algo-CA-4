package models;
import javafx.scene.paint.Color;
// Backslash for Shane to copy --------------> \ <-----------------
public class Route {
private int id;
private String routeName;
private String color;
private boolean stripe;

    public Route(int id, String routeName, String color, boolean stripe) {
        this.id = id;
        this.routeName = routeName;
        this.color = color;
        this.stripe = stripe;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean getStripe() {
        return stripe;
    }

    public void setStripe(boolean stripe) {
        this.stripe = stripe;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", routeName='" + routeName + '\'' +
                ", color='" + color + '\'' +
                ", stripe=" + stripe +
                '}';
    }
}
