package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


public class WktWriterTest {
     
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testWriter(){
		
        List <Point> points = new ArrayList<>();
        Coordinate coords = new Coordinate(1.0,2.0);
        Coordinate coords2 = new Coordinate(3.0,4.0);
        Point p = new Point(coords);
        Point p2 = new Point(coords2);
        points.add(p);
        points.add(p2);
        LineString l = new LineString(points);

        WktWriter writer = new WktWriter();

        Assert.assertEquals("POINT(1.0 2.0)", writer.write(p));	
        Assert.assertEquals("LINESTRING( (1.0 2.0) (3.0 4.0) )", writer.write(l));	

        
	}
}
