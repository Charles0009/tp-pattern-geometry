package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {
    

    @Test
    public void testDefaultConstructor(){

        WktVisitor visitor = new WktVisitor();
        WktVisitor visitor2 = new WktVisitor();

        List <Point> points = new ArrayList<>();
        Coordinate coords = new Coordinate(1.0,2.0);
        Coordinate coords2 = new Coordinate(3.0,4.0);
        Point p = new Point(coords);
        Point p2 = new Point(coords2);
        points.add(p);
        points.add(p2);
        LineString l = new LineString(points);

        p.accept(visitor);
        l.accept(visitor2);

        System.out.println(visitor.getResult());
        Assert.assertEquals("POINT(1.0 2.0)", visitor.getResult());
        Assert.assertEquals("LINESTRING((1.0 2.0) (3.0 4.0) )", visitor2.getResult());
    }

}
