package org.acme.geometry;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {
    
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorLineString(){

        List <Point> points = new ArrayList<>();
        Coordinate coords = new Coordinate(3.0,4.0);
		Point p = new Point(coords);
        points.add(p);
        LineString l = new LineString(points);       
        Assert.assertEquals("LineString",l.getType());
		Assert.assertEquals(1, l.getNumPoints());
        Assert.assertEquals(p, l.getPointN(0));
	}

    @Test
	public void testConstructorLineStringIfEmpty(){
        
        LineString l = new LineString();       
        Assert.assertEquals(true, l.isEmpty());
	}


    @Test
	public void testConstructorLineStringIfListpointEmpty(){
        List <Point> points = new ArrayList<>();
        LineString l = new LineString(points);       
        Assert.assertEquals(true, l.isEmpty());

	}

    @Test
	public void testTranslation(){
        List <Point> points = new ArrayList<>();
        Coordinate coords = new Coordinate(3.0,4.0);
        Point p = new Point(coords);
        points.add(p);
        LineString l = new LineString(points);  
        l.translate(5.0,2.0);
        Point point1 = l.getPointN(0);
        Coordinate coord_fin = point1.getCoordinate();

        Assert.assertEquals(8.0, coord_fin.getX(),  EPSILON);

	}

    @Test
	public void testClone(){
        List <Point> points = new ArrayList<>();
        Coordinate coords = new Coordinate(3.0,4.0);
        Coordinate coords2 = new Coordinate(1.0,2.0);
        Point p = new Point(coords);
        Point p2 = new Point(coords2);
        points.add(p);
        points.add(p2);
        LineString l = new LineString(points);  
        LineString copy = l.clone();
        Point point1 = copy.getPointN(0);
        Coordinate coord_fin = point1.getCoordinate();
        Assert.assertEquals(coords.getX(), coord_fin.getX(),  EPSILON);

	}

    @Test
	public void testGetEnvelope(){
        List <Point> points = new ArrayList<>();
        Coordinate coords = new Coordinate(1.0,2.0);
        Coordinate coords2 = new Coordinate(3.0,4.0);
        Point p = new Point(coords);
        Point p2 = new Point(coords2);
        points.add(p);
        points.add(p2);
        LineString l = new LineString(points); 

        Envelope env = l.getEnvelope();
       
        Assert.assertEquals(3.0, env.getXmax(),  EPSILON);
        Assert.assertEquals(4.0, env.getYmax(),  EPSILON);

	}




}

