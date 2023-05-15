import com.example.londonunderground.models.StationNew;
import org.junit.jupiter.api.Test;


import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StationNewTest {
    StationNew station = new StationNew(1, 37.7749f, -122.4194f, "Station 1", null , 0, 0);

        @Test
        public void testStationIdGetter() {
            assertEquals(1, station.getId());
        }

        @Test
        public void testLatitudeGetter() {
            assertEquals(37.7749f, station.getLatitude());
        }

        @Test
        public void testLongitudeGetter() {
            assertEquals(-122.4194f, station.getLongitude());
        }

        @Test
        public void testNameGetter() {
            assertEquals("Station 1", station.getName());
        }

        @Test
        public void testIfRailGetter(){
            assertTrue(station.isRail());
        }

        @Test
        public void testXGetter(){
            assertEquals(0, station.getX());
        }

        @Test
        public void testYGetter(){
            assertEquals(0, station.getY());
        }

        @Test
        public void testStationIdSetter() {
            station.setId(2);
        }

        @Test
        public void testLatitudeSetter() {
            station.setLatitude(38.9072f);
        }

        @Test
        public void testLongitudeSetter() {
            station.setLongitude(-77.0369f);
        }

        @Test
        public void testNameSetter() {
            station.setName("Station 2");
        }

        @Test
        public void testIfRailSetter(){
            station.setRail(false);
        }

        @Test
        public void testXSetter(){
            station.setX(10);
        }

        @Test
        public void testYSetter(){
            station.setY(20);
        }

        @Test
        public void testAddLineName() {

         // Add line names to the station
            station.addLineName("Line 1");
            station.addLineName("Line 2");

        // Retrieve the line names from the station
            List<String> lineNames = station.getLineNames();

        // Verify the line names
            List<String> expectedLineNames = Arrays.asList("Line 1", "Line 2");
            assertEquals(expectedLineNames, lineNames);
        }
}
