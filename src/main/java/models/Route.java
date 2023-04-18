package models;
import javafx.scene.paint.Color;
// Backslash for Shane to copy --------------> \ <-----------------
public class Route {
private int id;
private String routeName;
private Color color;
private int stripe;

    public Route(int id, String routeName, Color color, int stripe) {
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getStripe() {
        return stripe;
    }

    public void setStripe(int stripe) {
        this.stripe = stripe;
    }


}
