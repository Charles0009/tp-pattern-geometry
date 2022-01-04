package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


public class LogGeometryVisitorTest {
     
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testWriter() throws UnsupportedEncodingException{

    ByteArrayOutputStream os = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(os);
    LogGeometryVisitor visitor = new LogGeometryVisitor(out);


    List <Point> points = new ArrayList<>();
    Coordinate coords = new Coordinate(1.0,2.0);
    Coordinate coords2 = new Coordinate(3.0,4.0);
    Coordinate coords3 = new Coordinate(3.0,4.0);
    Point p = new Point(coords);
    Point p2 = new Point(coords2);
    Point p3 = new Point(coords3);
    points.add(p);
    points.add(p2);
    points.add(p3);
    LineString l = new LineString(points);

    p.accept(visitor);
    //l.accept(visitor);
    

    String result = os.toString("UTF8");

    Assert.assertEquals("Je suis un point avec x=1.0 et y=2.0\n", result);
    //Assert.assertEquals("Je suis une polyligne définie par 3 point(s)" , result);

    }
}
