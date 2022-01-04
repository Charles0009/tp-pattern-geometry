package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorPoint(){
		// TODO
        Coordinate coords = new Coordinate(3.0,4.0);
		Point p = new Point(coords);

        Coordinate c = p.getCoordinate();
        
        Assert.assertEquals(3.0, c.getX(), EPSILON);
		Assert.assertEquals(4.0, c.getY(), EPSILON);
        
	}

	@Test
	public void testConstructorPointIfEmpty(){
		// TODO
		Point p = new Point();        
        Assert.assertEquals(true, p.isEmpty());
        
	}

	@Test
	public void testConstructorPointIfCoordEmpty(){
		// TODO
        Coordinate coords = new Coordinate();
		Point p = new Point(coords);        
        Assert.assertEquals(true, p.isEmpty());
        
	}

	@Test
	public void testTranslation(){
		// TODO
        Coordinate coords = new Coordinate(3.0,4.0);
		Point p = new Point(coords); 
		p.translate(5.0,2.0); 
		Coordinate c = p.getCoordinate();

        Assert.assertEquals(8.0, c.getX(), EPSILON);
		Assert.assertEquals(6.0, c.getY(), EPSILON);
	}

	@Test
	public void testClone(){
        Coordinate coords = new Coordinate(3.0,4.0);
        Point p = new Point(coords);
        Point copy = p.clone();
        Coordinate coord_fin = copy.getCoordinate();
        Assert.assertEquals(coords.getX(), coord_fin.getX(),  EPSILON);

	}
	@Test
	public void testGetEnvelope(){
        Coordinate coords = new Coordinate(3.0,4.0);
        Point p = new Point(coords);
       
        Assert.assertEquals(3.0, p.getEnvelope().getXmax(),  EPSILON);
        Assert.assertEquals(4.0, p.getEnvelope().getYmax(),  EPSILON);

	}


}
