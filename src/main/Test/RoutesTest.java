import com.example.londonunderground.models.Route;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoutesTest {
    //creating a sample route
    Route route = new Route(1, "TestRoute", "Red", true);

    @Test
    public void testIdGetter(){
    //ensuring getter returns the correct value
        assertEquals(1, route.getId());
    }

    @Test
    public void testIdSetter(){
    //ensuring setter returns the correct value
        route.setId(2);
        assertEquals(2, route.getId());
    }

    @Test
    public void testRouteNameGetter(){
        //ensuring getter returns the correct value
        assertEquals("TestRoute", route.getRouteName());
    }

    @Test
    public void testRouteNameSetter(){
        //ensuring setter returns the correct value
        route.setRouteName("TestRoute");
        assertEquals("TestRoute", route.getRouteName());
    }
    @Test
    public void testColourGetter(){
        //ensuring getter returns the correct value
        assertEquals("Red", route.getColor());
    }

    @Test
    public void testColourSetter(){
        //ensuring setter returns the correct value
        route.setColor("Blue");
        assertEquals("Blue", route.getColor());
    }

    @Test
    public void testToString() {
        // Test the toString() method
        String expectedString = "Route{id=1, routeName='TestRoute', color='Red', stripe=true}";
        assertEquals(expectedString, route.toString());
    }
}
