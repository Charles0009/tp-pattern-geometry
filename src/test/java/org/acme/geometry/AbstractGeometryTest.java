package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class AbstractGeometryTest {
    

    @Test
    public void testAbstract(){

        List <Point> points = new ArrayList<>();
        Coordinate coords = new Coordinate(1.0,2.0);
        Coordinate coords2 = new Coordinate(3.0,4.0);
        Point p = new Point(coords);
        Point p2 = new Point(coords2);
        points.add(p);
        points.add(p2);
        LineString l = new LineString(points);


        Assert.assertEquals("POINT(1.0 2.0)", p.asText());
        System.out.println(l.asText());
        Assert.assertEquals("LINESTRING((1.0 2.0) (3.0 4.0) )", l.asText());

    }
}
